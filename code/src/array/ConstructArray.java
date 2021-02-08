package array;

import java.util.Arrays;

public class ConstructArray {
    public int[] constructArray(int n, int k) {
// 1  1+k 2 k 3 k-1... k/2   k+2
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<=k; i++){
            if(i%2 ==1){
                res[i] = 1+k-i/2;
            }else{
                res[i] = 2+(i-1)/2;
            }
        }
        for(int i = k+1; i<n; i++){
            res[i] = i+1;
        }
        return res;
    }
}

class Demo4{
    public static void main(String[] args) {
        ConstructArray arr = new ConstructArray();
        int[] res = arr.constructArray(5, 3);
        //1 4 2 5 3
        System.out.println(Arrays.toString(res));
    }
}
