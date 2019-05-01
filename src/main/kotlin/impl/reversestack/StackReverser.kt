package impl.reversestack

internal object StackReverser {
    fun <T> reverse(stack: Stack<T>) {
        if (!stack.isEmpty()) {
            val value = stack.pop()
            reverse(stack)
            pushToBottom(stack, value)
        }
    }

    private fun <T> pushToBottom(stack: Stack<T>, value: T) {
        if (stack.isEmpty()) {
            stack.push(value)
        } else {
            val innerValue = stack.pop()
            pushToBottom(stack, value)
            stack.push(innerValue)
        }
    }
}
