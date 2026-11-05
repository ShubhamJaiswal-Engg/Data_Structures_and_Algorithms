
// 102. Binary Tree Level Order Traversal

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    temp.add(curr.val);
                    if(curr.left != null) q.offer(curr.left);
                    if(curr.right != null) q.offer(curr.right);
                }
                ans.add(temp);
            }
        return ans;
    }
}