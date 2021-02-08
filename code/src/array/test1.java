package array;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {
        public int countGoodRectangles(int[][] rectangles) {
            ArrayList<Integer> list = new ArrayList();
            for(int i = 0; i< rectangles.length; i++){
                for(int j = 0; j< rectangles[0].length- 1; j++){
                    int temp = rectangles[i][j]<rectangles[i][j+1]?rectangles[i][j]:rectangles[i][j+1];
                    list.add(temp);
                }
            }
            int[] nums = new int[list.size()];
            for(int i=0;i<list.size();i++){
                nums[i]=list.get(i);
            }
            Arrays.sort(nums);
            int count = 0;
            for(int j=nums.length - 1; j>=0; j--){
                if(nums[j]==nums[nums.length - 1]){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }

    }
    class Demo3{
        public static void main(String[] args) {
            test1 t = new test1();
            int[][] r = {{5,8},{3,9},{5,12},{16,5}};
            t.countGoodRectangles(r);
        }
    }
