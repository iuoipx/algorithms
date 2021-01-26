package sortDemo_02;

/**
 * 排序算法中使用的公共方法
 */
public class ExampleUtil {
//    public static void sort(Comparable[] a) {
//
//    }

    /**
     * v<w 返回 true
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 接收一个数组与数组中的两个索引，并将索引指向的数据交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void each(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印传入的数组
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println("");
    }

    /**
     * 测试数据元素是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }
}
