package DataStructure.Queue;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/2/28 15:34
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Queue_02_StackConvertToQueue {

    /**
     * 仅用栈结构实现队列结构
     *
     * 注意：
     *  当stackPush中的数字往stackPop压栈时 一次性全部压入
     *  如果stackPop不为空，stackPush一定不要往stackPop压栈
     */

    public static class TwoStackConvertToQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackConvertToQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void add(int obj) {
            stackPush.push(obj);
        }

        public Integer poll() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("The queue is empty~");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public Integer peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("The queue is empty~");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
