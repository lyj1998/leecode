package array;

import java.util.*;

public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            Set s = new HashSet();
            for(int i = 0;i<nums.length; i++){
                for(int j = i+1; j<nums.length; j++){
                    for(int k = i+2; k<nums.length; k++){
                        if(nums[i]+nums[j]+nums[k]==0){
                            ArrayList<Integer> list = new ArrayList();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            Collections.sort(list);
                            s.add(list);
                        }
                    }
                }
            }
            return new ArrayList<>(s);
        }
    }
class Test2{
    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        int[] nums = {1,2,-2,-1};
        s.threeSum(nums);
    }
}
