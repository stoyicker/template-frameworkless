package main

import mergesort.Mergesort

fun main(args: Array<String>) {
    System.out.println("Hello project")
    val a = intArrayOf(3, 2, 1, 4, -89, 7)
    a[0] = 9
    a.forEach { System.out.print("$it ") }
    Mergesort.intArray(a)
    System.out.println("\n--------\n")
    a.forEach { System.out.print("$it ") }
}
