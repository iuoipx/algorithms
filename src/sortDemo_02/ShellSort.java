package sortDemo_02;

import java.util.Scanner;

/**
 * 希尔排序
 * 改进版的插入排序
 * 数组中每个元素与距离 h倍数位置的元素有序，h按照增序列递减
 * 如 0 ... 4 ... 8 ... 12
 *   1 ... 5 ... 9 ... 13
 * 当 h 为1时数组全部有序
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1; //1 , 4 , 13 , 40 , 121 ...

        while (h >= 1) {

            for (int i = h; i < a.length; i++)
                for (int j = i; j >= h && ExampleUtil.less(a[j], a[j - h]); j = j - h)
                    ExampleUtil.exch(a, j, j - h);
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //S H E L L S O R T E X A M P L E
        String[] a = scanner.nextLine().split(" ");
        sort(a);
        ExampleUtil.show(a);
    }
}
