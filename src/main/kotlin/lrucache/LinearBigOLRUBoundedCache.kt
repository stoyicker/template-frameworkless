package lrucache

internal class LinearBigOLRUBoundedCache<T>(maxCapacity: Int) : BoundedCache<T>(maxCapacity) {
    private var delegate = mutableMapOf<String, ValueWrapper<T>>()

    override fun put(key: String, value: T) {
        synchronized(delegate) {
            if (!delegate.containsKey(key) && delegate.size >= maxCapacity) {
                removeLeastRecentlyUsed()
                put(key, value)
            } else {
                delegate[key] = ValueWrapper(value = value)
            }
        }
    }

    override fun get(key: String) = delegate[key]?.get()

    private fun removeLeastRecentlyUsed() {
        delegate.entries.fold("") { currentKey, newEntry ->
            val currentLRUValueWrapper = delegate[currentKey]!!
            if (currentLRUValueWrapper.usage >= newEntry.value.usage) {
                currentKey
            } else {
                newEntry.key
            }
        }.let { delegate.remove(it) }
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
