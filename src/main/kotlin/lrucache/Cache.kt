package lrucache

internal abstract class Cache<T : Any>(protected val maxCapacity: Int) {
    abstract fun put(key: String, value: T?)

    abstract fun get(key: String): T?
}