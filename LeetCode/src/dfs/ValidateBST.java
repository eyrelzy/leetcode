package dfs;

import util.TreeNode;

// Remember to use Long.MIN_VALUE, since we the smallest value could be 
// min_value of integer
public class ValidateBST {

	private long prev = Long.MIN_VALUE;
    private boolean isValid = true;
    //#1
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
    	return isValid;
    }
    public void inOrder(TreeNode root){
    	if(root==null)
    		return;
    	if(isValid){
    	    inOrder(root.left);
    	    if(root.val<=prev){
    	        isValid = false;
    	        return;
    	    }else{
    	        prev = root.val;
    	    }
    	    inOrder(root.right);
    	}
    }
    //#2
    public boolean isValidBST2(TreeNode root) {
    	return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidHelper(TreeNode root, long min, long max){
    	if(root==null)
    		return true;
    	if(min>=root.val||max<=root.val){
    		return false;
    	}
    	return isValidHelper(root.left,min, root.val)&&isValidHelper(root.right,root.val,max);
    }
    
}
