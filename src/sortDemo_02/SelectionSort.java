package sortDemo_02;

import java.util.Scanner;

/**
 * 选择排序
 * 特点:
 * ①运行时间和输入无关：如果输入数组默认有序，依然要进行两层循环比较后并且每次都与自己交换
 * ②数据移动最小：仅移动数组长度的次数N
 * 1.找到数组中最小的元素，与第一个元素交换；
 * 2.在除开第一个数的数组中找到最小元素，与第二个元素交换；
 * 3.如此往复，直至排序整个数组
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {

            //min 保存最外层每次循环中最小值
            int min = i;
            for (int j = i + 1; j < a.length; j++)

                //如果数组中 min指向元素后面元素比 j指向元素小，min将指向该元素 min = j
                if (ExampleUtil.less(a[j], a[min]))
                    min = j;

            //将每次循环中最小值与 i的位置交换
            ExampleUtil.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //S O R T E X A M P L E
        String[] a = scanner.nextLine().split(" ");
        sort(a);
        ExampleUtil.show(a);
    }
}
