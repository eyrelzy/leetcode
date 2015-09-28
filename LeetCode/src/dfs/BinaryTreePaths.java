package dfs;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreePaths {
	public static TreeNode init(){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.right=new TreeNode(5);
		root.right=new TreeNode(3);
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = init();
		System.out.println(new BinaryTreePaths().binaryTreePaths(root));
	}
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> result=new ArrayList<String>();
	    if(root==null)return result;
	    helper(result,root, new StringBuilder());
	    return result;
	}
	// the diff btw string and stringbuilder
	private void helper(List<String> result,TreeNode root,StringBuilder str){
	    if(root == null)
	        return;
	    str.append(root.val);
	    if(root.left==null&&root.right==null){
	        result.add(str.toString());
	    }
	    if(root.left!=null){
	        helper(result,root.left,str.append("->"));
	    }
	    if(root.right!=null){
	        helper(result,root.right,str.append("->"));
	    }
	}
}
