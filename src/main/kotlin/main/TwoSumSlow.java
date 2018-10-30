package main;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;

public final class TwoSumSlow {
    static List<Pair<Integer, Integer>> twoSumSlow(int[] array, int sum) {
        List<Pair<Integer, Integer>> ret = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    ret.add(new Pair<>(array[i], array[j]));
                }
            }
        }
        return ret;
    }
}
