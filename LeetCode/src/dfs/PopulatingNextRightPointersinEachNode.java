package dfs;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		new PopulatingNextRightPointersinEachNode().connect(root);
		new PopulatingNextRightPointersinEachNode().levelOrder(root);
	}

	public void levelOrder(TreeLinkNode root) {
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeLinkNode tmp = q.poll();
			System.out.println(tmp.next == null ? tmp.val + ",null" : tmp.val
					+ "," + tmp.next.val);
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null) {
			root.right.next = root.next == null ? null : root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}
