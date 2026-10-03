
// 133. Clone Graph

class CloneGraph133 {
    public Node cloneGraph(Node node) {
    if(node == null) return null;
    Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();

    Node clone = new Node(node.val);
    map.put(node.val, clone);

    queue.add(node);


    // while(!queue.isEmpty())

    while(queue.size() > 0) {
        Node oldNode = queue.poll();
        Node dummy = map.get(oldNode.val);

        List<Node> neigh = new ArrayList<>();
        for(Node n : oldNode.neighbors) {
            if(map.containsKey(n.val)) {
                neigh.add(map.get(n.val));
            } else {
                Node neig = new Node(n.val);
                map.put(n.val, neig);
                neigh.add(neig);
                queue.add(n);
            }
        }
        dummy.neighbors = neigh;
       }

       return clone;
    }
}