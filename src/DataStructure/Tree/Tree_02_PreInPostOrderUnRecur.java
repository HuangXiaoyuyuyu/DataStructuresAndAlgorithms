package DataStructure.Tree;

import java.util.Stack;

/**
 * @Author OliverYu
 * @Date 2019/3/10 22:27
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_02_PreInPostOrderUnRecur {

    /**
     * 非递归方式实现二叉树的先序、中序、后序遍历
     */
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preOrderUnRecur(Node head) {
        System.out.print("Pre-Order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.empty()) {
                head = stack.pop();
                System.out.print(head.data + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("In-Order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.empty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.data + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void postOrderUnRecur(Node head) {
        System.out.print("Pos-Order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.empty()) {
                System.out.print(stack2.pop().data + " ");
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);


        System.out.println("============unRecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        postOrderUnRecur(head);
    }
}
