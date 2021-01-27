package sortDemo_02;

import java.util.Scanner;

/**
 * 插入排序
 * 特点：
 * 适用于部分有序的数组和小规模数组，在逆序数组的情况下最耗时
 * 1.从数组中的第二个元素（i=1）开始循环到数组的最后一个元素，将它与左边的一个元素比较，分两种情况：
 * 2.如果它比左边的元素小，两者交换位置，继续比较左边的左边元素，直到遇到它比左边的元素大的情况；
 * 3.如果它比左边的元素大，那么它就比左边所有元素都大，此时不符合循环条件，不做处理。因为它左边元素有序,如下:
 * 3.1.第一轮循环结束后，前两个元素有序；
 * 3.2.第二轮循环结束后，前三个元素有序；
 * 4.如此往复，直到最后一个元素。
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {

        //1.交换位置
//        for (int i = 1; i < a.length; i++) {
//            for (int j = i; j > 0 && ExampleUtil.less(a[j], a[j - 1]); j--)
//                ExampleUtil.exch(a, j, j - 1);
//        }

        //2.赋值
        for (int i = 1; i < a.length; i++) {
            //保存当前元素
            Comparable v = a[i];

            //使用j保存i，避免i修改
            int j = i;

            //当当前元素比左边元素小时，直接将当前元素值修改为左边元素（即将大的元素右移），当前元素被覆盖，j--，继续比较

            //while写法
//            while (ExampleUtil.less(v, a[j - 1])) {
//                a[j] = a[j - 1];
//                j--;
//                if (j == 0)
//                    break;
//            }

            //for写法
            for (; j > 0 && ExampleUtil.less(v, a[j - 1]); j--)
                a[j] = a[j - 1];

            //a[j]被 a[j-1]覆盖，而 a[j]开始被保存在v中，循环结束后将v赋给 a[j-1](即j--后的a[j])
            a[j] = v;
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
