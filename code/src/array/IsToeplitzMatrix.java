package array;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,2,1,3}};
        System.out.println(isToeplitzMatrix(m));;
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length -1 ; i++ ){
            for (int j = 0; j < matrix[i].length -1 ;j++ ){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return true;
                }
            }
        }
        return false;
    }

}
