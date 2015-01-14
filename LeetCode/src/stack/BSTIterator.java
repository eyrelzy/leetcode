package stack;

import java.util.Stack;

import util.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BSTIterator {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(4);
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			 System.out.println(i.next());
		}

	}

	TreeNode node = null;
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		node = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !((node == null) && stack.empty());
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode res = null;
		if (node == null) {
			res = stack.pop();
			node = res.right;
		} else {
			while (node.left != null) {
				stack.push(node);
				node = node.left;
			}
			res = node;
			node = node.right;
		}
		return res.val;
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root);e while (i.hasNext()) v[f()] = i.next();
 */
