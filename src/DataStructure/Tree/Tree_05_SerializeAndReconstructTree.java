package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author OliverYu
 * @Date 2019/3/13 10:14
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_05_SerializeAndReconstructTree {

    /**
     * 二叉树的序列化和反序列化(以先序为例)
     */
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.data + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i=0; i!=values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    public static void preOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        preOrderPrint(head.left);
        preOrderPrint(head.right);
    }

    public static void main(String[] args) {
        Node head = null;

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order: ");
        preOrderPrint(head);

        System.out.println();
        System.out.println("====================================");

        head = new Node(1);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order: ");
        preOrderPrint(head);

        System.out.println();
        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order: ");
        preOrderPrint(head);

        System.out.println();
        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order: ");
        preOrderPrint(head);
    }
}
