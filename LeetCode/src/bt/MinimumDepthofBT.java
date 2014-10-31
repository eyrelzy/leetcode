package bt;

import java.util.LinkedList;

import util.TreeNode;

public class MinimumDepthofBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(2);
		root.left.left.left.left = new TreeNode(2);
		System.out.println(minDepth1(root));
	}
//dfs, tested by leetcode online judge is time limit
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		
		//here we consider the one line case such that root=1,root.left=1,root.left.left.left.....
		
//		if (left == 0)
//			return right + 1;
//		if (right == 0)
//			return left + 1;
		return Math.min(left, right) + 1;
	}
	//linkedlist or stack
	//two linkedlist time O(n)
	public static int minDepth1(TreeNode root){
		if(root==null)
			return 0;
		LinkedList<TreeNode> nodelist=new LinkedList<TreeNode>();
		LinkedList<Integer> depthlist=new LinkedList<Integer>();
		nodelist.add(root);
		depthlist.add(1);
		while(!nodelist.isEmpty()){
			TreeNode n=nodelist.remove();
			int cur_min=depthlist.remove();
			if(n.left==null&&n.right==null){
				//leaf node
				return cur_min;
				//this is level traversal method, if we reach two null children for one node, it means we could end ahead of time.  
			}
			if(n.left!=null){
				nodelist.add(n.left);
				depthlist.add(cur_min+1);
			}
			if(n.right!=null){
				nodelist.add(n.right);
				depthlist.add(cur_min+1);
			}
		}
		return -1;
	}

}
