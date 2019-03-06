package DataStructure.LinkedList;

/**
 * @Author OliverYu
 * @Date 2019/3/6 10:00
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class LinkedList_02_ReverseList_Doubly {

    /**
     * 实现反转双向链表的函数。
     * 要求：如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
     */

    public static class DoubleNode {
        public int data;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.data = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.println("DoubleNode head: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.data + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.data + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.last = head;
        head.next.next = new DoubleNode(3);
        head.next.next.last = head.next;
        head.next.next.next = new DoubleNode(4);
        head.next.next.next.last = head.next.next;
        printDoubleLinkedList(head);
        printDoubleLinkedList(reverseList(head));
    }

}
