package algorithm.sort;

public class Shell {
//    1.比较大小
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }
//    2.交换
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//    1.选定一个增长量h，按照增长量h数据分组的依据，对数据进行分组
//    2.对分好组的每一组数据完成插入排序
//    3.减少增长量，最小减为1，重复第二步操作
    public static void sort(Comparable[] a){
//        1.确定增长量h的值
        int h = 1;
        while (h < a.length/2){
            h = 2*h + 1;
        }
//        2.希尔排序
//        当增长量小于1，排序结束
        while(h>=1){
// 2.2 找到待插入的元素,每次分组后第一个待插入的元素都是h
            for(int i = h; i < a.length; i ++){
                for (int j = i; j>=h; j -=h){
//                    a[j]就是待插入元素，依次和a[j - h], a[j - 2h]...a[j - 3h]比较，如果a[j]小则交换，否则结束
                    if(greater(a[j-h], a[j])){
                        exch(a, j-h, j);
                    }else {
                        break;
                    }

                }

            }
//      2.1减小h的值
        h = h /2;
        }


    }
}
