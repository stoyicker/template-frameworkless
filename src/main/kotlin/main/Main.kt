package main

import permutations.Permutations

fun main(args: Array<String>) {
    System.out.println("Hello project")
    Permutations.of("abc").forEach {
        System.out.println(it)
    }
}
