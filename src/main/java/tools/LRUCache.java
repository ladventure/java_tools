package tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 使用 LinkedHashMap 实现一个LRU缓存
 */
public class LRUCache<K,V> {
    private int capacity;
    private LinkedHashMap<K,V> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<K,V>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }
   public void put(K key, V value) {

        cache.putLast(key, value);
        if (cache.size() > capacity) {
            K oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

    }
}

@Nested
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class TestLru{
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