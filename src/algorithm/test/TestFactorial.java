package algorithm.test;
public class TestFactorial {
    public static void main(String[] args){
        long result = factorial(5);
        System.out.println(result);
    }
    public static long factorial(int n){
//        n! = n * (n - 1)!
        if(n ==1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
