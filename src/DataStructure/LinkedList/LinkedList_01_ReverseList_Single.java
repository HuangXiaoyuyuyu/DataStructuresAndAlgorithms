package DataStructure.LinkedList;

/**
 * @Author OliverYu
 * @Date 2019/3/5 13:51
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class LinkedList_01_ReverseList_Single {

    /**
     * 实现反转单向链表的函数。
     * 要求：如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
     */
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.println("LinkedList: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reverseList(head);
        printLinkedList(head);
    }

}
