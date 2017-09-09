package main

import reversestack.Stack
import reversestack.StackReverser

fun main(args: Array<String>) {
    System.out.println("Hello project")
    testStackReversal()
}

private fun testStackReversal() {
    System.out.println("STACK REVERSAL")
    val stack = Stack<Int>()
    (0 until 10).forEach {
        stack.push(it)
    }
    System.out.println("Before reversal: $stack")
    StackReverser.reverse(stack)
    System.out.println("After reversal: $stack")
}
