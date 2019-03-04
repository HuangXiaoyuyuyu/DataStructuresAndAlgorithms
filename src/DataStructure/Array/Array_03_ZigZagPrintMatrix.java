package DataStructure.Array;

/**
 * @Author OliverYu
 * @Date 2019/3/1 16:07
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Array_03_ZigZagPrintMatrix {

    /**
     * “之”字形打印矩阵
     *    给定一个矩阵matrix，按照“之”字形的方式打印这
     * 个矩阵，例如： 1   2   3   4
     *               5   6   7   8
     *               9   10 11  12
     * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
     * 要求：
     *  额外空间复杂度为O(1)。
     * @param matrix
     */
    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR <= endR) {
            printLevel(matrix,tR,tC,bR,bC,fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] matrix, int tR, int tC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (tR != bR + 1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        }else {
            while (bR != tR - 1) {
                System.out.print(matrix[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {  { 1, 2, 3, 4 },
                            { 5, 6, 7, 8 },
                            { 9, 10,11,12 }
                        };
        printMatrixZigZag(matrix);

    }
}
