package DataStructure.Queue;

/**
 * @Author OliverYu
 * @Date 2019/2/28 9:58
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Queue_01_Array_To_Queue {

    /**
     *
     *  用数组结构实现大小固定的队列
     *
     */
   public static class ArrayQueue {
       private Integer[] arr;
       private Integer start;
       private Integer end;
       private Integer size;

       public ArrayQueue(int initSize) {
           if (initSize < 0) {
               throw new IllegalArgumentException("The initSize is less than 0");
           }
           arr = new Integer[initSize];
           start = 0;
           end = 0;
           size = 0;
       }

       public void add(int obj) {
           if (size == arr.length) {
               throw new IndexOutOfBoundsException("The queue is full");
           }
           size++;
           arr[end] = obj;
           end = end == arr.length - 1 ? 0 : end + 1;
       }

       public Integer poll() {
           if (size == 0) {
               throw new IndexOutOfBoundsException("The queue is empty");
           }
           size--;
           int temp = arr[start];
           start = start == arr.length - 1 ? 0 : start + 1;
           return temp;
       }

       public Integer peek() {
           if (size == 0) {
               return null;
           }
           return arr[start];
       }
    }
}
