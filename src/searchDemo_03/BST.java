package searchDemo_03;

/**
 * 二叉查找树
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root; //根节点

    private class Node {
        private int N;  //该节点为根的子树中的结点总数
        private Node left, right;
        private Key key;
        private Value value;

        public Node(int n, Key key, Value value) {
            N = n;
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp > 0)
            return get(x.left, key);
        else if (cmp < 0)
            return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 如果key存在于以x为根结点的子树中则更新它的值；
     * 否则将以key和val为键值对的新结点插入到该子树中
     * @param x
     * @param key
     * @param value
     * @return
     */
    public Node put(Node x, Key key, Value value) {
        //key不存在于二叉树中时，新建一个结点
        if (x == null) return new Node(1, key, value);
        int cmp = key.compareTo(x.key);

        //递归：从二叉树的根结点开始，查找key的位置；
        //找到更新value，找不到x == null时将链接指向新建的结点
        if (cmp > 0)
            x.right = put(x.right, key, value);
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else //更新value
            x.value = value;
        //沿搜索路径向上更新链接并增加结点计数器的值
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

}
