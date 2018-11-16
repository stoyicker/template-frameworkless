package main;

import java.util.*;

final class TreeTraversals {
    static <T> List<T> preOrder(T[] array) {
        final LinkedList<T> ret = new LinkedList<>();
        Stack<Integer> indexes = new Stack<>();
        indexes.push(0);
        int thisIndex;
        int leftIndex;
        int rightIndex;
        while (!indexes.isEmpty()) {
            thisIndex = indexes.pop();
            rightIndex = rightIndex(array, thisIndex);
            leftIndex = leftIndex(array, thisIndex);
            if (array[thisIndex] != null) {
                ret.add(array[thisIndex]);
            }
            if (rightIndex < array.length) {
                indexes.push(rightIndex);
            }
            if (leftIndex < array.length) {
                indexes.push(leftIndex);
            }
        }
        return ret;
    }

    static <T> List<T> inOrder(T[] array) {
        final LinkedList<T> ret = new LinkedList<>();
        Stack<Integer> indexes = new Stack<>();
        boolean[] visited = new boolean[array.length];
        indexes.push(0);
        int thisIndex;
        int leftIndex;
        int rightIndex;
        while (indexes.peek() != array.length - 1) {
            thisIndex = indexes.pop();
            if (visited[thisIndex]) {
                continue;
            }
            rightIndex = rightIndex(array, thisIndex);
            leftIndex = leftIndex(array, thisIndex);
            if (rightIndex < array.length && !visited[rightIndex]) {
                indexes.push(rightIndex);
            }
            if (leftIndex < array.length || rightIndex < array.length) {
                indexes.push(thisIndex);
            } else {
                ret.add(array[thisIndex]);
                visited[thisIndex] = true;
            }
            if (leftIndex < array.length && !visited[leftIndex]) {
                indexes.push(leftIndex);
            }
        }
        return ret;
    }

    static <T> List<T> postOrder(T[] array) {
        final LinkedList<T> ret = new LinkedList<>();
        Stack<Integer> indexes = new Stack<>();
        boolean[] visited = new boolean[array.length];
        indexes.push(0);
        int thisIndex;
        int leftIndex;
        int rightIndex;
        int parentIndex;
        do {
            thisIndex = indexes.pop();
            rightIndex = rightIndex(array, thisIndex);
            leftIndex = leftIndex(array, thisIndex);
            if (visited[thisIndex]) {
                continue;
            }
            if (rightIndex < array.length && !visited[rightIndex]) {
                indexes.push(rightIndex);
            }
            if (leftIndex < array.length && !visited[leftIndex] ) {
                indexes.push(leftIndex);
            }
            if ((rightIndex >= array.length || visited[rightIndex])
                    && (leftIndex >= array.length || visited[leftIndex])) {
                ret.add(array[thisIndex]);
                parentIndex = parentIndex(array, thisIndex);
                if (parentIndex != -1) {
                    indexes.push(parentIndex);
                    visited[thisIndex] = true;
                }
            }
        } while (!indexes.isEmpty());
        return ret;
    }

    static <T> List<T> bfs(T[] array) {
        final LinkedList<T> ret = new LinkedList<>();
        Stack<Integer> indexes = new Stack<>();
        indexes.push(0);
        int thisIndex;
        int leftIndex;
        int rightIndex;
        while(!indexes.isEmpty()) {
            thisIndex = indexes.pop();
            if (array[thisIndex] != null) {
                ret.add(array[thisIndex]);
            }
            rightIndex = rightIndex(array, thisIndex);
            if (rightIndex < array.length) {
                indexes.push(rightIndex);
            }
            leftIndex = leftIndex(array, thisIndex);
            if (leftIndex < array.length) {
                indexes.push(leftIndex);
            }
        }
        return ret;
    }

    static <T> List<T> dfs(T[] array) {
        final LinkedList<T> ret = new LinkedList<>();
        Stack<Integer> indexes = new Stack<>();
        indexes.push(0);
        boolean[] visited = new boolean[array.length];
        int thisIndex;
        int leftIndex;
        int rightIndex;
        int parentIndex;
        do {
            thisIndex = indexes.pop();
            rightIndex = rightIndex(array, thisIndex);
            leftIndex = leftIndex(array, thisIndex);
            if (visited[thisIndex]) {
                continue;
            }
            if (rightIndex < array.length && !visited[rightIndex]) {
                indexes.push(rightIndex);
            }
            if (leftIndex < array.length && !visited[leftIndex] ) {
                indexes.push(leftIndex);
            }
            if ((rightIndex >= array.length || visited[rightIndex])
                    && (leftIndex >= array.length || visited[leftIndex])) {
                ret.add(array[thisIndex]);
                parentIndex = parentIndex(array, thisIndex);
                if (parentIndex != -1) {
                    indexes.push(parentIndex);
                    visited[thisIndex] = true;
                }
            }
        } while (!indexes.isEmpty());
        return ret;
    }

    private static int parentIndex(Object[] array, int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    private static int leftIndex(Object[] array, int i) {
        return 2 * i + 1;
    }

    private static int rightIndex(Object[] array, int i) {
        return 2 * i + 2;
    }
}
