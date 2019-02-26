package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/26 10:23
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_06_HeapSort {

    /**
     *  时间复杂度O(N*logN)，额外空间复杂度O(1)
     *
     *  堆(完全二叉树、数组)
     *  堆排序
     *      若当前结点下标i：
     *          左孩子下标(2i+1)，右孩子下标(2i+2)
     *          父结点下标(i-1)/2
     *
     *  步骤：
     *      1）建立大根堆
     *      2) 将堆顶与最后一个数交换，然后heapify
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 建立大根堆
        // 复杂度：log1 + log2 + ... + log(N-1) => N
        for (int i=0; i<arr.length; i++) {
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }

    /**
     * heapInsert：
     *      heapInsert就是每次向堆中插入一个新元素时，
     *      将该元素和自己的父节点进行比较，
     *      如果大则交换，再将父节点作为子节点继续比较
     *      反之则结束比较。
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index) {
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     *  heapSize:
     *      heapSize：表示当前堆的大小，是可伸缩的
     *      堆插入一个元素 heapSize+1 即可
     *      堆弹出一个元素 heapSize-1 即可
     *  heapify:
     *      heapify就是在heapSize范围内，
     *      当堆顶的数字发生变化时，将堆顶的数和左右孩子中较大的一个数进行交换，
     *      知道孩子的下标越界。
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr,int index,int heapSize) {
        int left = index*2 + 1;
        while (left < heapSize) {
            int largest = (left+1 < heapSize) && (arr[left] < arr[left+1])
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = 2*index + 1;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
