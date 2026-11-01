
// 144. Binary Tree Preorder Traversal

class PreOrderTraversal144 {
    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        preOrder(root, list);
        return list;
    }
}