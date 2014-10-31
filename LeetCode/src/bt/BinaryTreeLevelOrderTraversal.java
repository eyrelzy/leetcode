package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;
import util.Util;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(3);
		n.left = new TreeNode(9);
		n.right = new TreeNode(20);
		n.right.left = new TreeNode(15);
		n.right.right = new TreeNode(7);
		List<List<Integer>> ret=levelOrder(n);
		Util.logIntegerList(ret);
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> sub=new ArrayList<Integer>();
        Queue<TreeNode> qt=new LinkedList<TreeNode>();
        qt.add(root);
        int incnt=1,outcnt=0;
        while(!qt.isEmpty()){
            TreeNode n=qt.poll();
            sub.add(n.val);
            outcnt++;
            if(n.left!=null)
                qt.add(n.left);
            if(n.right!=null)
                qt.add(n.right);
            if(outcnt==incnt){
                incnt=qt.size();
                ret.add(sub);
                sub=new ArrayList<Integer>();
                outcnt=0;
            }
        }
        return ret;
    }
}
