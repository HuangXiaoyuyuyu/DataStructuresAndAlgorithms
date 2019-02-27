package DataStructure.Stack;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/2/27 22:49
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Stack_01_Array_To_Stack {

    /**
     * 用数组结构实现大小固定的栈
     */
    public static class ArrayStack {
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The initSize is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index-1];
        }

        public void push(int obj) {
            if (index == arr.length) {
                throw new IndexOutOfBoundsException("The Stack is full");
            }
            arr[index++] = obj;
        }

        public Integer pop() {
            if (index == 0) {
                throw new IndexOutOfBoundsException("The Stack is Empty");
            }
            return arr[--index];
        }
    }
}
