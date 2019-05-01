package impl.queue

import java.util.Stack

internal class FifoQueue<T> {
    private val incoming = Stack<T>()
    private val removal = Stack<T>()

    fun enqueue(value: T) {
        incoming.push(value)
    }

    fun dequeue(): T {
        if (removal.isEmpty() && !incoming.isEmpty()) {
            do {
                removal.push(incoming.pop())
            } while (incoming.isEmpty())
        }
        return removal.pop()
    }
}
