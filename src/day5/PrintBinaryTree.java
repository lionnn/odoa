package day5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 * <P>面试题23：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如输入下图中的二叉树，则打印出8，6，10，5，7，9，11。</P>
 *
 * @author leoss
 * @version 2019/1/10 22:11
 */
public class PrintBinaryTree {

    public static void main(String[] args) {

        //普通二叉树
        printBinaryTree(getTree());

        //只有左节点的二叉树
        System.out.println("");
        printBinaryTree(getTree2());

        //只有右节点的二叉树
        System.out.println("");
        printBinaryTree(getTree3());

        //只有一个节点的二叉树
        System.out.println("");
        printBinaryTree(new BinaryTreeNode(1));

        //空树
        System.out.println("");
        printBinaryTree(null);

    }

    private static BinaryTreeNode getTree() {
        BinaryTreeNode node = new BinaryTreeNode(8);
        BinaryTreeNode node1l = new BinaryTreeNode(6);
        BinaryTreeNode node1r = new BinaryTreeNode(10);
        BinaryTreeNode node2ll = new BinaryTreeNode(5);
        BinaryTreeNode node2lr = new BinaryTreeNode(7);
        BinaryTreeNode node2rl = new BinaryTreeNode(9);
        BinaryTreeNode node2rr = new BinaryTreeNode(11);

        node.left = node1l;
        node.right = node1r;
        node1l.left = node2ll;
        node1l.right = node2lr;
        node1r.left = node2rl;
        node1r.right = node2rr;

        return node;
    }

    private static BinaryTreeNode getTree2() {
        BinaryTreeNode node = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(1);

        node.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        return node;
    }

    private static BinaryTreeNode getTree3() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);

        node.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;

        return node;
    }

    /**
     * 二叉树节点
     */
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 从上到下打印二叉树
     * <p>队列实现</p>
     *
     * @param node 二叉树
     */
    private static void printBinaryTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        Deque<BinaryTreeNode> deque = new LinkedList<>();
        deque.push(node);

        while (deque.size() > 0) {
            BinaryTreeNode tmp = deque.pop();
            System.out.print(tmp.val + " ");
            if (tmp.left != null) {
                deque.add(tmp.left);
            }
            if (tmp.right != null) {
                deque.add(tmp.right);
            }
        }
    }

    /**
     * 从上到下打印二叉树
     * <p>递归实现</p>
     *
     * @param node 二叉树
     */
    private static void printBinaryTree2(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printBinaryTree3(node);
    }

    private static void printBinaryTree3(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.print(node.left.val + " ");
        }
        if (node.right != null) {
            System.out.print(node.right.val + " ");
        }
        printBinaryTree3(node.left);
        printBinaryTree3(node.right);
    }

}
