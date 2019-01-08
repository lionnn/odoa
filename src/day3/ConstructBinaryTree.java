package day3;

import java.util.Arrays;

/**
 * 重建二叉树
 * <p>面试题6：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建出图2.6所示的二叉树并输出它的头结点。
 * </p>
 *
 * @author leoss
 * @version 2019/1/4 14:37
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {
        //普通二叉树
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        postorderPrint(root); //后序打印

        //所有节点都没有右节点
//        int[] preorder = {1, 2, 3, 4, 5};
//        int[] inorder = {5, 4, 3, 2, 1};
//        BinaryTreeNode root = construct(preorder, inorder);
//        postorderPrint(root); //后序打印

        //所有节点都没有左节点
//        int[] preorder = {1, 2, 3, 4, 5};
//        int[] inorder = {1, 2, 3, 4, 5};
//        BinaryTreeNode root = construct(preorder, inorder);
//        postorderPrint(root); //后序打印

        //只有一个节点
//        int[] preorder = {1};
//        int[] inorder = {1};
//        BinaryTreeNode root = construct(preorder, inorder);
//        postorderPrint(root); //后序打印

        //  完全二叉树
//        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
//        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
//        BinaryTreeNode root = construct(preorder, inorder);
//        postorderPrint(root); //后序打印

        //NEP
//        BinaryTreeNode root = construct(null, null);
//        postorderPrint(root); //后序打印

        //序列不匹配
//        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
//        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
//        BinaryTreeNode root = construct(preorder, inorder);
//        postorderPrint(root); //后序打印
    }

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 根据前序和中序序列重建二叉树
     *
     * @param preorder 前序序列
     * @param inorder  中序序列
     * @return 二叉树
     */
    private static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length <= 0) {
            throw new RuntimeException("Invalid input.");
        }

        return constructCode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序和中序序列重建二叉树
     *
     * @param preorder 前序序列
     * @param ps       前序遍历开始索引
     * @param pe       前序遍历结束索引
     * @param inorder  中序序列
     * @param is       中序遍历开始索引
     * @param ie       中序遍历结束索引
     * @return 二叉树
     */
    private static BinaryTreeNode constructCode(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        if (ps > pe || is > ie) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode();
        node.val = preorder[ps];

        if (ps == pe) {
            if (is == ie && preorder[ps] == inorder[is]) {
                return node;
            } else {
                throw new RuntimeException("Invalid input.");
            }
        }
        int idx = is;
        while (idx < ie && inorder[idx] != node.val) {
            ++idx;
        }

        if (idx == ie && inorder[idx] != node.val) {
            throw new RuntimeException("Invalid input.");
        }

        int leftLength = idx - is;
        if (leftLength > 0) {
            node.left = constructCode(preorder, ps + 1, ps + leftLength, inorder, is, idx - 1);
        }
        if (leftLength < pe - ps) {
            node.right = constructCode(preorder, ps + leftLength + 1, pe, inorder, idx + 1, ie);
        }

        return node;
    }

    /**
     * 前序打印二叉树
     *
     * @param node 二叉树
     */
    private static void preorderPrint(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderPrint(node.left);
            preorderPrint(node.right);
        }
    }

    /**
     * 中序打印二叉树
     *
     * @param node
     */
    private static void inorderPrint(BinaryTreeNode node) {
        if (node != null) {
            inorderPrint(node.left);
            System.out.print(node.val + " ");
            inorderPrint(node.right);
        }
    }

    /**
     * 后序打印二叉树
     *
     * @param node 二叉树
     */
    private static void postorderPrint(BinaryTreeNode node) {
        if (node != null) {
            postorderPrint(node.left);
            postorderPrint(node.right);
            System.out.print(node.val + " ");
        }
    }

}
