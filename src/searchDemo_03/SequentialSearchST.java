package searchDemo_03;

import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

/**
 * 顺序查找（基于无序链表）
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {

    //链表首节点
    private Node first;

    //结点数量
    private int n;

    /**
     * 内部类定义链表结点
     */
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 根据给定的key，查找对应的value
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }

    /**
     * 根据给定的key和value，判断key是否已经存在去更新或者新建结点
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        //如果传入val为空，那么删除该结点
        if (val == null) {
            delete(key);
            return;
        }

        //遍历链表，如果该key已经存在于链表中，更新value
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }

        //如果不存在与链表中，即新建结点
        first = new Node(key, val, first);
        n++;
    }

    /**
     * 判断链表的结点中是否存在key值
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * 根据key删除结点，并重新链接链表
     * @param key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        //根据key找到需要删除的结点，并返回该结点next
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }

        //递归查找删除的结点，并将该节点的next结点重新链接
        x.next = delete(x.next, key);
        return x;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        //S E A R C H E X A M P L E
        String[] a = scanner.nextLine().split(" ");
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            st.put(key, i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}
