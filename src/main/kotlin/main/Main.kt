package main

fun main(args: Array<String>) {
    val tree = Node(1, Node(2, Node(4, null, null), Node(5, null, null)), Node(3, null, null))
    System.out.println(tree.preOrder())
    System.out.println(tree.inOrder())
    System.out.println(tree.postOrder())
}
