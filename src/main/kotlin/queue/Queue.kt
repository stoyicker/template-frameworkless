package queue

import stack.Stack

internal class Queue<T> {
    private val incoming = Stack<T>()
    private val removal = Stack<T>()

    fun enqueue(value: T) {
        incoming.push(value)
    }

    fun dequeue(): T {
        return if (!removal.isEmpty()) {
            removal.pop()
        } else if (!incoming.isEmpty()) {
            do {
                removal.push(incoming.pop())
            } while (incoming.isEmpty())
            removal.pop()
        } else {
            throw IllegalStateException("Cannot dequeue from an empty queue")
        }
    }
}
