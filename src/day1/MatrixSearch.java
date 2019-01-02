package day1;

/**
 * 二维数组中查找
 * <p>面试题3：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>
 *
 * @author leoss
 * @version 2019/1/2 23:42
 */
public class MatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9, 11},
                {2, 4, 9, 12, 13},
                {4, 7, 10, 13, 16},
                {6, 8, 11, 15, 21}};

        int num1 = 1;
        System.out.println(num1 + " in matrix is " + checkMatrix(matrix, num1));
        int num2 = 21;
        System.out.println(num2 + " in matrix is " + checkMatrix(matrix, num2));
        int num3 = 16;
        System.out.println(num3 + " in matrix is " + checkMatrix(matrix, num3));
        int num4 = 0;
        System.out.println(num4 + " in matrix is " + checkMatrix(matrix, num4));
        int num5 = 30;
        System.out.println(num5 + " in matrix is " + checkMatrix(matrix, num5));
        int num6 = 3;
        System.out.println(num6 + " in matrix is " + checkMatrix(matrix, num6));

        int num = 4;
        matrix = null;
        System.out.println(num + " in matrix is " + checkMatrix(matrix, num));

    }

    private static boolean checkMatrix(int[][] matrix, int num) {
        boolean exist = false;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            // TODO 这里省略对每行长度的检查，只是简单从第1行判断是否为空，如果考虑健壮性，是需要检查的，不在本题的考察范围
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0, j = col - 1; i < row && j >= 0; ) {
                if (matrix[i][j] == num) {
                    exist = true;
                    break;
                } else if (matrix[i][j] > num) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            System.out.println("matrix is empty");
        }
        return exist;
    }
}
