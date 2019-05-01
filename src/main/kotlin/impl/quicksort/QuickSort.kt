package impl.quicksort

internal object QuickSort {
	fun intArray(array: IntArray) {
		quicksort(array, 0, array.size - 1)
	}

	private fun quicksort(array: IntArray, left: Int, right: Int) {
		val pivot = array[left + (right - left) / 2]
		var leftInternal = left
		var rightInternal = right
		while (leftInternal <= rightInternal) {
			while (leftInternal < array.size && pivot > array[leftInternal]) {
				leftInternal++
			}
			while (rightInternal >= 0 && pivot < array[rightInternal]) {
				rightInternal--
			}
			if (leftInternal <= rightInternal) {
				// If they're the same index, no need to swap, but still gotta update the indexes
				swap(array, leftInternal, rightInternal)
				leftInternal++
				rightInternal--
			}
		}
		if (leftInternal < right) {
			quicksort(array, leftInternal, right)
		}
		if (rightInternal > left) {
			quicksort(array, left, rightInternal)
		}
	}

	private fun swap(array: IntArray, i: Int, j: Int) {
		val t = array[i]
		array[i] = array[j]
		array[j] = t
	}
}
