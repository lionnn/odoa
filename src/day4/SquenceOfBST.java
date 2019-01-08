package day4;

/**
 * 二叉搜索树的后序遍历序列
 * <p>面试题24：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 例如输入数组：{5，7，6，9，11，10，8}，则返回true；{7，4，6，5}，则返回false。
 * </p>
 *
 * @author leoss
 * @version 2019/1/8 23:09
 */
public class SquenceOfBST {

    public static void main(String[] args) {

        //完全二叉树
        int[] seq = {4, 8, 6, 12, 16, 14, 10};
        test("t1", seq, seq.length, true);

        //普通二叉树
        int[] seq2 = {4, 6, 7, 5};
        test("t2", seq2, seq2.length, true);

        //只有左节点的二叉树
        int[] seq3 = {1, 2, 3, 4, 5};
        test("t3", seq3, seq3.length, true);

        //只有右节点的二叉树
        int[] seq4 = {5, 4, 3, 2, 1};
        test("t4", seq4, seq4.length, true);

        //只有一个节点的二叉树
        int[] seq5 = {5};
        test("t5", seq5, seq5.length, true);

        //非二叉树
        int[] seq6 = {7, 4, 6, 5};
        test("t6", seq6, seq6.length, false);

        //非二叉树
        int[] seq7 = {4, 6, 12, 8, 16, 14, 10};
        test("t7", seq7, seq7.length, false
        );

        //空指针
        test("t5", null, 0, false);

    }

    private static void test(String test, int[] seq, int length, boolean expected) {
        boolean result = verifyBst(seq, 0, length - 1);
        System.out.print(test + " result : " + result + " ");
        if (result == expected) {
            System.out.println("passed.");
        } else {
            System.out.println("failed.");
        }

    }

    /**
     * 判断输入数组是否是二叉树后序遍历序列
     *
     * @param seq   后序遍历序列
     * @param start 开始索引
     * @param end   结束索引
     * @return 判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同
     */
    private static boolean verifyBst(int[] seq, int start, int end) {
        if (seq == null || seq.length == 0) {
            return false;
        } else if (seq.length == 1) {
            return true;
        }

        int root = seq[end];

        //找到右子树的开始索引
        int i = start;
        while (seq[i] < root && i++ < end) {
        }

        //如果右子树中有小于根的值，则不是二叉搜索树
        int j = i;
        while (j < end - 1) {
            if(seq[j] < root){
                return false;
            }
            j++;
        }


        boolean left = true;
        if (i - 1 > start) {
            left = verifyBst(seq, start, i - 1);
        }

        boolean right = true;
        if (i < end - 1) {
            right = verifyBst(seq, i, end - 1);
        }

        return left && right;
    }

}
