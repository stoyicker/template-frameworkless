package lrucache

internal class FIFOLRUCache<T>(maxCapacity: Int) : Cache<T>(maxCapacity) {
    private var leastRecentlyUsed: Node<T>? = null
    private var mostRecentlyUsed: Node<T>? = null
    private var size = 0

    override fun put(key: String, value: T) {
        synchronized(this) {
            if (leastRecentlyUsed?.containsKey(key) != true && size >= maxCapacity) {
                removeLeastRecentlyUsed()
            }
            val wrappedValue = Node(key, value, null)
            if (mostRecentlyUsed == null) {
                mostRecentlyUsed = wrappedValue
                leastRecentlyUsed = wrappedValue
            } else {
                var current = leastRecentlyUsed
                if (key != leastRecentlyUsed!!.key) {
                    while (true) {
                        if (current == null || current.firstOneUsedAfterIt?.key == key) {
                            break
                        }
                        current = current.firstOneUsedAfterIt
                    }
                    current?.firstOneUsedAfterIt = current?.firstOneUsedAfterIt?.firstOneUsedAfterIt
                } else {
                    leastRecentlyUsed!!.firstOneUsedAfterIt = null
                }
                mostRecentlyUsed!!.firstOneUsedAfterIt = wrappedValue
                mostRecentlyUsed = wrappedValue
            }
            size++
        }
    }

    override fun get(key: String): T? {
        synchronized(this) {
            var beforeWhatWeAreAfter = leastRecentlyUsed
            if (key != leastRecentlyUsed!!.key) {
                while (true) {
                    if (beforeWhatWeAreAfter == null || beforeWhatWeAreAfter.firstOneUsedAfterIt?.key == key) {
                        break
                    }
                    beforeWhatWeAreAfter = beforeWhatWeAreAfter.firstOneUsedAfterIt
                }
            } else {
                leastRecentlyUsed!!.firstOneUsedAfterIt = null
            }
            if (beforeWhatWeAreAfter != null) {
                beforeWhatWeAreAfter.firstOneUsedAfterIt?.let {
                    mostRecentlyUsed?.firstOneUsedAfterIt = it
                    mostRecentlyUsed = it
                }
            }
            return beforeWhatWeAreAfter?.firstOneUsedAfterIt?.value
        }
    }

    private fun removeLeastRecentlyUsed() {
        synchronized(this) {
            if (leastRecentlyUsed == null) {
                return
            }
            leastRecentlyUsed = leastRecentlyUsed?.firstOneUsedAfterIt
        }
    }

    private class Node<T>(val key: String, val value: T, var firstOneUsedAfterIt: Node<T>? = null) {
        internal fun containsKey(key: String): Boolean = this.key == key ||
                firstOneUsedAfterIt?.containsKey(key) ?: false
    }
}