package array;

import java.util.Arrays;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
}

class Demo1 {
    public static void main(String[] args) {
        FindErrorNums f = new FindErrorNums();
        int[] test = {2, 3, 4, 3};
        int[] res = f.findErrorNums(test);
        System.out.println("结果"+Arrays.toString(res));
    }
}
