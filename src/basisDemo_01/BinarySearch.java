package basisDemo_01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二分查找算法
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(20 & 5);
        int[] whileList = {13, 18, 9, 88, 65, 18, 77, 44, 99, 33, 25, 11, 71};
        Arrays.sort(whileList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whileList) == -1) {
                StdOut.println(key);
            }
        }
    }
}
