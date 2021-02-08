package algorithm.test;
import algorithm.sort.Insertion;

import java.io.PrintWriter;
import java.util.Arrays;

public class TestShell {
    public static void main(String[] args) {
        Integer[] a = {9,1,2,5,7,4,8,6,3,5};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
//        System.out.println(maxRepeating("ababc", "ba"));
    }

//        public static int maxRepeating(String sequence, String word) {
//            int count = 0;
//            for(int i=0; i < sequence.length() - word.length(); i++){
//                String str = sequence.substring(i, i+word.length());
//                if (str.equals(word)){
//                    count ++;
//                }
//            }
//            return count;
//        }
}

