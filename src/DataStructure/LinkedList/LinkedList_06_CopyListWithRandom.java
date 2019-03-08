package DataStructure.LinkedList;

import java.util.HashMap;

/**
 * @Author OliverYu
 * @Date 2019/3/8 14:34
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class LinkedList_06_CopyListWithRandom {

    /**
     * 复制含有随机指针节点的链表
     *
     * 一种特殊的链表节点类描述如下：
     * public class Node {
     *      public int value;
     *      public Node next;
     *      public Node rand;
     *
     *      public Node(int data) {
     *          this.value = data;
     *      }
     * }
     *
     * Node类中的value是节点值，
     *          next指针和正常单链表中next指针的意义一样，都指向下一个节点，
     *          rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。
     * 给定一个由Node节点类型组成的无环单链表的头节点head，
     * 请实现一个函数完成这个链表中所有结构的复制,并返回复制的新链表的头节点。
     *
     * 进阶：
     *  不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N),
     *  额外空间复杂度为O(1)内完成原问题要实现的函数。
     */
    public static class Node {
        public int data;
        public Node next;
        public Node random;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur,new Node(cur.data));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        cur = head;
        Node res = head.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        System.out.print("Order: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.print("Random: ");
        cur = head;
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }
}
