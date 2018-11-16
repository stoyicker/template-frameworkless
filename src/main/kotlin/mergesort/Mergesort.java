package mergesort;

public final class Mergesort {
    public static void intArray(int[] array) {
        mergesort(array, 0, array.length - 1);
    }

    private static void mergesort(int[] array, int start, int end) {
        if (start < end) {
            int divisionIndex = (start + end) / 2;
            mergesort(array, start, divisionIndex);
            mergesort(array, divisionIndex + 1, end);
            merge(array, start, divisionIndex, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int leftArrayLength = middle - start + 1;
        int rightArrayLength = end - middle;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];
        System.arraycopy(array, start, leftArray, 0, leftArrayLength);
        System.arraycopy(array, middle + 1, rightArray, 0, rightArrayLength);
        int arrayIndex = start;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArray.length || rightIndex < rightArray.length) {
            if (leftIndex >= leftArray.length) {
                array[arrayIndex++] = rightArray[rightIndex++];
            } else if (rightIndex >= rightArray.length) {
                array[arrayIndex++] = leftArray[leftIndex++];
            } else {
                if (rightArray[rightIndex] < leftArray[leftIndex]) {
                    array[arrayIndex++] = rightArray[rightIndex++];
                } else {
                    array[arrayIndex++] = leftArray[leftIndex++];
                }
            }
        }
    }
}
