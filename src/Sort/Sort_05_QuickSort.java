package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/23 22:39
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_05_QuickSort {

    /**
     * classic quickSort
     * 时间复杂度O(N*logN)，额外空间复杂度O(logN)
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = partition(arr,L,R);
            quickSort(arr,L,mid-1);
            quickSort(arr,mid+1,R);
        }
    }

    private static int partition(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        int pivot = arr[L];
        while (L < R) {
            while (L < R && arr[R] > pivot) {
                R--;
            }
            if (L < R) {
                swap(arr,L++,R);
            }
            while (L < R && arr[L] <= pivot) {
                L++;
            }
            if (L < R) {
                swap(arr,L,R--);
            }
        }
        return L;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
