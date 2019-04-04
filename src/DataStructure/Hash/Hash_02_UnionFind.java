package DataStructure.Hash;

import java.util.HashMap;
import java.util.List;

/**
 * @Author OliverYu
 * @Date 2019/4/4 17:50
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Hash_02_UnionFind {

    /**
     * 并查集结构
     */
    public static class Node {
        //Whatever you like
    }

    public static class UnionFindSet {
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node head) {
            Node father = fatherMap.get(head);
            if (father != head) {
                father = findHead(father);
            }
            fatherMap.put(head,father);
            return father;
        }

        public boolean isSameSet(Node head1,Node head2) {
            return findHead(head1) == findHead(head2);
        }

        public void union(Node head1,Node head2) {
            if (head1 == null || head2 == null) {
                return;
            }
            Node aHead = findHead(head1);
            Node bHead = findHead(head2);
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if (aSize <= bSize) {
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSize + bSize);
                }else {
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSize + bSize);
                }
            }
        }
    }
}
