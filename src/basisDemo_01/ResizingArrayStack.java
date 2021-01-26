package basisDemo_01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 数组实现栈 默认长度为 1，存放 0个元素，即 null
 * 添加元素前判断栈是否已满，满的话将栈长度乘以2，再添加该元素
 * 删除元素后判断栈元素长度是否小于栈总长度1/4，是的话将栈长度除以2
 *
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    //测试
    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>();

        Scanner scanner = new Scanner(System.in);
        //1 2 3 4 - 3 - 5 - - -
        String str = scanner.nextLine();

        String[] vals = str.split(" ");
        for (String val : vals) {
            if (!val.equals("-")) {
                resizingArrayStack.push(val);
                System.out.print(val + "进栈，");
            } else if (!resizingArrayStack.isEmpty()) {
                System.out.print(resizingArrayStack.pop() + "出栈， ");
            }

            System.out.print("当前栈内容: [" + resizingArrayStack.toString());
            System.out.println("]，栈当前总长度为:" + resizingArrayStack.maxSize());
        }

        System.out.println("(栈中还有" + resizingArrayStack.size() + "个元素)");
    }

    //栈数组,长度为1
    private Item a[];

    //栈元素实际数量
    private int N;

    public ResizingArrayStack() {
        a = (Item[]) new Object[1];
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
     * 添加元素到栈顶
     *
     * @param item
     */
    public void push(Item item) {
        //如果栈数组的实际元素长度 N等于栈数组的最大长度，将数组长度扩大1倍
        if (N == a.length)
            resize(a.length * 2);

        a[N++] = item;
    }

    /**
     * 从栈顶弹出元素
     *
     * @return
     */
    public Item pop() {

        if (isEmpty())
            throw new NoSuchElementException("stack is null");
        Item item = a[--N];

        //将弹出的数组元素的值置为 null，回收内存
        a[N] = null;

        //如果数组中实际元素只剩四分之一时，将数组总长度缩小1倍，即总长度 = 已有元素长度*2
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return item;
    }

    /**
     * 返回栈顶元素
     *
     * @return
     */
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("stack is null");
        return a[N - 1];
    }

    /**
     * 将大小为 N<=max 的栈移动到一个新的大小为 max的数组中
     *
     * @param max
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 实现了Iterator接口的迭代器类
     */
    private class ReverseArrayIterator implements Iterator<Item> {

        //逆序，从栈顶遍历
        private int i;

        public ReverseArrayIterator() {
            i = N;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[--i];
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
