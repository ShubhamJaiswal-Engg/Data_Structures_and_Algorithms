
// 129. Sum Root to Leaf Numbers

class SumRoLeNum129 {
    int ans = 0;

    private int preOrder(TreeNode root, int currentSum) {
        
        currentSum = currentSum * 10 + root.val;
        if(root.left == null || root.right == null) {
            return currentSum;
        }

        int left = preOrder(root.left, currentSum);
        int right = preOrder(root.right, currentSum);
        return left + right;
    }




    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }
}