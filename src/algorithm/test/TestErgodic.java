package algorithm.test;
import algorithm.tree.BinaryTree;
import sun.awt.SunHints;

import java.util.LinkedList;
import java.util.Queue;

public class TestErgodic {
    public static void main(String[] args) {
//        //前序遍历
//        BinaryTree<String, String > tree = new BinaryTree<>();
//        tree.put("E", "5");
//        tree.put("B", "2");
//        tree.put("G", "7");
//        tree.put("A", "1");
//        tree.put("D", "4");
//        tree.put("F", "6");
//        tree.put("H", "8");
//        tree.put("C", "3");
//        Queue<String> keys = new LinkedList<>();
//        keys = tree.preErgodic();
//        for (String key:keys) {
//            String value = tree.get(key);
//            System.out.println(key+"----->"+value);
//        }

//        //中序遍历
//        BinaryTree<String, String > tree = new BinaryTree<>();
//        tree.put("E", "5");
//        tree.put("B", "2");
//        tree.put("G", "7");
//        tree.put("A", "1");
//        tree.put("D", "4");
//        tree.put("F", "6");
//        tree.put("H", "8");
//        tree.put("C", "3");
//        Queue<String> keys = new LinkedList<>();
//        keys = tree.midErgodic();
//        for (String key:keys) {
//            String value = tree.get(key);
//            System.out.println(key+"----->"+value);
//        }
//        //后序遍历
//        BinaryTree<String, String > tree = new BinaryTree<>();
//        tree.put("E", "5");
//        tree.put("B", "2");
//        tree.put("G", "7");
//        tree.put("A", "1");
//        tree.put("D", "4");
//        tree.put("F", "6");
//        tree.put("H", "8");
//        tree.put("C", "3");
//        Queue<String> keys = new LinkedList<>();
//        keys = tree.afterErgodic();
//        for (String key:keys) {
//            String value = tree.get(key);
//            System.out.println(key+"----->"+value);
//        }
//        //层次
//        BinaryTree<String, String > tree = new BinaryTree<>();
//        tree.put("E", "5");
//        tree.put("B", "2");
//        tree.put("G", "7");
//        tree.put("A", "1");
//        tree.put("D", "4");
//        tree.put("F", "6");
//        tree.put("H", "8");
//        tree.put("C", "3");
//        Queue<String> keys = new LinkedList<>();
//        keys = tree.layerErgodic();
//        for (String key:keys) {
//            String value = tree.get(key);
//            System.out.println(key+"----->"+value);
//        }
        //最大深度
        BinaryTree<String, String > tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        int depth = 0;
        depth = tree.maxDepth();
        System.out.println("树的深度为"+depth);
    }
}
