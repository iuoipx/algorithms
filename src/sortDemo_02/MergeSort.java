package sortDemo_02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 归并排序 时间复杂度：NlgN ，需要额外使用数组长度 N的空间
 */
public class MergeSort {

    private static Comparable[] aux;

    /**
     * 自顶向下
     * @param a
     */
//    public static void sort(Comparable[] a) {
//        aux = new Comparable[a.length];
//        sort(a, 0, a.length - 1);
//    }
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        //...
        // sort(a,0,3)
        //    sort(a,0,1) -> merge(a,0,0,1) 即左半边归并有序 {a[0],a[1]}
        //    sort(a,2,3) -> merge(a,2,2,3) 即右半边归并有序 {a[2],a[3]}
        //    merge(a,0,1,3) 再统一归并有序{a[0],a[1],a[2],a[3]}
        // sort(a,4,7)
        //...

        //递归排序左半边
        sort(a, lo, mid);

        //递归排序右半边
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }


    /**
     * 自底向上
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }

    //原地归并，先将传进来的数组数据 a复制给临时数组，之后排序完毕再还给a
    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;

        /**
         * 先将a[lo..hi]复制到aux[lo..hi]
         */
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        //排序
        for (int k = lo; k <= hi; k++) {
            //如果左边取完了，从右边取
            if (i > mid)
                a[k] = aux[j++];
                //如果右边取完了，从左边取
            else if (j > hi)
                a[k] = aux[i++];
                //* 如果右边的比左边的小，取右边
            else if (ExampleUtil.less(aux[j], aux[i]))
                a[k] = aux[j++];
                //* 否则取左边
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //M E R G E S O R T E X A M P L E
        String[] a = scanner.nextLine().split(" ");
        sort(a);
        ExampleUtil.show(a);
    }

}
