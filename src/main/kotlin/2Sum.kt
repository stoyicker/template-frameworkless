import java.util.Hashtable

val table = Hashtable<Int, Boolean>()

fun twoSum(array: IntArray, sum: Int): List<Pair<Int, Int>> {
	val ret = mutableListOf<Pair<Int, Int>>()
	array.forEach { it ->
		val index = sum - it
		if (table[index] == true) {
			ret.add(it to index)
		} else {
			table[it] = true
		}
	}
	return ret
}
