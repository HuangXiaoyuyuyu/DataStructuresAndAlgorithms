package DataStructure.Tree;

/**
 * @Author OliverYu
 * @Date 2019/3/12 10:01
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Tree_04_SuccessorNode {

    /**
     * 在二叉树中找到一个节点的前驱节点和后继节点
     *
     * 现在有一种新的二叉树节点类型如下：
     * public class Node {
     *  public int value;
     *  public Node left;
     *  public Node right;
     *  public Node parent;
     *  public Node(int data) {
     *      this.value = data;
     *  }
     * }
     * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
     * 假设有一棵Node类型的节点组成的二叉树，
     * 树中每个节点的parent指针都正确地指向自己的父节点，头节点的parent指向null。
     * 只给一个在二叉树中的某个节点 node，请分别实现返回node的前驱节点和后继节点的函数。
     * 在二叉树的中序遍历的序列中，node的上一个节点叫做node的前驱节点，node的下一个节点叫作node的后继节点。
     */
    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    //获取head节点的前驱节点
    public static Node getPrecursorNode(Node head) {
        if (head == null) {
            return head;
        }
        if (head.left != null) {
            return getRightMost(head.left);
        }else {
            Node parent = head.parent;
            while (parent != null && parent.right != head) {
                head = parent;
                parent = head.parent;
            }
            return parent;
        }
    }

    //获取head节点的后继节点
    public static Node getSuccessorNode(Node head) {
        if (head == null) {
            return head;
        }
        if (head.right != null) {
            return getLeftMost(head.right);
        }else {
            Node parent = head.parent;
            while (parent != null && parent.left != head) {
                head = parent;
                parent = head.parent;
            }
            return parent;
        }
    }

    //获取后继节点时，如果有右子树，则获取右子树最左边的节点。
    public static Node getLeftMost(Node head) {
        if (head == null) {
            return head;
        }
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    //获取前驱节点时，如果有左子树，则获取左子树最右边的节点。
    public static Node getRightMost(Node head) {
        if (head == null) {
            return head;
        }
        while (head.right != null) {
            head = head.right;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;// 1's pre is null
        System.out.println(test.data + " pre:  " + getPrecursorNode(test));
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.left.left.right;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.left;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.left.right;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.left.right.right;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.right.left.left;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.right.left;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.right;
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test).data);
        test = head.right.right; // 10's next is null
        System.out.println(test.data + " pre:  " + getPrecursorNode(test).data);
        System.out.println(test.data + " next: " + getSuccessorNode(test));
    }
}
