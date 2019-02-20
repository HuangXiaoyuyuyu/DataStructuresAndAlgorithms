package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/20 21:58
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_04_MergeSort {

    /**
     * 时间复杂度O(N*logN)，额外空间复杂度O(N)
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }

    public static void sortProcess(int[] arr,int L,int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R-L)>>1);
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int mid,int R) {
        int[] temp = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <=R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        for (i=0; i<temp.length; i++) {
            arr[L+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 8, 2, 4, 3, 6, 4, 1, 5, 3, 2};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
