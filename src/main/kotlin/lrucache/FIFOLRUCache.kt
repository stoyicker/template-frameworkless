package lrucache

internal class FIFOLRUCache<T: Any>(private val maxSizeItems: Int) {
    private var delegate = emptyMap<Node, T>()
    private var mostRecentlyUsed: Node? = null
    private var leastRecentlyUsed: Node? = null

    fun put(key: String, value: T) {
        if (!delegate.containsKey(Node(key)) && delegate.size >= maxSizeItems) {
            removeLeastRecentlyUsed()
            put(key, value)
        } else {
            val wrappedKey = Node(key, mostRecentlyUsed)
            delegate += wrappedKey to value
            mostRecentlyUsed?.after = wrappedKey
            mostRecentlyUsed = wrappedKey
        }
    }

    fun get(key: String): T? {
        val boxedKey = Node(key)
        mostRecentlyUsed?.after = boxedKey
        mostRecentlyUsed = boxedKey
        return delegate[Node(key)]
    }

    fun remove(key: String) {
        if (!delegate.containsKey(Node(key))) {
            throw IllegalArgumentException("Key $key not found")
        }
        delegate -= Node(key)
        var current = leastRecentlyUsed
        do { current = current?.after } while (current != null && current.value != key)
        current?.after = current?.after?.after
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