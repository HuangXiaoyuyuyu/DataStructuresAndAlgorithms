package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/22 10:40
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_04_MergeSort_ReverseAlignment {

    /**
     * 逆序对问题
     * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序对的个数。
     * 例如，数组（3，1，4，5，2）的逆序对有(3,1),(3,2),(4,2),(5,2)，共4个。
     */

    public static int reverseAlignment(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(int[] arr,int L,int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R-L)>>1);
        return mergeSort(arr,L,mid)
            + mergeSort(arr,mid+1,R)
            + merge(arr,L,mid,R);
    }

    public static int merge(int[] arr,int L,int mid,int R) {
        int[] temp= new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int num = 0;
        while (p1 <= mid && p2 <=R) {
            num += arr[p1] < arr[p2] ? 0 : R-p2+1;
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
        return num;
    }
}
