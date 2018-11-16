package main;

import java.util.LinkedList;
import java.util.List;

final class Node<T> {
    final T value;
    final Node<T> left;
    final Node<T> right;

    Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    List<T> preOrder() {
        List<T> list = new LinkedList<>();
        if (value != null) {
            list.add(value);
        }
        if (left != null) {
            list.addAll(left.preOrder());
        }
        if (right != null) {
            list.addAll(right.preOrder());
        }
        return list;
    }

    List<T> inOrder() {
        List<T> list = new LinkedList<>();
        if (left != null) {
            list.addAll(left.inOrder());
        }
        if (value != null) {
            list.add(value);
        }
        if (right != null) {
            list.addAll(right.inOrder());
        }
        return list;
    }

    List<T> postOrder() {
        List<T> list = new LinkedList<>();
        if (left != null) {
            list.addAll(left.postOrder());
        }
        if (right != null) {
            list.addAll(right.postOrder());
        }
        if (value != null) {
            list.add(value);
        }
        return list;
    }

    List<T> bfs() {
        return preOrder();
    }

    List<T> dfs() {
        return postOrder();
    }
}
