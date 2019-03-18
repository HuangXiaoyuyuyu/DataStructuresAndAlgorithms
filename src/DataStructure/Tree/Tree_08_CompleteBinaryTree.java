package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author OliverYu
 * @Date 2019/3/18 10:01
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_08_CompleteBinaryTree {

    /**
     * 判断一棵树是否是完全二叉树
     */

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node L = null;
        Node R = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            L = head.left;
            R = head.right;
            if ((leaf && (L != null || R != null)) || (L == null && R != null)) {
                return false;
            }
            if (L != null) {
                queue.offer(L);
            }
            if (R != null) {
                queue.offer(R);
            }else {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isCBT(head));
    }

}
