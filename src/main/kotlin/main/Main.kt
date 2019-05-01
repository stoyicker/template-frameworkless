package main

import bit.Bit

fun main(args: Array<String>) {
    bit()
}

private fun bit() {
    System.out.println(Bit.get(25, -1)) //false: 25 is 1101, negative shifting becomes positive so you get index 1 which is 0
    System.out.println(Bit.set(8, 4)) // 24: 8 is 100, 1100 is 24
    System.out.println(Bit.clear(0, 0)) // 0: 0 is 0, becomes 0
    System.out.println(Bit.clear(9, 0)) // 8: 9 is 101, becomes 100, which is 8
}
