package algorithm.test;

import algorithm.sort.Qucik;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args){
        Comparable[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Qucik.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
