package main;

import java.util.ArrayList;
import java.util.List;

final class Node<T> {
    // TODO BFS and DFS too
    final T value;
    final Node<T> left;
    final Node<T> right;

    Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    List<T> preOrder() {
        List<T> list = new ArrayList<>();
        list.add(value);
        if (left != null) {
            list.addAll(left.preOrder());
        }
        if (right != null) {
            list.addAll(right.preOrder());
        }
        return list;
    }

    List<T> inOrder() {
        List<T> list = new ArrayList<>();
        if (left != null) {
            list.addAll(left.inOrder());
        }
        list.add(value);
        if (right != null) {
            list.addAll(right.inOrder());
        }
        return list;
    }

    List<T> postOrder() {
        List<T> list = new ArrayList<>();
        if (left != null) {
            list.addAll(left.postOrder());
        }
        if (right != null) {
            list.addAll(right.postOrder());
        }
        list.add(value);
        return list;
    }
}
