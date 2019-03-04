package DataStructure.Array;

/**
 * @Author OliverYu
 * @Date 2019/3/4 13:55
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Array_04_FindNumInSortedMatrix {

    /**
     * 在行列都排好序的矩阵中找数
     *  给定一个有N*M的整型矩阵matrix和一个整数K，
     *  matrix的每一行和每一列都是排好序的。
     *  实现一个函数，判断K是否在matrix中。
     *
     *  例如： 0 1 2 5
     *        2 3 4 7
     *        4 4 4 8
     *        5 7 7 9
     * 如果K为7，返回true；如果K为6，返回false。
     *
     * 要求：
     *      时间复杂度为O(N+M)，额外空间复杂度为O(1)。
     * @param matrix
     * @param K
     * @return
     */
    public static boolean isContains(int[][] matrix, int K) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == K) {
                return true;
            }else if (matrix[row][col] > K) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                                        { 0,   1,   2,   3,   4,   5,   6 },
                                        { 10,  12,  13,  15,  16,  17,  18 },
                                        { 23,  24,  25,  26,  27,  28,  29 },
                                        { 44,  45,  46,  47,  48,  49,  50 },
                                        { 65,  66,  67,  68,  69,  70,  71 },
                                        { 96,  97,  98,  99,  100, 111, 122 },
                                        { 166, 176, 186, 187, 190, 195, 200 },
                                        { 233, 243, 321, 341, 356, 370, 380 }
                                    };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }
}
