package bt;

import java.util.LinkedList;

import util.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		// root.left.left = new TreeNode(11);
		// root.left.left.left = new TreeNode(7);
		// root.left.left.right = new TreeNode(2);
		// root.right = new TreeNode(8);
		// root.right.left = new TreeNode(13);
		// root.right.right = new TreeNode(4);
		// root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum1(root, 8));
	}

	// failure trial
	public static boolean hasPathSum(TreeNode root, int sum) {
		boolean ret = false;
		// System.out.println(root.val+"");
		if (root == null) {
			System.out.println("sum:" + sum);
			if (sum == 0)
				return true;
			else
				return false;
		}
		// if(root.left == null && root.right==null && root.val==sum)
		// return true;

		if (root.left != null)
			ret = hasPathSum(root.left, sum - root.val);
		if (root.right != null)
			ret = hasPathSum(root.right, sum - root.val);
		return ret;
	}

	// recursive method
	public static boolean hasPathSum1(TreeNode root, int sum) {
		if (root == null) {
			System.out.println("sum?" + sum);
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			System.out.println(sum);
			return true;
		}
		return hasPathSum1(root.left, sum - root.val)
				|| hasPathSum1(root.right, sum - root.val);
	}

	// unrecursive method!!!!

	public boolean hasPathSum3(TreeNode root, int sum) {
		if (root == null)
			return false;

		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();

		nodes.add(root);
		values.add(root.val);

		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			int sumValue = values.poll();

			if (curr.left == null && curr.right == null && sumValue == sum) {
				return true;
			}

			if (curr.left != null) {
				nodes.add(curr.left);
				values.add(sumValue + curr.left.val);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				values.add(sumValue + curr.right.val);
			}
		}

		return false;
	}
}
