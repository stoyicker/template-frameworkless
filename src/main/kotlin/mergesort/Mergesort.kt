package mergesort

internal object Mergesort {
    fun intArray(array: IntArray) {
        if (array.size >= 2)
            mergesort(array, 0, array.size - 1)
    }

    private fun mergesort(array: IntArray, start: Int, end: Int) {
        if (start < end) {
            val divisionIndex: Int = start + (end - start) / 2
            mergesort(array, start, divisionIndex)
            mergesort(array, divisionIndex + 1, end)
            merge(array, start, divisionIndex, end)
        }
    }

    private fun merge(array: IntArray, firstIndex: Int, middleIndex: Int, lastIndex: Int) {
        val arrayOne = array.slice(firstIndex..middleIndex)
        val arrayTwo = array.slice(middleIndex + 1..lastIndex)
        val ret = IntArray(lastIndex - firstIndex + 1)
        var i = 0
        var indexOne = 0
        var indexTwo = 0
        while (indexOne < arrayOne.size || indexTwo < arrayTwo.size) {
            if (indexOne >= arrayOne.size) {
                ret[i] = arrayTwo[indexTwo++]
            } else if (indexTwo >= arrayTwo.size) {
                ret[i] = arrayOne[indexOne++]
            } else {
                if (arrayOne[indexOne] <= arrayTwo[indexTwo]) {
                    ret[i] = arrayOne[indexOne++]
                } else {
                    ret[i] = arrayTwo[indexTwo++]
                }
            }
            i++
        }
        ret.forEachIndexed { index, element ->
            array[index + firstIndex] = element
        }
    }
}
