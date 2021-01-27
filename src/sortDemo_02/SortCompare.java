package sortDemo_02;

import basisDemo_01.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 比较两种排序算法
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch stopwatch = new Stopwatch();
        if (alg.equals("Insertion"))
            InsertionSort.sort(a);
        if (alg.equals("Selection"))
            SelectionSort.sort(a);
        if (alg.equals("Shell"))
            ShellSort.sort(a);
        if (alg.equals("Merge"))
            MergeSort.sort(a);
        return stopwatch.elapsedTime();
    }

    /**
     * 使用alg 算法将T个长度为N的数组排序
     *
     * @param alg 传入的算法名称
     * @param N   长度为N的数组
     * @param T   T个
     * @return 排序所需的总时间
     */
    public static double timeRandomInput(String alg, int N, int T) {

        double total = 0.0;
        Double[] doubles = new Double[N];

        for (int t = 0; t < T; t++) {

            //给数组所有元素赋值
            for (int i = 0; i < N; i++)
                doubles[i] = StdRandom.uniform();

            //计算T个数组排序所需的总时间
            total += time(alg, doubles);
        }
        return total;
    }

    public static void main(String[] args) {

        //模拟命令行参数
        String[] arg = {"Insertion", "Selection", "Shell", "Merge", "10000", "100"};
        String alg1 = arg[0];
        String alg2 = arg[1];
        String alg3 = arg[2];
        String alg4 = arg[3];
        int N = Integer.parseInt(arg[4]);
        int T = Integer.parseInt(arg[5]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);
        double t4 = timeRandomInput(alg4, N, T);

        System.out.printf("%s 总时间: %.3f\r\n", alg1, t1);
        System.out.printf("%s 总时间: %.3f\r\n", alg2, t2);
        System.out.printf("%s 总时间: %.3f\r\n", alg3, t3);
        System.out.printf("%s 总时间: %.3f\r\n", alg4, t4);
        System.out.printf("%s 比 %s 快 %.1f 倍\r\n", alg1, alg2, t2 / t1);
        System.out.printf("%s 比 %s 快 %.1f 倍\r\n", alg3, alg1, t1 / t3);
        System.out.printf("%s 比 %s 快 %.1f 倍\r\n", alg4, alg1, t1 / t4);
    }

}
