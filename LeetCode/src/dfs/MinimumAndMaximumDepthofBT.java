package dfs;

import util.TreeNode;

public class MinimumAndMaximumDepthofBT {
	public int minDepth(TreeNode root){
		if (root == null) return 0;
	    if (root.left == null && root.right != null) {
	        return minDepth(root.right) + 1;
	    }
	    if (root.left != null && root.right == null) {
	        return minDepth(root.left) + 1;
	    }
	    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
	
	public int maxDepth(TreeNode root){
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}

}
