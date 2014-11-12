
package bt;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class TraversalWithStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> ret = new TraversalWithStack().inorderTraversal(root);
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			TreeNode tmp = nodes.pop();
			ret.add(tmp.val);
			if (tmp.right != null)
				nodes.add(tmp.right);
			if (tmp.left != null)
				nodes.add(tmp.left);
		}
		return ret;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null) {
			return ret;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode p=root;
        while(p!=null||!stack.isEmpty()){  
            //push all LeftChild,when p has no LeftChild,that means it's root,it should be visited  
            while(p!=null){  
                stack.push(p);  
                p=p.left;  
            }  
            if(!stack.isEmpty()){  
                p=stack.pop();  
                ret.add(p.val);//visit root
                p=p.right;  
            }  
        }  

		return ret;
	}
}
