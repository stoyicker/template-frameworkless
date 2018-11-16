package main

import mergesort.Mergesort

fun main(args: Array<String>) {
	val array = intArrayOf(9, 2, 1, 4, -89, 7)
	val shortArray = intArrayOf(2, 1)
	forArray(array)
	System.out.println("\n--------\n")
	System.out.println("\n--------\n")
  forArray(shortArray)
}

private fun forArray(array: IntArray) {
	System.out.println("UNSORTED")
	array.forEach { System.out.print("$it ") }
	Mergesort.intArray(array)
	System.out.println("\n--------\n")
	System.out.println("SORTED")
	array.forEach { System.out.print("$it ") }
}
