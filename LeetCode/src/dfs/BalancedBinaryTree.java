package dfs;

import util.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
	//O(n)
    public int checkBalance(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = checkBalance(root.left);
        int right = checkBalance(root.right);
        if (left == -1|| right == -1|| Math.abs(left - right) > 1){
            return -1;
        }//如果left或者right不平衡就往上返回-1；
        return Math.max(left, right) + 1;
    }

}
