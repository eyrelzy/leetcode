package dfs;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum btm = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-1); 
		root.left =new TreeNode(5);
		root.left.left =new  TreeNode(4);
		root.left.left.right = new TreeNode(2);
		root.left.left.right.left = new TreeNode(-4);
		int ret = btm.maxPathSum(root);
		System.out.println(ret);
	}
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)    
            return 0;
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        // if(root == null)    {
        //     return 0;
        // }
        if(root.left==null && root.right==null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        int left = 0, right = 0, tmp = 0;
        if(root.left != null && root.right == null){
            left = helper(root.left);
            tmp = left;
        }else if(root.right !=null && root.left == null){
            right = helper(root.right);
            tmp = right;
        }else{
            left = helper(root.left);
            right = helper(root.right);
            tmp = Math.max(left, right);
        }
        max = Math.max(Math.max(Math.max(Math.max(max, tmp), tmp + root.val), root.val+left+right), root.val); 
        return Math.max(root.val, tmp + root.val);
    }
}
