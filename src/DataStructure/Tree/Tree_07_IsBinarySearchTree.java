package DataStructure.Tree;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/3/15 10:44
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_07_IsBinarySearchTree {

    /**
     * 判断一棵树是否是搜索二叉树
     */

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        int preData = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.data + " ");
                if (preData > head.data) {
                    return false;
                }else {
                    preData = head.data;
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        //head.left.right.left = new Node(4);

        System.out.println(isBST(head));
    }
}
