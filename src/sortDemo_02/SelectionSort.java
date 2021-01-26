package sortDemo_02;

import java.util.Scanner;

/**
 * 选择排序
 * 1.找到数组中最小的元素，与第一个数据交换
 * 2.在除开第一个数的数组中找到最小元素，与第二个数据交换
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
            ExampleUtil.each(a, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        sort(a);
        ExampleUtil.show(a);
    }
}
