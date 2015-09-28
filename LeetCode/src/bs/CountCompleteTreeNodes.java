package bs;

import util.TreeNode;
import util.Util;

public class CountCompleteTreeNodes {
	static int count = 0;
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(5);
		root.right=new TreeNode(3);
		System.out.println(new CountCompleteTreeNodes().countNodes(root));
	}
	//LTE O(n)
//	public static int countNodes(TreeNode root){
//		if(root != null){
//			count++;
//			countNodes(root.left);
//			countNodes(root.right);
//		}
//		return count;
//	}
	
//	public int countNodes(TreeNode root) {
//        if(root==null) return 0;
//        
//        int l = getLeft(root) + 1;
//        int r = getRight(root) + 1;
//        
//        if(l==r) {
//        	return (int) (Math.pow(2, l)-1);
//        } else {
//            return countNodes(root.left) + countNodes(root.right) + 1;
//        }
//    }
//    
//    private int getLeft(TreeNode root) {
//        int count = 0;
//        while(root.left!=null) {
//            root = root.left;
//            ++count;
//        }
//        return count;
//    }
//    
//    private int getRight(TreeNode root) {
//        int count = 0;
//        while(root.right!=null) {
//            root = root.right;
//            ++count;
//        }
//        return count;
//    }
	
	public int countNodes(TreeNode root){
		if(root==null)
			return 0;
		int lh=getLeft(root);
		int rh=getRight(root);
		if(lh==rh){
			return (int) (Math.pow(2, lh)-1);
		}
		return countNodes(root.left)+countNodes(root.right)+1;
	}
	private int getLeft(TreeNode root){
		int count = 1;
		if(root.left!=null){
			count = getLeft(root.left)+1;
		}
		return count;
	}
	private int getRight(TreeNode root){
		int count = 1;
		if(root.right!=null){
			count = getRight(root.right)+1;
		}
		return count;
	}
}
