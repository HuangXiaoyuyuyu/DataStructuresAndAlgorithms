package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/25 10:24
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_05_QuickSort_Optimization {

    /**
     * 利用荷兰国旗问题对经典的快排进行优化
     *
     *荷兰国旗问题
     *  对于arr[l, r]，小于num的数放左边，大于num的数放右边，等于num的数字放中间
     *
     *  思路
     *    初始化：less指向l前一个位置，more指向r后一个位置
     *    遍历arr：
     *    1）arr[l] < num：arr[l]与less下一个位置的值交换，向右扩大less区域，l++
     *    2）arr[l] > num：arr[l]与more前一个位置的值交换，向左扩大more区域，此时l不变，需要对交换过来的数进行再次比较
     *    3）arr[l] == num：l++
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int L,int R) {
        if (L < R) {
            //数组基本有序时，快速排序时间复杂度达O(N²)
            //如果将第一个数作为荷兰国旗问题的num时
            //可利用随机快排，随机一个索引与数组最后一个数arr[L]交换，再拿它对数组划分
            //这样长期期望的时间复杂度是O(N*logN)
            swap(arr,L+(int)Math.random()*(R-L+1),L);
            /*
            //如果将最后一个数作为荷兰国旗问题的num时
            //可利用随机快排，随机一个索引与数组最后一个数arr[L]交换，再拿它对数组划分
            swap(arr,L+(int)Math.random()*(R-L+1),R);
            */
            int[] mid = partition(arr,L,R);
            quickSort(arr,L,mid[0]-1);
            quickSort(arr,mid[1]+1,R);
        }
    }

    //将数组最左边一个数作为荷兰国旗问题中的num
    public static int[] partition(int[] arr,int L,int R) {
        int less = L;
        int more = R + 1;
        while (less < R) {
            if (arr[L] < arr[R]) {
                swap(arr,--more,R--);
            }else if (arr[L] > arr[R]) {
                swap(arr,++less,R);
            }else {
                --R;
            }
        }
        swap(arr,L,less);
        return new int[]{less,more-1};
    }

    /*//将数组最右边一个数作为荷兰国旗问题中的num
    public static int[] partition(int[] arr,int L,int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr,++less,L++);
            }else if (arr[L] > arr[R]) {
                swap(arr,L,--more);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }*/

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
