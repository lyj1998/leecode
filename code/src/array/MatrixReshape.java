package array;

public class MatrixReshape {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            //1.非法情况，返回原数组
            int m = nums.length;
            int n = nums[0].length;
            if(m*n != r * c){
                return nums;
            }
            int[] temp = new int[m*n];
            int count = 0;
            //2.把原来数组打平，再放到新的二维数组里
            for(int i =0; i<m; i++){
                for(int j = 0; j<n; j++){
                    temp[count++] = nums[i][j];
                }
            }
            int[][] newNums = new int[r][c];
            int newcount = 0;
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    newNums[i][j] = temp[newcount++];
                }
            }
            return newNums;
        }
}
