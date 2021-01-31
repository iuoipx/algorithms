package sortDemo_02;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

/**
 * 二分法快速排序 适用于没有太多重复元素情况下
 * 将一个数组分为两个子数组，将两部分独立地排序
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        //将左半部分 a[lo...j-1]排序
        sort(a, lo, j - 1);
        //将右半部分 a[j+1...hi]排序
        sort(a, j + 1, hi);
    }

    /**
     * 将数组切分为 a[lo...i-1]<=a[i]<=a[i+1...hi]
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //切分元素
        Comparable v = a[lo];

        while (true) {
            //从左开始扫描，遇到大于等于切分元素的元素结束循环
            while (ExampleUtil.less(a[++i], v))
                if (i == hi) break;

            //从右开始扫描，遇到小于等于切分元素的元素结束循环
            while (ExampleUtil.less(v, a[--j]))
                if (j == lo) break;

            //i和j相遇时推出循环
            if (i >= j)
                break;
            //如果 i<j 交换两者
            ExampleUtil.exch(a, i, j);
        }

        //将切分元素放到正确的位置 a[j]
        ExampleUtil.exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Q U I C K S O R T E X A M P L E
        String[] a = scanner.nextLine().split(" ");
        sort(a);
        ExampleUtil.show(a);
    }
}
