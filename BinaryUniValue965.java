// 965. Univalued Binary Tree

class BinaryUniValue965 {
    public boolean isUnivalTree(TreeNode root) {
        
        return uniValTree(root, root.val);
    }

    private boolean uniValTree(TreeNode root, int rootValue) {
        if (root == null){
         return true;
        }
        if (root.val != rootValue) {
            return false;
        }

        return uniValTree(root.left, rootValue) && uniValTree(root.right, rootValue);
    }
}