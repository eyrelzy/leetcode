import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class sortedArraytoBST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 3, 4, 6 };
		TreeNode root = sortedArrayToBST(A);
		
	}

	public static void log(String s) {
		System.out.println(s);
	}

	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		TreeNode root = createBST(num, 0, num.length - 1);
		// log(root.val+","+root.left.val);
		return root;
	}

	public static TreeNode createBST(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		// log("mid"+mid);
		TreeNode root = new TreeNode(num[mid]);
		root.left = createBST(num, start, mid - 1);// here
		root.right = createBST(num, mid + 1, end);
		return root;
	}

	
}
