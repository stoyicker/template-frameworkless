package main

import quicksort.QuickSortKt

fun main(args: Array<String>) {
    System.out.println("Hello project")
    testQuickSort()
}

private fun testQuickSort() {
    System.out.println("TEST QUICKSORT")
    val array = arrayOf(3,9,6,-21,8,0,8912312,5)
    System.out.println("Before sorting: ${arrayToString(array)}")
    QuickSortKt.on(array)
    System.out.println("After sorting: ${arrayToString(array)}")
}

private fun arrayToString(array: Array<Int>) = StringBuilder().apply { array.forEach { append("$it, ")} }
