package trees

import java.util.LinkedList
import java.util.Stack

internal object TreeTraversals {
	fun <T> preOrder(array: Array<T>): List<T> {
		val ret = LinkedList<T>()
		val indexes = Stack<Int>()
		indexes.push(0)
		var thisIndex: Int
		var leftIndex: Int
		var rightIndex: Int
		while (!indexes.isEmpty()) {
			thisIndex = indexes.pop()
			rightIndex = rightIndex(array, thisIndex)
			leftIndex = leftIndex(array, thisIndex)
			if (array[thisIndex] != null) {
				ret.add(array[thisIndex])
			}
			if (rightIndex < array.size) {
				indexes.push(rightIndex)
			}
			if (leftIndex < array.size) {
				indexes.push(leftIndex)
			}
		}
		return ret
	}

	fun <T> inOrder(array: Array<T>): List<T> {
		val ret = LinkedList<T>()
		val indexes = Stack<Int>()
		val visited = BooleanArray(array.size)
		indexes.push(0)
		var thisIndex: Int
		var leftIndex: Int
		var rightIndex: Int
		while (indexes.peek() != array.size - 1) {
			thisIndex = indexes.pop()
			if (visited[thisIndex]) {
				continue
			}
			rightIndex = rightIndex(array, thisIndex)
			leftIndex = leftIndex(array, thisIndex)
			if (rightIndex < array.size && !visited[rightIndex]) {
				indexes.push(rightIndex)
			}
			if (leftIndex < array.size || rightIndex < array.size) {
				indexes.push(thisIndex)
			} else {
				ret.add(array[thisIndex])
				visited[thisIndex] = true
			}
			if (leftIndex < array.size && !visited[leftIndex]) {
				indexes.push(leftIndex)
			}
		}
		return ret
	}

	fun <T> postOrder(array: Array<T>): List<T> {
		val ret = LinkedList<T>()
		val indexes = Stack<Int>()
		val visited = BooleanArray(array.size)
		indexes.push(0)
		var thisIndex: Int
		var leftIndex: Int
		var rightIndex: Int
		var parentIndex: Int
		do {
			thisIndex = indexes.pop()
			rightIndex = rightIndex(array, thisIndex)
			leftIndex = leftIndex(array, thisIndex)
			if (visited[thisIndex]) {
				continue
			}
			if (rightIndex < array.size && !visited[rightIndex]) {
				indexes.push(rightIndex)
			}
			if (leftIndex < array.size && !visited[leftIndex]) {
				indexes.push(leftIndex)
			}
			if ((rightIndex >= array.size || visited[rightIndex]) && (leftIndex >= array.size || visited[leftIndex])) {
				ret.add(array[thisIndex])
				parentIndex = parentIndex(array, thisIndex)
				if (parentIndex != -1) {
					indexes.push(parentIndex)
					visited[thisIndex] = true
				}
			}
		} while (!indexes.isEmpty())
		return ret
	}

	private fun <T> parentIndex(array: Array<T>, i: Int): Int {
		return if (i == 0) {
			-1
		} else (i - 1) / 2
	}

	private fun <T> leftIndex(array: Array<T>, i: Int): Int {
		return 2 * i + 1
	}

	private fun <T> rightIndex(array: Array<T>, i: Int): Int {
		return 2 * i + 2
	}
}
