
// 2265. Count Nodes Equal to Average of Subtree

class CountNodes2265 {

        int result=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);

        return result;
    }

    private int[] solve(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int sum=0;
        int count =0;
        int[] left = solve(root.left);
        int[] right =solve(root.right);

        sum+=left[0]+right[0]+root.val;

        count+=left[1]+right[1]+1;
        
        if(sum/count==root.val){
            result++;
        }
        return new int[]{sum,count};
    }
}

// Second Approach

class CountNodes2265 {
    int result;
    class Pair {
        int sum = 0;
        int count = 0;
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public Pair sumOfNode(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        
        Pair p1 = sumOfNode(root.left);
        Pair p2 = sumOfNode(root.right);

        int totSum = p1.sum + p2.sum + root.val;
        int totCount = p1.count + p2.count + 1;

        if((totSum / totCount) == root.val) {
            result += 1;
        }
        return new Pair(totSum,totCount); 
    }

    public int averageOfSubtree(TreeNode root) {
              result = 0;
              sumOfNode(root);

               return result;
    }
}