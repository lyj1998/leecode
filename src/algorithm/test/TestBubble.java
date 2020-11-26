package algorithm.test;

import algorithm.sort.Bubble;

import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args) {
        Integer[] arr = {4,3,7,9,1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
