package DataStructure.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author OliverYu
 * @Date 2019/2/28 11:45
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Stack_03_QueueConvertToStack {

    /**
     * 仅用队列结构实现栈结构
     */
    public static class TwoQueueConvertToStack {
        private Queue<Integer> queueData;
        private Queue<Integer> queueHelp;

        public TwoQueueConvertToStack() {
            queueData = new LinkedList<>();
            queueHelp = new LinkedList<>();
        }

        public void push(int obj) {
            queueData.add(obj);
        }

        public Integer pop() {
           if (queueData.isEmpty()) {
               throw new RuntimeException("The stack is empty~");
           }
           while (queueData.size() > 1) {
               queueHelp.add(queueData.poll());
           }
            int res = queueData.poll();
            swap();
            return res;
        }

        public Integer peek() {
            if (queueData.isEmpty()) {
                throw new RuntimeException("The stack is empty~");
            }
            while (queueData.size() > 1) {
                queueHelp.add(queueData.poll());
            }
            int res = queueData.poll();
            queueHelp.add(res);
            swap();
            return res;
        }

        public void swap() {
            Queue<Integer> temp = queueData;
            queueData = queueHelp;
            queueHelp = temp;
        }
    }
}
