package DataStructure.LinkedList;

/**
 * @Author OliverYu
 * @Date 2019/3/6 11:44
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class LinkedList_03_PrintCommonPart {

    /**
     * 打印两个有序链表的公共部分
     *   给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
     */
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.print("Common Part: ");
        while (head1 !=null && head2 != null) {
            if (head1.data < head2.data) {
                head1 = head1.next;
            }else if (head1.data > head2.data) {
                head2 = head2.next;
            }else {
                System.out.print(head1.data + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void printLinkedList(Node head) {
        System.out.print("LinkedList: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(55);
        head1.next = new Node(71);
        head1.next.next = new Node(80);
        head1.next.next.next = new Node(88);

        Node head2 = new Node(55);
        head2.next = new Node(70);
        head2.next.next = new Node(76);
        head2.next.next.next = new Node(80);
        head2.next.next.next.next = new Node(88);

        printLinkedList(head1);
        printLinkedList(head2);
        printCommonPart(head1,head2);
    }
}
