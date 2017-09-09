package reversestack

internal class Stack<T> {
    private var last: Node<T>? = null

    fun isEmpty() = last == null

    fun push(value: T) {
        last = Node(value, last)
    }

    fun pop(): T {
        if (isEmpty()) {
            throw IllegalStateException("Cannot remove from an empty stack")
        } else {
            return last!!.also {
                last = it.next
            }.value
        }
    }

    override fun toString(): String {
        return last.toString()
    }
}