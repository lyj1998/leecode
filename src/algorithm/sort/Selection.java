package algorithm.sort;

public class Selection {
//    1.比较大小
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }
//    2.交换两个元素的位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//   3.排序
    public static void sort(Comparable[] a){
        for(int i=0; i<a.length - 1; i++){
            int min_index = i;
            for (int j =i+1; j<a.length; j++){
//                if (greater(a[i], a[j])){
//                    exch(a, i, j);
//                }
                if(greater(a[min_index], a[j])){
                    min_index = j;
                }
            }
//            交换最小元素所在索引
            exch(a, i, min_index);
        }
    }
}
