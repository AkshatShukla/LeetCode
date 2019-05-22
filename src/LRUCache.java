import java.util.*;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    private Node head, tail;
    private final Map<Integer, Node> cache;
    private final int maxCapacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        // Initialize the dummy head of the cache
        head = new Node();
        head.prev = null;

        // Init the dummy tail of the cache
        tail = new Node();
        tail.next = null;

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;

        maxCapacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // Accessed, so we move it to the front of the list, as older elements are at the tail of the list
            moveToHead(node);
            return node.value;
        }
    }

    /*
      Insertions to the doubly linked list will always
      be right after the dummy head
    */
    private void addNode(Node node) {
        // Wire the node being inserted
        node.prev = head;
        node.next = head.next;

        // Wire the head as well
        head.next.prev = node;
        head.next = node;
    }

    /*
      Remove the given node from the doubly linked list
    */
    private void removeNode(Node node) {
        // Grab reference to the prev and next of the node
        Node savedPrev = node.prev;
        Node savedNext = node.next;

        // Cut out going forwards
        savedPrev.next = savedNext;

        // Cut out going backwards
        savedNext.prev = savedPrev;
    }

    /*
      Move a node to the head of the doubly linked list
    */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    /*
      Pop the last item from the structure
    */
    private Node popTail() {
        Node itemBeingRemoved = tail.prev;
        removeNode(itemBeingRemoved);
        return itemBeingRemoved;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            if (cache.size() > maxCapacity) {
                Node removedKey = popTail();
                cache.remove(removedKey.key);
            }
        } else {
            node.value = value;
            cache.put(key, node);
            // Anytime we interact, we move the updated node to front of list
            moveToHead(node);
        }
        System.out.println(cache);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
    }
}
