package algorithm.test;
import algorithm.sort.Bubble;
import algorithm.sort.Merge;

import java.util.Arrays;

public class TestMerge {
    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
