package impl.mergesort

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
        var i = firstIndex
        var indexOne = 0
        var indexTwo = 0
        while (indexOne < arrayOne.size || indexTwo < arrayTwo.size) {
            if (indexOne >= arrayOne.size) {
                array[i] = arrayTwo[indexTwo++]
            } else if (indexTwo >= arrayTwo.size) {
                array[i] = arrayOne[indexOne++]
            } else {
                if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
                    array[i] = arrayOne[indexOne++]
                } else {
                    array[i] = arrayTwo[indexTwo++]
                }
            }
            i++
        }
    }
}
