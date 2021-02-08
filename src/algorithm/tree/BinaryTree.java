package algorithm.tree;

public class BinaryTree<Key extends Comparable<Key>, Value>{
    //记录根结点
    private Node root;
    //记录数中元素个数
    private int N;
    private class Node{
        //存储键
        public Key key;
        private Value value;
        public Node left;
        public Node right;
        public Node(Key key, Value value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //获取树中元素的个数
    public int size(){
        return N;
    }
    //向树中添加元素key-value
    public void put(Key key, Value value){
        root = put(root, key,value);

    }
    //向指定的树x中添加元素key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value){
        //如果x子树为空
        if(x ==null){
            N++;
            return new Node(key, value, null, null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            put(x.right, key, value);
        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            put(x.left, key, value);
        }else{
            //如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
           return x;
    }
    //查询树中指定key对应的value
    public Value get(Key key){
        return get(root, key);
    }
    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key){
        //x树为null
        if(x==null){
            return null;
        }
        //x不为null
        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right, key);
        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left, key);
        }else{
            //如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
           return x.value;
        }
    }
    //删除树中key对应的value
    public void delete(Key key){
          delete(root, key);
    }
    //删除指定树x中的key对应的value,并返回删除后的新树
    public Node delete(Node x, Key key){
        //x树为null
        if(x == null){
            return null;
        }
        //x树不为null
        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right, key);
        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left, key);
        }else{
            //让元素减1
            N--;
            //如果key等于x结点的键，完成真正的删除结点的动作，要删除的结点就是x
            if(x.right == null){
                 return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            //得找到右子树中最小的结点
            Node minNode = x.right;
            while(minNode.left!=null){
                minNode = minNode.left;
            }
            //1.然后把右子树中最小的结点置为null，即删除右子树中最小的节点(找最小节点的上一个节点)
            Node n = x.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left = null;
                }else{
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

}
