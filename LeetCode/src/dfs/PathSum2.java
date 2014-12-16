package dfs;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (root == null && sum == 0) {
			return ll;
		}
		if(root==null&&sum!=0)
			return null;
		dfs(root, ll, new ArrayList<Integer>(), sum);
		return ll;

	}

	public void dfs(TreeNode root, List<List<Integer>> ll, List<Integer> list,
			int sum) {

		list.add(root.val);
		if (root.left != null) {
			dfs(root.left, ll, list, sum);
			list.remove(list.size() - 1);
		}
		if (root.right != null) {
			dfs(root.right, ll, list, sum);
			list.remove(list.size() - 1);
		}
		if (root.right == null && root.left == null) {
			int psum = 0;
			for (Integer i : list) {
				psum += i;
			}
			if (psum == sum) {
				ll.add(new ArrayList<Integer>(list));//this is the key point
				//otherwise, some of this list may be removed when return back
			}
			return;
		}
	}
}
