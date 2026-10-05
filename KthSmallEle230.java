
// 230. Kth Smallest Element in a BST

class KthSmallEle230 {
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inOrder(root, list);
        return list.get(k - 1);
    }
}