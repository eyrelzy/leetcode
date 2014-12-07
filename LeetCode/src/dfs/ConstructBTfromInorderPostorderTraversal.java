package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.TreeNode;

public class ConstructBTfromInorderPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test case:
		int[] in = { 4, 3, 6, 5, 2, 8, 9, 7 };
		int[] post = { 4, 6, 5, 3, 9, 8, 7, 2 };
		ConstructBTfromInorderPostorderTraversal cinpos = new ConstructBTfromInorderPostorderTraversal();
		TreeNode head = cinpos.buildTree(in, post);
		List<Integer> list=new ArrayList<Integer>();
		cinpos.inorder(head,list);
		System.out.println(Arrays.toString(in));
		System.out.println(list);

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode head = rec(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
		return head;
	}

	public TreeNode rec(int[] inorder, int iSt, int iEd, int[] postorder,
			int pSt, int pEd) {
		if (iSt > iEd || pSt > pEd)
			return null;
		int root_val = postorder[pEd];
		int pos = findPost(root_val, inorder);
		TreeNode n = new TreeNode(root_val);
		int len = pos - iSt;//sub left tree size
		n.left = rec(inorder, iSt, pos - 1, postorder, pSt, pSt + len - 1);//make sure you get each left and right boundary
		n.right = rec(inorder, pos+1, iEd, postorder, pSt + len, pEd - 1);
		return n;
	}

	public int findPost(int val, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val)
				return i;
		}
		return -1;
	}

	public void inorder(TreeNode head, List<Integer> list) {
		if (head == null)
			return;
		inorder(head.left,list);
		list.add(head.val);//System.out.println(head.val);
		inorder(head.right,list);
	}

}
