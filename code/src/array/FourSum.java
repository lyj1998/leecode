package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
//与LeetCode三数之和类似，指定两个base
//后两个数就是left right
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int i=0; i<nums.length-3; i++){
                if(nums[i]>target){
                    return res;
                }
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                for(int j = i+1; j<nums.length - 2; j++){
                    if(j>i+1&&nums[j]==nums[j-1]){
                        continue;
                    }
                    int left = j+1;
                    int right = nums.length - 1;
                    while(left<right){
                        if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            res.add(list);
                            while(left<right&&nums[left]==nums[left+1]){
                                left++;
                            }
                            while(left<right&&nums[right]==nums[right-1]){
                                right--;
                            }
                            left++;
                            right--;
                        }else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                            right--;
                        }else{
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
    class Test5{
        public static void main(String[] args) {
            FourSum f = new FourSum();
            int[] nums = {1,-2,-5,-4,-3,3,3,5};
            f.fourSum(nums, -11);
        }
    }
