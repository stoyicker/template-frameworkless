package lrucache

internal class OOfnLRUCache<T : Any>(maxCapacity: Int) : Cache<T>(maxCapacity) {
    private var delegate = emptyMap<String, ValueWrapper<T>?>()

    override fun put(key: String, value: T?) {
        synchronized(delegate) {
            if (!delegate.containsKey(key) && delegate.size >= maxCapacity) {
                removeLeastRecentlyUsed()
                put(key, value)
            } else {
                delegate += key to ValueWrapper(value = value)
            }
        }
    }

    override fun get(key: String): T? = delegate[key]?.get()

    private fun removeLeastRecentlyUsed() {
        delegate.entries.fold("", { currentKey, entry ->
            val currentLRUValueWrapper = delegate[currentKey]
            if (currentLRUValueWrapper?.usage ?: Long.MAX_VALUE >= entry.value?.usage ?: Long.MAX_VALUE) {
                currentKey
            } else {
                entry.key
            }
        }).let { delegate = delegate.minus(it) }
    }

    private class ValueWrapper<out T>(
            var usage: Long = System.currentTimeMillis(),
            private val value: T?) {
        fun get(): T? {
            usage = System.currentTimeMillis()
            return value
        }
    }
}