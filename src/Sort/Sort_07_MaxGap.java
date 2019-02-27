package Sort;

/**
 * @Author OliverYu
 * @Date 2019/2/27 9:55
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Sort_07_MaxGap {

    /**
     * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
     * 间复杂度O(N)，且要求不能用非基于比较的排序。
     *
     * 思路
     *  例子：数组9个数，最大值99，最小值0
     *  步骤：
     *  1）求出数组最大值，最小值
     *  2）利用10(比数组长度多1)个空桶，按比例切分：
     *       数组0-9 范围的数存放在0号桶
     *         10-19 范围的数存放在1号桶
     *         ...
     *         90-99 范围的数存放在9号桶
     *  3）在1号至8号桶之间必定至少存在一个空桶，利用此结论，可以排除相邻两个数出现在同一个桶中的情况
     *  4）遍历桶，以后一个桶的最小值减去前一个非空桶的最大值，可以得到一个最大的差值
     *
     * @param arr
     * @return
     */
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 遍历数组，求出数组的最大值、最小值
        for (int i=0; i<arr.length; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        if (min == max) {
            return 0;
        }

        // n个数，n+1个桶
        // hasNum数组判断桶是否有值
        boolean[] hasNum = new boolean[arr.length + 1];

        // maxs数组存放每个桶的最小值
        int[] mins = new int[arr.length + 1];

        // mins数组存放每个桶的最大值
        int[] maxs = new int[arr.length + 1];

        int bid = 0;
        for (int i=0; i<arr.length; i++) {
            // 求出当前数arr[i]所对应的桶号
            bid = bucket(arr[i],arr.length,min,max);

            // 如果arr[i]是bid号同的最小值，将arr[i]存入mins[bid]中
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],arr[i]) : arr[i];

            // 如果arr[i]是bid号同的最大值，将arr[i]存入maxs[bid]中
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        // 由鸽笼原理可知，N个数放入N+1个桶里，一定存在至少一个空桶，
        // 由此，可以判定最大差值的相邻两个数一定不是在同一个桶中
        int res_max = 0;
        int max_last = maxs[0];
        for (int i=0; i<arr.length; i++) {
            if (hasNum[i]) {
                res_max = Math.max(res_max,mins[i] - max_last);
                max_last = maxs[i];
            }
        }
        return res_max;
    }

    /**
     *
     * @param num 数组中某个元素
     * @param len 数组中元素个数
     * @param min 数组元素的最小值
     * @param max 数组元素的最大值
     * @return 返回元素对应的桶号
     */
    public static int bucket(long num,long len,long min,long max) {
        return (int)((num-min)*len/(max-min));
    }

}
