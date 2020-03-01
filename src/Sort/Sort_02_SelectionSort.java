package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/20 11:02
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_02_SelectionSort {

    /**
     * 时间复杂度O(N^2)，额外空间复杂度O(1)
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,5,8,2,4,3,6,4,1,5,3,2};
        selectionSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
