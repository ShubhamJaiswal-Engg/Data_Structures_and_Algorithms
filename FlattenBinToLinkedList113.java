
// 114. Flatten Binary Tree to Linked List

// Approach First

// Space Complexity - O(n)

class FlattenBinToLinkedList113 {
    public TreeNode preOrder(TreeNode temp, TreeNode root) {
        if(root == null) {
            return temp;
        };

        TreeNode left = root.left;
        TreeNode right = root.right;

        temp.left = null;
        temp.right = root;
        temp = root;

        temp = preOrder(temp, left);
        temp = preOrder(temp , right);

        return temp;
    }


    public void flatten(TreeNode root) {

        preOrder(new TreeNode(0), root);
    }
}

// Approach Second

// Space Complexity - O(1)

class FlattenBinToLinkedList113 {
    public void flatten(TreeNode root) {
        while (root != null) {

            // Morris-traversal-style flatten

            if (root.left != null) {
                TreeNode curr = root.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right; 
        }
    }
}