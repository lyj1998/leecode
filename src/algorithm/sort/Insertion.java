package algorithm.sort;

public class Insertion {
//    1.判断大小
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }
//    2.交换位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//    3.插入排序
    public static void sort(Comparable[] a){
//        1.会分成两组，一组已排序的，一组未排序的
//        2.找到未排序的组中的第一个元素，向已排序中的进行插入
//        3.倒序遍历已经排序的元素，依次和待插入的元素进行比较，比待插入元素大就进行交换,比待插入元素小则结束跳出循环即可
        for(int i=1; i<a.length; i++){
            for (int j=i; j>0; j--){
                if(greater(a[j-1], a[j])){
                    exch(a, j-1, j);
                }else {
                    break;
                }
            }
        }

    }
}
