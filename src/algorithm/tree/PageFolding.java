package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PageFolding {
    public static void main(String[] args) {
        //构建折痕树
        Node tree = createTree(2);
        //遍历折痕树并打印
        printTree(tree);
    }

    private static void printTree(Node root) {
        if(root == null){
            return;
        }
        //中序遍历
        //先访问左子树
        printTree(root.left);
        //访问当前节点
        System.out.print(root.item+" ");
        //访问右子树
        printTree(root.right);

    }

    private static Node createTree(int N) {
        Node root = null;
        for (int i = 0; i < N; i++) {
            if(i == 0){
                root = new Node("down", null, null);
            }else{
                //2.如果不是第一次对折，则使用队列保存根结点
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);
                //3.村换遍历队列
                while (!queue.isEmpty()){
                    //3.1从队列中拿出一个节点，
                    Node n = queue.poll();
                    //3.2 如果这个节点的左节点不为空，将其左子节点添加到队列中
                    if(n.left!=null){
                        queue.offer(n.left);
                    }
                    //3.3 如果这个节点的右节点不为空，将其右子节点添加到队列中
                    if(n.right!=null){
                        queue.offer(n.right);
                    }
                    //3.4如果左右节点为空，则需要为其添加左右折痕
                    if(n.left==null && n.right == null){
                        n.left = new Node("down", null, null);
                        n.right = new Node("up", null, null);
                    }
                }
            }
        }
        return root;
    }
    //1.定义结点类
    private static class Node{
        //存储结点元素
        String item;
        //左子节点
        Node left;
        //右子结点
        Node right;
        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
