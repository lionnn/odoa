package day6;

/**
 * 二叉搜索树与双向链表
 * <p>面试题27：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * </p>
 *
 * @author leoss
 * @version 2019/1/12 15:29
 */
public class ConvertBST {

    public static void main(String[] args) {
        test("普通二叉树", getTree());

        test("只有左节点的二叉树", getTree2());

        test("只有右节点的二叉树", getTree3());

        test("只有一个节点的二叉树", new BinaryTreeNode(1));

        test("空树", null);
    }

    private static BinaryTreeNode getTree() {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1l = new BinaryTreeNode(6);
        BinaryTreeNode node1r = new BinaryTreeNode(14);
        BinaryTreeNode node2ll = new BinaryTreeNode(4);
        BinaryTreeNode node2lr = new BinaryTreeNode(8);
        BinaryTreeNode node2rl = new BinaryTreeNode(12);
        BinaryTreeNode node2rr = new BinaryTreeNode(16);

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
        BinaryTreeNode node5 = new BinaryTreeNode(0);

        node.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        return node;
    }

    private static BinaryTreeNode getTree3() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);

        node.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        return node;
    }

    private static void test(String test, BinaryTreeNode root) {
        System.out.println(test);
        BinaryTreeNode binaryTreeNode = convertBST(root);

        System.out.println("从左向右:");
        while (binaryTreeNode != null) {
            System.out.print(binaryTreeNode.val + " ");
            if (binaryTreeNode.right == null) {
                break;
            }
                binaryTreeNode = binaryTreeNode.right;
        }

        System.out.println();
        System.out.println("从右向左：");
        while (binaryTreeNode != null) {
            System.out.print(binaryTreeNode.val + " ");
            if(binaryTreeNode.left == null){
                break;
            }
            binaryTreeNode = binaryTreeNode.left;
        }
        System.out.println();
        System.out.println();
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
     * 将二叉搜索树转成双向链表
     * @param root 二叉树
     * @return 双向链表
     */
    private static BinaryTreeNode convertBST(BinaryTreeNode root) {
        if(root == null){
           return null;
        }
        BinaryTreeNode binaryTreeNode = convertBST(root, null);
        while (binaryTreeNode.left != null) {
            binaryTreeNode = binaryTreeNode.left;
        }
        return binaryTreeNode;
    }

    /**
     * 将二叉搜索树转成双向链表
     * @param node 二叉树节点
     * @param tmp 临时节点
     * @return 临时节点
     */
    private static BinaryTreeNode convertBST(BinaryTreeNode node, BinaryTreeNode tmp) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            tmp = convertBST(node.left, tmp);
        }

        node.left = tmp;
        if (tmp != null) {
            tmp.right = node;
        }

        tmp = node;
        if (node.right != null) {
            tmp = convertBST(node.right, tmp);
        }
        return tmp;
    }

}
