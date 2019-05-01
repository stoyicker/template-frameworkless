package trees

import java.util.LinkedList

internal class Node<T>(val value: T?, val left: Node<T>?, val right: Node<T>?) {

	fun preOrder(): List<T> {
		val list = LinkedList<T>()
		if (value != null) {
			list.add(value)
		}
		if (left != null) {
			list.addAll(left.preOrder())
		}
		if (right != null) {
			list.addAll(right.preOrder())
		}
		return list
	}

	fun inOrder(): List<T> {
		val list = LinkedList<T>()
		if (left != null) {
			list.addAll(left.inOrder())
		}
		if (value != null) {
			list.add(value)
		}
		if (right != null) {
			list.addAll(right.inOrder())
		}
		return list
	}

	fun postOrder(): List<T> {
		val list = LinkedList<T>()
		if (left != null) {
			list.addAll(left.postOrder())
		}
		if (right != null) {
			list.addAll(right.postOrder())
		}
		if (value != null) {
			list.add(value)
		}
		return list
	}
}
