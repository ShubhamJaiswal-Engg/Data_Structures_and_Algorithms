
// 146. LRU Cache

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int k, int v) {
            key = k;
            val = v;
            next = null;
            prev = null;
        }
    }

    int limit;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
    }

    public void deleteNode(Node existNode) {
        Node prevNode = existNode.prev;
        Node nextNode = existNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node getNode = map.get(key);
        int result = getNode.val;

        deleteNode(getNode);
        addNode(getNode);
        return result;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existNode = map.get(key);
            existNode.val = value;      
            deleteNode(existNode);
            addNode(existNode);
        } else {
            if (map.size() == limit) {  
                Node lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }
}