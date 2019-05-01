import impl.bits.Bits
import impl.hashcode.Item

fun main(args: Array<String>) {
    bit()
    hashcode()
}

private fun bit() {
    System.out.println(Bits.getBit(25, -1)) //false: 25 is 1101, negative shifting becomes positive so you getBit index 1 which is 0
    System.out.println(Bits.setBit(8, 4)) // 24: 8 is 100, 1100 is 24
    System.out.println(Bits.clearBit(0, 0)) // 0: 0 is 0, becomes 0
    System.out.println(Bits.clearBit(9, 0)) // 8: 9 is 101, becomes 100, which is 8
}

private fun hashcode() {
    /**
     * Right now, this will never surpass size 1. However, if we remove "data" from here, we're also removing the
     * hashCode implementation, so Object#hashCode will be called, effectively giving you an ever-growing map every
     * iteration.
     */
    val map = mutableMapOf<Item, String>()
    repeat (1000000) {
        map[Item("id")] = "value"
        System.out.println("Size is ${map.size}")
    }
}
