package algorithm.test;

import algorithm.sort.Selection;

import java.util.Arrays;

public class TestSelection {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,7,9,2,10,1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
