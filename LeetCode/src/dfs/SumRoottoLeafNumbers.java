package dfs;

import util.TreeNode;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
		SumRoottoLeafNumbers srt = new SumRoottoLeafNumbers();
		System.out.println(srt.sumNumbers(root));
	}

	private int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		StringBuffer sb = new StringBuffer();
		dfs(root, sb);
		return sum;
	}

	public void dfs(TreeNode root, StringBuffer sb) {

		sb.append(root.val);
		if (root.left != null) {
			dfs(root.left, sb);
			sb.deleteCharAt(sb.length() - 1);//
		}
		if (root.right != null) {
			dfs(root.right, sb);
			sb.deleteCharAt(sb.length() - 1);//
		}
		if (root.right == null && root.left == null) {
			int sub = Integer.parseInt(sb.toString());
			sum += sub;
			return;
		}
	}

}
