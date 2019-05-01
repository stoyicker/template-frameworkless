package impl.lrucache

internal class ValueWrapper<out T>(
		var usage: Long = System.currentTimeMillis(),
		private val value: T?) {
	fun get(): T? {
		usage = System.currentTimeMillis()
		return value
	}
}
