package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/20 11:49
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_03_InsertSort {

    /**
     * 时间复杂度O(N^2)，额外空间复杂度O(1)
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 8, 2, 4, 3, 6, 4, 1, 5, 3, 2};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}