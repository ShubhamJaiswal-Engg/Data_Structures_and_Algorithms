// 105. Construct Binary Tree from Preorder and Inorder Traversal


class Solution {
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    private int preIdx = 0;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndex.get(rootVal);

        // Build left subtree BEFORE right — preorder order matters
        root.left = build(inLeft, mid - 1);
        root.right = build(mid + 1, inRight);

        return root;
    }
}