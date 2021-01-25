package basisDemo_01;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 链表实现栈
 */
public class LinkedListStack<Item> implements Iterable<Item> {

    public static void main(String[] args) {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();

        Scanner scanner = new Scanner(System.in);
        //to be or not to - be - - that - - - is
        String str = scanner.nextLine();

        String[] vals = str.split(" ");
        for (String val : vals) {
            if (!val.equals("-")) {
                linkedListStack.push(val);
                System.out.print(val + "进栈，");
            } else if (!linkedListStack.isEmpty()) {
                System.out.print(linkedListStack.pop() + "出栈， ");
            }
            System.out.print("当前栈内容: [");
            for (String s : linkedListStack)
                System.out.print(s + " ");
            System.out.println("]");
        }
    }

    //链表首元素
    private Node first;

    //元素实际个数
    private int N;

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
     * 栈顶添加元素
     *
     * @param item
     */
    public void push(Item item) {
        //保存当前首部结点信息
        Node oldFirst = first;

        //first保存传入的数据，并指向保存的结点
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        N++;
    }

    /**
     * 栈顶弹出元素
     *
     * @return
     */
    public Item pop() {
        //保存首部元素的信息
        Item item = first.item;

        //使first引用first的下一个结点
        first = first.next;
        N--;
        return item;
    }

}
