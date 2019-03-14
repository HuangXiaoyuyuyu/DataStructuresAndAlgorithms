package DataStructure.Tree;

/**
 * @Author OliverYu
 * @Date 2019/3/14 9:58
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_06_IsBalancedTree {

    /**
     * 判断一棵二叉树是否是平衡二叉树
     */
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head,1,res);
        return res[0];
    }

    public static int getHeight(Node head,int level,boolean[] res) {
        if (head == null) {
            return level;
        }
        int LH = getHeight(head.left,level+1,res);
        if (!res[0]) {
            return level;
        }
        int RH = getHeight(head.right,level+1,res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(LH - RH) > 1) {
            res[0] = false;
        }
        return Math.max(LH,RH) + 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        head.right.right.right = new Node(9);
        head.right.right.right.left = new Node(10);

        System.out.println(isBalance(head));
    }
}
