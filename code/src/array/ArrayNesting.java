package array;

public class ArrayNesting {
    public static void main(String[] args) {
        int[] m = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(m));
    }
    public static int arrayNesting(int[] nums) {
        int size = 1;
        for(int i = 0; i< nums.length ; i++){
            int count = 0;
            int next = i;
            while(nums[next]>0){
                int newIndex = nums[next];
                nums[next] = -1;
                count ++;
                next = newIndex;
            }
            size = count>size?count:size;
        }
        return size;
    }
}
