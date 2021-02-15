package algorithm.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录数中元素个数
    private int N;

    private class Node {
        //存储键
        public Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);

    }

    //向指定的树x中添加元素key-value,并返回添加元素后新的树
    public Node put(Node x, Key key, Value value) {
        //如果x子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left, key, value);
        } else {
            //如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x不为null
        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right, key);
        } else if (cmp < 0) {
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left, key);
        } else {
            //如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }

    //删除指定树x中的key对应的value,并返回删除后的新树
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left, key);
        } else {
            //让元素减1
            N--;
            //如果key等于x结点的键，完成真正的删除结点的动作，要删除的结点就是x
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            //得找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //1.然后把右子树中最小的结点置为null，即删除右子树中最小的节点(找最小节点的上一个节点)
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //2.将x.left指向右子树中最小的结点，x.right指向右子树中最小的结点
            minNode.left = x.left;
            minNode.right = x.right;
            //3.x的父节点的左节点指向子树中最小的结点
            x = minNode;

        }
        return x;
    }
    //查找二叉树中最小的键
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }
    //查找二叉树中最大的键
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }
    //使用前序遍历，获取整个树中的所有键
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new LinkedList<>();
        preErgodic(root, keys);
        return keys;
    }
    //使用前序遍历，把指定树x中所有的键放入到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        //1.将当前节点的key放到队列中
        keys.offer(x.key);
        //2.找到当前节点的左子树，如果不为空，递归遍历左子树
        preErgodic(x.left, keys);
        //3.找到当前节点的右子树，如果不为空，递归遍历右子树
        preErgodic(x.right, keys);
    }
    //使用中序遍历
    public Queue midErgodic(){
        Queue<Key> keys = new LinkedList<>();
        midErgodic(root, keys);
        return keys;
    }
    private void midErgodic(Node x, Queue keys){
        if(x == null){
            return;
        }
        //如果左子树不为空，先遍历左子树
        midErgodic(x.left, keys);
        //遍历根节点
        keys.offer(x.key);
        //如果右子树不为空，先遍历右子树
        midErgodic(x.right, keys);
    }
    //使用后序遍历
    public Queue afterErgodic(){
        Queue<Key> keys = new LinkedList<>();
        afterErgodic(root, keys);
        return keys;
    }
    private void afterErgodic(Node x, Queue keys){
        if(x == null){
            return;
        }
        //如果左子树不为空，先遍历左子树
        afterErgodic(x.left, keys);
        //如果右子树不为空，先遍历右子树
        afterErgodic(x.right, keys);
        //遍历根节点
        keys.offer(x.key);
    }
    //层次遍历，获取整个树中所有的键
    public Queue<Key> layerErgodic(){
        //先创建两个队列，一个分别存储树中的结点和树中的键
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> nodes = new LinkedList<>();
        //默认，往队列中放入根节点
        nodes.offer(root);
        //当队列nodes中不为空时，做三件事
        while(!nodes.isEmpty()){
            //1.从队列nodes中弹出一个结点，并将key放入队列keys中
            Node n = nodes.poll();
            keys.offer(n.key);
            //2.如果左节点不为空，放入队列nodes
            if(n.left!=null){
                nodes.offer(n.left);
            }
            //3.如果右节点不为空，放入队列nodes
            if(n.right!=null){
                nodes.offer(n.right);
            }
        }
        return keys;
    }
    //计算整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    private int maxDepth(Node x){
        //如果根节点为空
        if (x == null){
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        //2.计算左子树的最大深度
        if(x.left !=null){
            maxL = maxDepth(x.left);
        }
        //2.计算右子树的最大深度
        if(x.right !=null){
            maxR = maxDepth(x.right);
        }
        max = maxL>maxR ? maxL+1:maxR+1 ;
        return max;
    }

}
