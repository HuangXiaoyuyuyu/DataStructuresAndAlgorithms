package DataStructure.Array;

/**
 * @Author OliverYu
 * @Date 2019/3/1 14:27
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Array_02_RotateMatrix {

    /**
     * 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
     *
     * 例如:
     *      1   2   3   4
     *      5   6   7   8
     *      9   10  11  12
     *      13  14  15  16
     * 打印结果为：
     *      13  9   5  1
     *      14  10  6  2
     *      15  11  7  3
     *      16  14  8  4
     *
     * 要求：额外空间复杂度为O(1)。
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int tR = 0; //tR:topRow 左上角点的横坐标
        int tC = 0; //tR:topColumn 左上角点的纵坐标
        int bR = matrix.length - 1; //bR:bottomRow 右下角点的横坐标
        int bC = matrix[0].length - 1;//bC:bottomColumn 右下角点的纵坐标
        while (tR <= bR && tC <= bC) {
            rotateEdge(matrix,tR++,tC++,bR--,bC--);
        }
    }

    public static void rotateEdge(int[][] matrix, int tR, int tC, int bR, int bC) {
        int gap = bC - tC; //计算出最左侧和最右侧的列数差
        int temp = 0;
        for (int i=0; i<gap ;i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[bR - i][tC];
            matrix[bR - i][tC] = matrix[bR][bC - i];
            matrix[bR][bC - i] = matrix[tR + i][bC];
            matrix[tR + i][bC] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 1,  2,  3,  4 },
                        { 5,  6,  7,  8 },
                        { 9,  10, 11, 12},
                        { 13, 14, 15, 16}
                };
        printMatrix(matrix);
        System.out.println("======================");
        rotate(matrix);
        printMatrix(matrix);

    }

}
