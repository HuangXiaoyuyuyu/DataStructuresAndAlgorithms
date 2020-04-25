package DataStructure.Array;

/**
 * @Author OliverYu
 * @Date 2019/3/1 10:00
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Array_01_PrintMatrixSpiralOrder {

    /**
     * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
     * 例如:
     *      1   2   3   4
     *      5   6   7   8
     *      9   10  11  12
     *      13  14  15  16
     * 打印结果为：
     *      1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
     * 要求： 额外空间复杂度为O(1)。
     *
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0; //tR:topRow 左上角点的横坐标
        int tC = 0; //tR:topColumn 左上角点的纵坐标
        int bR = matrix.length - 1; //bR:bottomRow 右下角点的横坐标
        int bC = matrix[0].length - 1;//bC:bottomColumn 右下角点的纵坐标
        while (tR <= bR && tC <= bC) {
            printEdge(matrix,tR++,tC++,bR--,bC--);
        }
    }

    public static void printEdge(int[][] matrix,int tR,int tC,int bR,int bC) {
        if (tR == bR) { //此时两个点位于同一行
            for (int i=tC; i<=bC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        }else if (tC == bC) { //此时两个点位于同一列
            for (int i=tR; i<=bR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        }else {
            int curR = tR;
            int curC = tC;
            while (curC != bC) {
                System.out.print(matrix[tR][curC++] + " ");
            }
            while (curR != bR) {
                System.out.print(matrix[curR++][bC] + " ");
            }
            while (curC != tC) {
                System.out.print(matrix[bC][curC--] + " ");
            }
            while (curR != tR) {
                System.out.print(matrix[curR--][tC] + " ");
            }
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
        spiralOrderPrint(matrix);
    }
}
