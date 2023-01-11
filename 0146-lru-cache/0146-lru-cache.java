class LRUCache {
    // notes
    Map<Integer, Node> map = new HashMap<>();

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap = 0;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // System.out.println("get: " + key);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insertNode(node);
            // printLL();
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // System.out.println("put: key: " + key + " val: " + value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }

        if (map.size() == cap) {
            // removeLastNode;
            removeNode(tail.prev);
        }

        Node node = new Node(key, value);
        insertNode(node);
        // printLL();
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // node.prev = null;
        // node.next = null;

        map.remove(node.key);
    }

    void insertNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

        map.put(node.key, node);

        // Node headNext = head.next;
        // head.next = node;
        // node.prev = head;
        // headNext.prev = node;
        // node.next = headNext;
    }

    void printLL() {
        Node curr = head;
        while (curr != null) {
            System.out.println("key: " + curr.key + ", " + "val: " + curr.val);
            curr = curr.next;
        }
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
