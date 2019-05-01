package main

import bit.Bit

fun main(args: Array<String>) {
    System.out.println(Bit.get(9, -1)) //false
    System.out.println(Bit.set(8, 4)) // 24
    System.out.println(Bit.clear(0, 0)) // 0
    System.out.println(Bit.clear(9, 0)) // 8
}
