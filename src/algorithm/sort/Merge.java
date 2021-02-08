package algorithm.sort;

public class Merge {
//    归并需要的辅助数组
    private static Comparable[] assist;
//    比较v元素是否小于W元素
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

//    数组元素i和j交换位置
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//    对数组中元素进行排序
    public static void sort(Comparable[] a){
//        1.初始化辅助数组assit
        assist = new Comparable[a.length];
//        2.定义一个lo变量，和hi变量，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length - 1;
//        3.调用sort重载方法完成数组
        sort(a, lo, hi);
    }
//    对数组a从lo到hi的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi){
//        做安全性校验
//        递归函数的出口，hi=lo，说明已经分到了每组都只有1个数
        if(hi<=lo){
            return;
        }
//       对lo到hi之间的数据分成两个组
        int mid = lo + (hi - lo)/2;
//        分别对每一组数据进行排序
        sort(a, lo, mid);
        sort(a, mid+1, hi);
//        再把两个组中的数据进行归并
        merge(a, lo, mid, hi);
    }
//    对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
    private static void merge(Comparable[] a, int lo, int mid, int hi){
//        1.定义三个指针
       int i = lo;// 定义一个指针，指向assist数组归并到辅助数组assit对应的索引处
       int p1 = lo;//定义一个指针，指向第一组数组的第一个元素
       int p2 = mid + 1;//定义一个指针，指向第二组数据的第一个元素
//        2.遍历，移动p1和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组的索引处
        while(p1<=mid&&p2<=hi){
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }
//        3.遍历，如果p1指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1<=mid){
            assist[i++] = a[p1++];
        }
//        3.2遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while (p2<=hi){
            assist[i++] = a[p2++];
        }
//        4.把辅助数组中的元素拷贝到原数组中
        for (int index=lo; index <= hi; index++){
            a[index] = assist[index];
        }
    }
}
