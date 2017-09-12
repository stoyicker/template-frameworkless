package lrucache

internal class FIFOLRUCache<T>(maxCapacity: Int) : Cache<T>(maxCapacity) {
    private var delegate = emptyMap<String, Node<T>>()
    private var mostRecentlyUsed: Node<T>? = null
    private var leastRecentlyUsed: Node<T>? = null

    override fun put(key: String, value: T) {
        synchronized(delegate) {
            if (!delegate.containsKey(key) && delegate.size >= maxCapacity) {
                removeLeastRecentlyUsed()
                put(key, value)
            } else {
                val wrappedValue = Node(key, value, null)
                delegate += key to wrappedValue
                mostRecentlyUsed?.firstOneUsedAfterIt = wrappedValue
                mostRecentlyUsed = wrappedValue
                if (leastRecentlyUsed == null) {
                    leastRecentlyUsed = mostRecentlyUsed
                }
            }
        }
    }

    override fun get(key: String): T? {
        synchronized(delegate) {
            if (!delegate.containsKey(key)) {
                return null
            }
            val selected = delegate[key]!!
            if (selected == leastRecentlyUsed) {
                leastRecentlyUsed = leastRecentlyUsed?.firstOneUsedAfterIt
            } else {
                var current = leastRecentlyUsed!!
                while (current.firstOneUsedAfterIt != selected) {
                    current = current.firstOneUsedAfterIt!!
                }
                current.firstOneUsedAfterIt = selected.firstOneUsedAfterIt
            }
            mostRecentlyUsed!!.firstOneUsedAfterIt = selected
            mostRecentlyUsed = selected
            selected.firstOneUsedAfterIt = null
            return selected.value
        }
    }

    private fun removeLeastRecentlyUsed() {
        if (leastRecentlyUsed == null) {
            return
        }
        delegate -= leastRecentlyUsed!!.key
        leastRecentlyUsed = leastRecentlyUsed?.firstOneUsedAfterIt
    }

    private class Node<T>(val key: String, val value: T, var firstOneUsedAfterIt: Node<T>? = null)
}