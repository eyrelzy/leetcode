package dfs;

import util.TreeNode;

//@see SameTree
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return checkSymmetric(root.left, root.right);
    }
    private boolean checkSymmetric(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if((p != null && q == null)||(p==null && q!=null)){
            return false;
        }
        if(p.val != q.val)  return false;
        return checkSymmetric(p.left, q.right)&&checkSymmetric(p.right, q.left);
    }
}
