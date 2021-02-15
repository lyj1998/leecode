package algorithm.test;

import algorithm.tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建二叉树查找对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "张三");
        tree.put(2, "李四");
        tree.put(3, "王五");
        System.out.println("插入完毕后的元素的个数:"+tree.size());
        //测试获取
        System.out.println("键2对应的元素是:"+tree.get(2));
        //测试删除
        tree.delete(3);

        System.out.println("删除完毕后的元素的个数:"+tree.size());
        System.out.println("删除后键3对应的元素是:"+tree.get(3));
    }
}
