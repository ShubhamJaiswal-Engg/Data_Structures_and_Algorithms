
// 863. All Nodes Distance K in Binary Tree

class AllNodeDistanceK863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        // Null Because root node does not have parent.
        parentData(root, null, parent);

        Queue<TreeNode> que = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        que.offer(target);
        visited.add(target);

        // Calculate Distance
        int dist = 0;

        List<Integer> answer = new ArrayList<>();

        // Bread First Search
        while(!que.isEmpty()) {
            if(dist == k) {
                for(TreeNode node : que) {
                    answer.add(node.val);
                }
                return answer;
            }

            int n = que.size();
            for(int i = 0; i < n; i++){
            TreeNode node = que.poll();

            TreeNode neighbours[] = {node.left, node.right, parent.get(node)};
            for(TreeNode neighbour : neighbours) {
                if(neighbour != null && !visited.contains(neighbour))  {
                    que.offer(neighbour);
                    visited.add(neighbour);
                }
            }
            }
            dist++;
        }

        return answer;
    }

    private void parentData(TreeNode root, TreeNode par, HashMap<TreeNode, TreeNode> parent) {
        if(root == null) return;

        parent.put(root, par);
        parentData(root.left, root, parent);
        parentData(root.right, root, parent);
    }
}