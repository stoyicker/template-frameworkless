package lrucache

internal class FIFOLRUCache<T: Any>(maxCapacity: Int) : Cache<T>(maxCapacity) {
    private var delegate = emptyMap<Node, T?>()
    private var mostRecentlyUsed: Node? = null
    private var leastRecentlyUsed: Node? = null

    override fun put(key: String, value: T?) {
        synchronized(delegate) {
            if (!delegate.containsKey(Node(key)) && delegate.size >= maxCapacity) {
                removeLeastRecentlyUsed()
                put(key, value)
            } else {
                val wrappedKey = Node(key, mostRecentlyUsed)
                delegate += wrappedKey to value
                mostRecentlyUsed?.after = wrappedKey
                mostRecentlyUsed = wrappedKey
            }
        }
    }

    override fun get(key: String): T? {
        val boxedKey = Node(key)
        mostRecentlyUsed?.after = boxedKey
        mostRecentlyUsed = boxedKey
        return delegate[Node(key)]
    }

    private fun removeLeastRecentlyUsed() {
        leastRecentlyUsed = leastRecentlyUsed?.after
    }

    private class Node(val value: String, var after: Node? = null) {
        override fun equals(other: Any?): Boolean {
            return value == other
        }

        override fun hashCode(): Int {
            return value.hashCode()
        }
    }
}