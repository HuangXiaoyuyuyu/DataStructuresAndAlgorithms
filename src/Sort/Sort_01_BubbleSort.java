package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/20 10:07
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_01_BubbleSort {

    /**
     * 时间复杂度O(N^2)，额外空间复杂度O(1)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                   swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,5,8,2,4,3,6,4,1,5,3,2};
        bubbleSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
