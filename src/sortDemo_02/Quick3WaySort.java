package sortDemo_02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 三向切分快速排序 适用于有大量重复元素的数组
 */
public class Quick3WaySort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        //切分元素
        Comparable v = a[lo];

        //三向切分数组 a[lo..lt-1] < v = a[lt...gt] < a[gt+1...hi]
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            //如果 a[i]小于v,交换a[i]与a[lt],将lt和i加一
            if (cmp < 0)
                ExampleUtil.exch(a, lt++, i++);
                //如果 a[i]大于v，交换a[i]与a[gt],将gt减一
            else if (cmp > 0)
                ExampleUtil.exch(a, i, gt--);
                //如果相等，i加一
            else
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
