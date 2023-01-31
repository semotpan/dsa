package leetcode._460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private final Map<Integer, Record> storage;
    private final Map<Integer, LinkedHashSet<Integer>> freqBuckets;
    private final int capacity;
    private int minBucket;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>(capacity, 1.0F);
        this.freqBuckets = new HashMap<>(capacity, 1.0F);
        this.minBucket = 1;
    }

    // O(1) get
    public int get(int key) {
        var record = storage.get(key);
        if (record == null)
            return -1;

        refresh(key, record.freq());
        add(key, record.value(), record.freq() + 1);

        return record.value();
    }

    // O(1) put
    public void put(int key, int value) {
        if (capacity == 0) return;

        var oldValue = storage.get(key);

        if (oldValue != null) {
            refresh(key, oldValue.freq());
            add(key, value, oldValue.freq() + 1);
            return;
        }

        ensureCapacity();
        minBucket = 1;

        add(key, value, 1);
    }

    private void refresh(int key, int freq) {
        freqBuckets.get(freq).remove(key);

        if (freq == minBucket && freqBuckets.get(freq).isEmpty())
            ++minBucket;
    }

    private void ensureCapacity() {
        if (capacity > storage.size())
            return;

        var lru = freqBuckets.get(minBucket);
        var itemToRemove = lru.iterator().next();

        storage.remove(itemToRemove);
        lru.remove(itemToRemove);
    }

    private void add(int key, int value, int freq) {
        storage.put(key, new Record(freq, value));
        freqBuckets.putIfAbsent(freq, new LinkedHashSet<>());
        freqBuckets.get(freq).add(key);
    }

    record Record(int freq, int value) {
    }
}

class LFUCacheCustom {

    private final Node[] storage;
    private final LRU[] freqBuckets;
    private final int capacity;
    private int minBucket, size;

    LFUCacheCustom(int capacity) {
        this.capacity = capacity;
        this.storage = new Node[100_001];
        this.freqBuckets = new LRU[100_001];
        this.minBucket = 1;
    }

    public int get(int key) {
        var node = storage[key];

        if (null == node) return -1;

        refreshBuckets(node);

        return node.value;
    }

    // update frequency
    private void refreshBuckets(Node node) {
        var lru = freqBuckets[node.freq];
        lru.remove(node);

        // increment min bucket if last value removed
        if (minBucket == node.freq && lru.isEmpty())
            ++minBucket;

        node.incFreq();
        // init next LRU bucket if null
        initBucketIfNull(node.freq);

        freqBuckets[node.freq].addFirst(node); // add node to new bucket
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        var node = storage[key];

        if (node != null) {
            refreshBuckets(node);
            node.value = value;
            return;
        }

        ensureCapacity();
        minBucket = 1;
        // init LRU bucket if null
        initBucketIfNull(minBucket);

        node = new Node(key, value);
        freqBuckets[minBucket].addFirst(node);
        storage[key] = node;
        ++size;
    }

    private void initBucketIfNull(int minBucket) {
        if (freqBuckets[minBucket] == null)
            freqBuckets[minBucket] = new LRU();
    }

    private void ensureCapacity() {
        if (size < capacity)
            return;

        --size;

        var lru = freqBuckets[minBucket];
        var node = lru.removeLast();
        storage[node.key] = null;
    }

    private static final class LRU {
        private final Node head, tail;

        LRU() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        Node remove(Node node) {
            if (node == head || node == tail) {
                return null;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;

            return node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        // add on top (LRU)
        void addFirst(Node node) {
            var next = head.next;
            if (next != null) {
                node.next = next;
                node.next.prev = node;
            }

            head.next = node;
            node.prev = head;
        }

        // remove last element
        Node removeLast() {
            return remove(tail.prev);
        }
    }

    private static final class Node {
        private final int key;
        private int value, freq;
        private Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        void incFreq() {
            ++freq;
        }
    }
}
