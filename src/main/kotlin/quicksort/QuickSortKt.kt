package quicksort

internal object QuickSortKt {
    fun on(array: Array<Int>) {
        quickSort(0, array.size - 1, array)
    }

    /**
     * startIndex and endIndex are inclusive
     */
    private fun quickSort(startIndex: Int, endIndex: Int, array: Array<Int>) {
        val pivot = array[startIndex + (endIndex - startIndex) / 2]
        var i = startIndex
        var j = endIndex
        while (i <= j) {
            while (array[i] < pivot) {
                i++
            }
            while (array[j] > pivot) {
                j--
            }
            if (i <= j) {
                swap(i, j, array)
                i++
                j--
            }
        }
        if (startIndex < j) {
            quickSort(startIndex, j, array)
        }
        if (endIndex > i) {
            quickSort(i, endIndex, array)
        }
    }

    private fun swap(indexOne: Int, indexTwo: Int, array: Array<Int>) {
        val firstValue = array[indexOne]
        array[indexOne] = array[indexTwo]
        array[indexTwo] = firstValue
    }
}
