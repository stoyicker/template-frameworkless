package lrucache

import kotlin.properties.Delegates

internal abstract class Cache<T : Any>(maxCapacityProvided: Int) {
    protected var maxCapacity by Delegates.vetoable(DEFAULT_CAPACITY, { _, _, new -> new >= 1})
        private set

    init {
        maxCapacity = maxCapacityProvided
    }

    abstract fun put(key: String, value: T?)

    abstract fun get(key: String): T?
}

private const val DEFAULT_CAPACITY = 1