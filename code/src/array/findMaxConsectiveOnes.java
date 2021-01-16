package array;

import java.util.ArrayList;

public class findMaxConsectiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }
        public static int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int j = 0;
            ArrayList<Integer> list = new ArrayList();
            while(j<nums.length){
                for(int i =j; i< nums.length; i++){
                    j++;
                    if(nums[i]!=0){
                        list.add(nums[i]);
                    }else{
                        break;
                    }
                }
                if(list.size()>max){
                    max = list.size();
                }
                list.clear();
            }
            return max;

        }
}
