package DataStructure.Stack;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/2/28 10:51
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Stack_02_GetMinStack {
    /**
     * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
     *
     * 要求：
     *   1．pop、push、getMin操作的时间复杂度都是O(1)。
     *   2．设计的栈类型可以使用现成的栈结构。
     */

    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int obj) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(obj);
            } else if (obj < this.getMin()) {
                this.stackMin.push(obj);
            } else {
                int min = this.stackMin.peek();
                this.stackMin.push(min);
            }

            this.stackData.push(obj);
        }

        public Integer pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(5);
        System.out.println(myStack.getMin());   //5
        myStack.push(8);
        System.out.println(myStack.getMin());   //5
        myStack.push(2);
        System.out.println(myStack.getMin());   //2

        System.out.println(myStack.pop());      //2
        System.out.println(myStack.getMin());   //5
    }
}
