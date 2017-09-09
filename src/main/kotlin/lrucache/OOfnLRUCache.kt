package lrucache

internal class OOfnLRUCache<T : Any>(private val maxSizeItems: Int) {
    private var delegate = emptyMap<String, ValueWrapper<T>>()

    fun put(key: String, value: T) {
        synchronized(delegate) {
            if (!delegate.containsKey(key) && delegate.size >= maxSizeItems) {
                removeLeastRecentlyUsed()
                put(key, value)
            } else {
                delegate += key to ValueWrapper(value = value)
            }
        }
    }

    fun get(key: String): T? = delegate[key]?.get()

    fun remove(key: String) { delegate -= key }

    private fun removeLeastRecentlyUsed() {
        delegate.entries.fold("", { currentKey, entry ->
            val currentLRUValueWrapper = delegate[currentKey]
            if (currentLRUValueWrapper?.usage ?: Long.MAX_VALUE >= entry.value.usage) {
                currentKey
            } else {
                entry.key
            }
        }).let { delegate = delegate.minus(it) }
    }

    private class ValueWrapper<out T>(
            var usage: Long = System.currentTimeMillis(),
            private val value: T) {
        fun get(): T {
            usage = System.currentTimeMillis()
            return value
        }
    }
}