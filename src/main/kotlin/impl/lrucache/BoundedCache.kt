package impl.lrucache

import kotlin.properties.Delegates

internal abstract class BoundedCache<T>(maxCapacityProvided: Int) {
    protected var maxCapacity by Delegates.vetoable(DEFAULT_CAPACITY) { _, _, new -> new >= 1}
        private set

    init {
        maxCapacity = maxCapacityProvided
    }

    abstract fun put(key: String, value: T)

    abstract operator fun get(key: String): T?

    private companion object {
        const val DEFAULT_CAPACITY = 1
    }
}
