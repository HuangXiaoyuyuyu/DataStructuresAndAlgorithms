package DataStructure.Hash;

import java.util.HashMap;

/**
 * @Author OliverYu
 * @Date 2019/4/2 22:14
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Hash_01_RandomPool {

    /**
     * 设计RandomPool结构
     * 设计一种结构，在该结构中有如下三个功能：
     * insert(key)：将某个key加入到该结构，做到不重复加入。
     * delete(key)：将原本在结构中的某个key移除。
     * getRandom()：等概率随机返回结构中的任何一个key。
     * 要求：Insert、delete和getRandom方法的时间复杂度都是O(1)
     * @param <T>
     */
    public static class Pool<T> {
        private HashMap<T,Integer> keyIndexMap;
        private HashMap<Integer,T> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(T key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key,size);
                indexKeyMap.put(size,key);
                size++;
            }
        }

        public void delete(T key) {
            if (keyIndexMap.containsKey(key)) {
                int delIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                T lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey,delIndex);
                indexKeyMap.put(delIndex,lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public T getRandom() {
            if (size == 0) {
                return null;
            }
            return indexKeyMap.get((int)(Math.random()*size));
        }
    }
}
