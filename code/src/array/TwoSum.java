package array;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for(int i =0;i<nums.length;i++){
                for(int j=i+1; j<nums.length; j++){
                    res[0] = i;
                    if(nums[j]==target - nums[i]){
                        res[1] = j;
                        return res;
                    }
                }
            }
        return res;
        }
    }
class Demo5{
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        t.twoSum(nums,target);


    }
}