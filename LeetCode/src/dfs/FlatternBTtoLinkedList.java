package dfs;

import util.TreeNode;

public class FlatternBTtoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten1(TreeNode root) {
		preOrder(root, null);
	}

	public TreeNode preOrder(TreeNode root, TreeNode lastVisited) {
		if (root == null)
			return lastVisited;
		TreeNode saveRight = root.right;
		if (lastVisited != null) {
			lastVisited.right = root;
			lastVisited.left = null;
		}
		lastVisited = root;
		lastVisited = preOrder(root.left, lastVisited);
		lastVisited = preOrder(saveRight, lastVisited);
		return lastVisited;
	}
//non-recursive
	//find right most in the left subtree and store it!!
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode p = root.left;
				while (p.right != null) {
					p = p.right;
				}
				p.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}
