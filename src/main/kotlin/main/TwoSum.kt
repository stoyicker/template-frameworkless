package twosum

internal object TwoSum {
	fun twoSum(array: IntArray, sum: Int): List<Pair<Int, Int>> {
		val table = mutableSetOf<Int>()
		array.forEach { table.add(it) }
		return array.filter { table.contains(sum - it) }.map { Pair(it, sum - it) }
	}
}
