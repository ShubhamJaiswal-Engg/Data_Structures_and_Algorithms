
// 226. Invert Binary Tree

class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
}


// Different approach


class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        };
        TreeNode temp;

        // Swapping left and right child
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        // inverting left and right child
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}