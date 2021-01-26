package basisDemo_01;

import javafx.scene.paint.Stop;

/**
 * 计时器
 */
public class Stopwatch {

    private final long start;

    public Stopwatch() {
        //返回以毫秒计数的当前时间
        start = System.currentTimeMillis();
    }

    /**
     * 返回对象创建以来经过的时间
     *
     * @return
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < 99999; i++)
            for (int j = 0; j < 99999; j++) 
                for (int k = 0; k < 99999; k++)
                    ;
        double time = stopwatch.elapsedTime();
        System.out.println(time);
    }
}
