package searchDemo_03;

/**
 * 二分查找（基于有序数组）
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key celling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    public void delete(Key key) {
        if (isEmpty())
            return;

        //查找key在数组中位置
        int i = rank(key);

        //如果key在数组中不存在直接return
        if (i == N || keys[i].compareTo(key) != 0)
            return;

        //将key的位置i后面的所有元素都向前移一位
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        //N减一，且将原来的最后一个元素置空，回收内存
        N--;
        keys[N] = null;
        keys[N] = null;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;

        //遍历key数组查找key位置
        while (lo <= hi) {
            //先去中间值
            int mid = lo + (hi - lo) / 2;
            //比较中间值与key
            int cmp = keys[mid].compareTo(key);
            //如果中间值比key大，从左半边里找，使hi = mid-1
            if (cmp > 0)
                hi = mid - 1;
                //如果中间值比key小，从右半边里找，使lo = mid+1
            else if (cmp < 0)
                lo = mid + 1;
                //中值等于key直接返回
            else
                return mid;
        }

        //没找到key的话，lo表示key结果比较后应该放到的位置
        return lo;
    }

    public void put(Key key, Value value) {
        //找到 key在数组里的位置i
        int i = rank(key);

        //如果key在数组里已经存在，更新value
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        //key不存在的话，将key所在位置i后面的元素都往后移一位
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        //最后将key和value分别加入数组,N+1
        keys[i] = key;
        values[i] = value;
        N++;
    }
}
