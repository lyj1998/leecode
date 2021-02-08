package algorithm.sort;

public class Qucik {
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length -1 ;
        sort(a, lo, hi);
    }
    private static void sort(Comparable[]a, int lo, int hi){
        if (lo>=hi){
            return;
        }
//        对a数组中从lo到hi的元素进行切分
        int partition = partition(a, lo, hi);
//        对左边分组进行排序
        sort(a, lo, partition - 1);
//        对右边分组进行排序
        sort(a, partition+1, hi);
    }
    private static int partition(Comparable[]a, int lo,int hi){
//        1.找到基准值
        Comparable key = a[lo];
//        2.定义两个指针，left指向lo，right指向hi的后面一个元素
        int left = lo;
        int right = hi + 1;
//        3.进行切分
        while(true){
//            先从右向左扫描，直到扫描到第一个比key小的元素，停止扫描
            while(less(key, a[--right])){
                if (right<=lo){
                    break;
                }
            }
//            再从左向右扫描，直到扫描到第一个比key大的元素，停止扫描
            while (less(a[++left],key)){
                if (left>=right){
                    break;
                }
            }
//            如果left>=right则停止循环，否则交换left和right的位置的值
            if(left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //            交换最后right索引出和基准值所在的索引处的值
        exch(a, lo, right);
        return right;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}