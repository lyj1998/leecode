package algorithm.sort;

public class Bubble {
//    1.判断大小
    private static boolean greater(Comparable v, Comparable w){
//        result>0 则v>w
        return v.compareTo(w) > 0;
    }
//    2.交换位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//    3.对数组内的元素排序
//  双重for循环 1.外层循环控制数据对比轮数  2.内层循环控制每轮对比次数
    public static void sort(Comparable[] a){
        for(int i = a.length - 1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if (greater(a[j], a[j+1])){
                    exch(a, j, j+1);
                }
            }
        }
    }
}
