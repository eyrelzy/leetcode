package dp;
//needs a second time

//dfs

//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;
import util.Util;

public class UniqueBinarySearchTrees1And2 {
	
	// 1 2 3 4 5 6
	// .#(i-1).. i .#(N-i)...
	public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        nums[1]=1;
        for(int i=2;i<=n;i++){
            //computing nums[i=N]
            for(int j=1;j<=i;j++){
                nums[i] += nums[j-1]*nums[i-j];
            }
        }
        return nums[n];
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		generateTrees(3);
	  UniqueBinarySearchTrees1And2 u = new UniqueBinarySearchTrees1And2();
	  u.numTrees(2);
	}
	
	public List<TreeNode> generateTrees2(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);
        for(int N=1;N<=n;N++){
            result[N] = new ArrayList<TreeNode>();
            for(int i=1;i<=N;i++){
                for(TreeNode left:result[i-1]){
                    for(TreeNode right:result[N-i]){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = clone(right, i);
                        result[N].add(root);
                    }
                }
            }
        }
        return result[n];
	}

	private TreeNode clone(TreeNode root, int offset) {
		if (root == null)
			return null;
		TreeNode node = new TreeNode(root.val + offset);
		node.left = clone(root.left, offset);
		node.right = clone(root.right, offset);
		return node;
	}

	public static List<TreeNode> generateTrees(int n) {
		return dfs(0, n - 1);
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
