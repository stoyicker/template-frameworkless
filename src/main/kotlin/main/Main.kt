package main

import java.lang.IllegalStateException
import java.util.Arrays

fun main(args: Array<String>) {
	val recursiveTree =
			Node(10,
					Node(5,
							Node(3,
									null,
									null),
							Node(7,
									null,
									null)),
					Node(15,
							null,
							Node(18,
									null,
									null)))
	System.out.println("RECURSIVE")
	System.out.println("Pre-order: 	${recursiveTree.preOrder()}")
	System.out.println("In-order: 	${recursiveTree.inOrder()}")
	System.out.println("Post-order: ${recursiveTree.postOrder()}")
	System.out.println("BFS: 		${recursiveTree.bfs()}")
	System.out.println("DFS: 		${recursiveTree.dfs()}")
	System.out.println("")
	val arrayTree = arrayOf(10, 5, 15, 3, 7, null, 18)
	System.out.println("ARRAY")
	System.out.println("Pre-order: 	${TreeTraversals.preOrder(arrayTree)}")
	System.out.println("In-order: 	${TreeTraversals.inOrder(arrayTree)}")
	System.out.println("Post-order: ${TreeTraversals.postOrder(arrayTree)}")
	System.out.println("BFS: 		${TreeTraversals.bfs(arrayTree)}")
	System.out.println("DFS: 		${TreeTraversals.dfs(arrayTree)}")
	throwAssert(Arrays.deepEquals(
			recursiveTree.preOrder().toTypedArray(),
			TreeTraversals.preOrder(arrayTree).toTypedArray()))
	throwAssert(Arrays.deepEquals(
			recursiveTree.inOrder().toTypedArray(),
			TreeTraversals.inOrder(arrayTree).toTypedArray()))
	throwAssert(Arrays.deepEquals(
			recursiveTree.postOrder().toTypedArray(),
			TreeTraversals.postOrder(arrayTree).toTypedArray()))
	throwAssert(Arrays.deepEquals(
			recursiveTree.bfs().toTypedArray(),
			TreeTraversals.bfs(arrayTree).toTypedArray()))
	throwAssert(Arrays.deepEquals(
			recursiveTree.dfs().toTypedArray(),
			TreeTraversals.dfs(arrayTree).toTypedArray()))
}

fun throwAssert(value: Boolean) {
	if (!value) {
		throw IllegalStateException()
	}
}
