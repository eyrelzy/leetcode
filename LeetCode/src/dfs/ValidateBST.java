package dfs;

import util.TreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(5);
//		TreeNode root=new TreeNode(1);
//		TreeNode root=new TreeNode(1);
		 ValidateBST vb=new ValidateBST();
		 System.out.println(vb.isValidBST2(root));
	}
	//brute force
	public boolean isValidBST(TreeNode root) {  
        if(root == null){  
            return true;  
        }  
        return isSubTreeLessThan(root.left, root.val) && isSubTreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);  
    }  
      
    public boolean isSubTreeLessThan(TreeNode node, int val){  
        if(node == null){  
            return true;  
        }  
        return node.val < val && isSubTreeLessThan(node.left, val) && isSubTreeLessThan(node.right, val);  
    }  
      
    public boolean isSubTreeGreaterThan(TreeNode node, int val){  
        if(node == null){  
            return true;  
        }  
        return node.val > val && isSubTreeGreaterThan(node.left, val) && isSubTreeGreaterThan(node.right, val);  
    }  
//maintain min, max for every node that min=max(left-sub), max=min(right-sub)
    public boolean isValidBST1(TreeNode root){
    	if(root==null)
    		return true;
    	
    	return isValidSub(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidSub(TreeNode root, int min, int max){
    	if(root==null)
    		return true;
    	if(min>=root.val||max<=root.val){
    		System.out.println(root.val+","+min+","+max);
    		return false;
    	}
    	return isValidSub(root.left,min, root.val)&&isValidSub(root.right,root.val,max);
    }
    public boolean isValidBST2(TreeNode root){
    	if(root==null)
    		return true;
    	return inOrder(root, new TreeNode(Integer.MIN_VALUE));
    	
    }
    private TreeNode p=new TreeNode(Integer.MIN_VALUE);
    public boolean inOrder(TreeNode root, TreeNode pre){
    	if(root==null)
    		return true;
    	boolean a=inOrder(root.left, p);
    	if(root.val<p.val){
    		return false;
    	}
    	p=new TreeNode(root.val);
    	boolean b=inOrder(root.right, p);
    	return a&&b;
    }
    
}
