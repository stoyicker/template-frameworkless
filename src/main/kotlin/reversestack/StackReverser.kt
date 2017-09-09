package reversestack

internal object StackReverser {
    fun <T> reverse(stack: Stack<T>) {
        if (!stack.isEmpty()) {
            val value = stack.pop()
            reverse(stack)
            pushWrapper(stack, value)
        }
    }

    private fun <T> pushWrapper(stack: Stack<T>, value: T) {
        if (stack.isEmpty()) {
            stack.push(value)
        } else {
            val innerValue = stack.pop()
            pushWrapper(stack, value)
            stack.push(innerValue)
        }
    }
}
