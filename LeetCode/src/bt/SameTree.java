package bt;

import util.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test cases
		TreeNode root1 = new TreeNode(0);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
//		root1.left.left=new TreeNode(3);
		
		TreeNode root2 = new TreeNode(0);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(2);
		System.out.println(new SameTree().isSameTree(root1, root2));
	}
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null || root.right != null) {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
		return 1;
	}
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null&&q==null)
			 return true;
		 if(p==null&&q!=null)
			 return false;
		 if(p!=null&&q==null)
			 return false;
		 if(p.val==q.val)
		 {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right); 
		 }
		 return false;
	    }
}
