package dfs;

import util.TreeNode;

public class ConstructBTfromInorderPreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		TreeNode head = rec(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
		return head;
	}

    public TreeNode rec(int[] inorder, int iSt, int iEd, int[] preorder,
			int pSt, int pEd) {
		if (iSt > iEd || pSt > pEd)
			return null;
		int root_val = preorder[pSt];
		int pos = findPost(root_val, inorder);
		TreeNode n = new TreeNode(root_val);
		int len = pos - iSt;
		n.left = rec(inorder, iSt, pos-1, preorder, pSt+1, pSt + len);
		n.right = rec(inorder, pos+1, iEd, preorder, pSt + len+1, pEd);
		return n;
	}

	public int findPost(int val, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val)
				return i;
		}
		return -1;
	}
}
