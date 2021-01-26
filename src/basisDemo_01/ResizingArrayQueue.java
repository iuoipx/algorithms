package basisDemo_01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 数组实现队列
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {

    //测试
    public static void main(String[] args) {

        ResizingArrayQueue<String> resizingArrayQueue = new ResizingArrayQueue<>();

        Scanner scanner = new Scanner(System.in);
        //to be or not to - be - - that - - - is
        String str = scanner.nextLine();

        String[] vals = str.split(" ");
        for (String val : vals) {
            if (!val.equals("-")) {
                resizingArrayQueue.enqueue(val);
                System.out.print(val + "进队列，");
            } else if (!resizingArrayQueue.isEmpty()) {
                System.out.print(resizingArrayQueue.dequeue() + "出队列， ");
            }
            System.out.print("当前队列内容: [" + resizingArrayQueue.toString());
            System.out.println("]，队列当前总长度为:" + resizingArrayQueue.maxSize()
                    + "，" + resizingArrayQueue.showInfo());
        }
    }

    private Item a[];

    //指向数组第一个元素，下标
    private int head;

    //指向数组最后一个元素，下标+1
    private int tail;

    //表示数组元素实际个数，tail-head
    private int N;

    public ResizingArrayQueue() {
        a = (Item[]) new Object[1];
        head = 0;
        tail = 0;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public int maxSize() {
        return a.length;
    }

    /**
     * 展示head tail N
     *
     * @return
     */
    public String showInfo() {
        String a = "N:" + N + ",head:" + head + ",tail:" + tail;
        return a;
    }

    /**
     * 动态调整数组大小
     *
     * @param max
     */
    public void resize(int max) {
        Item temp[] = (Item[]) new Object[max];

        //j当 head 值不为0时起作用
        int j = 0;
        for (int i = head; i < tail; i++)
            temp[j++] = a[i];
        a = temp;

        //resize之后重置数组，重新计数
        head = 0;
        tail = N;
    }

    public void enqueue(Item item) {

        //当 tail(最后一个元素下标+1) 越界时，扩大一倍
        if (tail == a.length) {
            resize(a.length * 2);
        }

        a[tail++] = item;

        N++;
    }

    public Item dequeue() {
        Item item = a[head++];

        N--;

        a[head - 1] = null; //回收对象

        //当实际元素数量小于数组长度 1/4 时，缩小一倍
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return a[head];
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int n = head;

        @Override
        public boolean hasNext() {
            return n < tail;
        }

        @Override
        public Item next() {
            if (n == tail) {
                throw new NoSuchElementException();
            }
            return a[n++];
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
}

