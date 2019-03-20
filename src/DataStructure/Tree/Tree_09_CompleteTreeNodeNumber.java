package DataStructure.Tree;

/**
 * @Author OliverYu
 * @Date 2019/3/20 11:06
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_09_CompleteTreeNodeNumber {

    /**
     * 已知一棵完全二叉树，求其节点的个数
     * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
     */

    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }

    public static int bs(Node head, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(head.right,level + 1) == h) {
            return (1<<(h-level)) + bs(head.right,level+1,h);
        }else {
            return (1<<(h-level-1)) + bs(head.left,level+1,h);
        }
    }

    public static int mostLeftLevel(Node head, int level) {
        if (head == null) {
            return 0;
        }
        while (head.left != null) {
            level++;
            head = head.left;
        }
        return level;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.left.right.left = new Node(10);
        head.left.right.right = new Node(11);
        //head.right.left.left = new Node(12);
        //head.right.left.right = new Node(13);
        //head.right.right.left = new Node(14);
        //head.right.right.right = new Node(15);
        System.out.println(nodeNum(head));
    }
}
