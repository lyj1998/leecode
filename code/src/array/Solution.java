package array;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] temp = new int[nums.length+1];
        for(int num:nums){
            temp[num]++;
        }

        for(int i=1; i<temp.length;i++){
            if(temp[i]==1){
                continue;
            }else if(temp[i]==2){
                res[0] = i;
            }else if(temp[i]==0){
                res[1] = i;
            }
        }
        return res;
    }
}
class Demo{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums= {2,3,4,3};
        s.findErrorNums(nums);
    }
}