package tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 实现一个LRU缓存
 */
public class LRUCacheByCustom {
    //    双向列表节点
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    public LRUCacheByCustom(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            //            移出 node
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //        node 插入到头部
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head.next;
                node.prev = head;
                head.next=node;
            }
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        Node node;
        if (cache.containsKey(key)) {
             node = cache.get(key);
            node.value = value;
//            移出 node
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            node = new Node(key, value);
            cache.put(key, node);
        }

    }
}

@Nested
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestCustomLru{
    LRUCache<Integer,String> lruCache;

    @BeforeEach
    void setUp() {
        // 初始化一个容量为3的LRU缓存，你可以根据需要调整容量
        lruCache = new LRUCache<Integer,String>(3);
    }

    // 测试put方法，插入新元素后能正确获取
    @Test
    void testPutAndGet() {
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        assertEquals("one", lruCache.get(1));
        assertEquals("two", lruCache.get(2));
        assertEquals("three", lruCache.get(3));
    }

    // 测试访问元素后，该元素变为最近使用的
    @Test
    void testGetUpdatesOrder() {
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        lruCache.get(1);
        lruCache.put(4, "four");

        assertEquals("one", lruCache.get(1));
        assertNull(lruCache.get(2));
    }

    // 测试缓存容量达到上限后，最早未使用的元素被淘汰
    @Test
    void testEvictionWhenFull() {
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        lruCache.put(4, "four");

        assertNull(lruCache.get(1));
    }

    // 测试更新已存在元素的值
    @Test
    void testUpdateExistingValue() {
        lruCache.put(1, "one");
        lruCache.put(2, "two");

        lruCache.put(1, "newOne");

        assertEquals("newOne", lruCache.get(1));
    }

    // 测试获取不存在的元素返回null
    @Test
    void testGetNonExistentElement() {
        lruCache.put(1, "one");
        lruCache.put(2, "two");

        assertNull(lruCache.get(3));
    }
}
