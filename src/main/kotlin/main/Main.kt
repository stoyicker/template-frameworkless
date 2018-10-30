package main

fun main(args: Array<String>) {
    val map = mutableMapOf<Item, String>()
    while (true) {
        map[Item("id")] = "value"
    }
}

// If you remove "data" from here, you're also removing the hashCode implementation, so Object#hashCode
// will be called, effectively giving you an ever-growing map above until the heap limit is reached
// To observe, run with vm arg -Xmx1M (sets heap limit to 1MB)
data class Item(private val field: String)
