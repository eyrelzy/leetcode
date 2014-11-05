package dp;
//needs a second time

//dfs

//
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;
import util.Util;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees(3);
	}
	public static List<TreeNode> generateTrees(int n){
		return dfs(0,n-1);
	}
	public static List<TreeNode> dfs(int begin, int end){
		List<TreeNode> ret=new LinkedList<TreeNode>();
		if(begin>end){
			ret.add(null);//occupy the position
			return ret;
		}
		for(int i=begin;i<=end;i++){
			List<TreeNode> lefts=dfs(begin,i-1);
			List<TreeNode> rights=dfs(i+1,end);
			
			for(int j=0;j<lefts.size();j++){//here size is the null that occupies the storage
				for(int k=0;k<rights.size();k++){
					TreeNode root=new TreeNode(i+1);//i is location, and since we start
					//from 0, so here the value is i+1
					root.left=lefts.get(j);
					root.right=rights.get(k);
					ret.add(root);
					Util.logLevelTree(root);
				}
			}
			System.out.println();
		}
		return ret;
	}
	
}
