package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/21 11:18
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_04_MergeSort_SmallSum {

    /**
     * 小和问题
     * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
     * 的小和。
     * 例子：
     * [1,3,4,2,5]
     * 1左边比1小的数，没有；
     * 3左边比3小的数，1；
     * 4左边比4小的数，1、3；
     * 2左边比2小的数，1；
     * 5左边比5小的数，1、3、4、2；
     * 所以小和为1+1+3+1+1+3+4+2=16
     */

    public static int smallSum(int[] arr) {
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
        return mergeSort(arr,L,mid) + mergeSort(arr,mid+1,R) + merge(arr,L,mid,R);
   }

   public static int merge(int[] arr,int L,int mid,int R) {
        int[] temp = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ?  arr[p1]*(R-p2+1) : 0;
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
        return res;
   }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 8, 2, 4, 3, 6, 4, 1, 5, 3, 2};
        //int[] arr = new int[]{1,3,4,2,5};
        System.out.println(smallSum(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
