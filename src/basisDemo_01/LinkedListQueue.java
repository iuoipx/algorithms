package basisDemo_01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 链表实现队列
 *
 * @param <Item>
 */
public class LinkedListQueue<Item> implements Iterable<Item> {

    public static void main(String[] args) {
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();

        Scanner scanner = new Scanner(System.in);
        //to be or not to - be - - that - - - is
        String str = scanner.nextLine();

        String[] vals = str.split(" ");
        for (String val : vals) {
            if (!val.equals("-")) {
                linkedListQueue.enqueue(val);
                System.out.print(val + "进队列，");
            } else if (!linkedListQueue.isEmpty()) {
                System.out.print(linkedListQueue.dequeue() + "出队列， ");
            }
            System.out.println("当前队列内容: [" + linkedListQueue.toString() + "]");
        }
    }

    //链表首元素
    private Node first;

    //链表尾元素
    private Node last;

    private int N;

    public LinkedListQueue() {
        first = null;
        last = null;
        N = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<Item> {

        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * 添加元素到队列尾
     *
     * @param item
     */
    public void enqueue(Item item) {
        //保存尾部结点信息
        Node oldLast = last;

        //last保存传入的信息
        last = new Node();
        last.item = item;
        last.next = null;

        //如果链表为空，first也指向 last
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    /**
     * 从队首删除元素
     *
     * @return
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        //保存队首结点信息
        Item item = first.item;

        //使first指向first结点的下一个结点
        first = first.next;

        //如果链表为空，修改last，置为 null
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
}
