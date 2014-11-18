package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class BTZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		 root.right=new TreeNode(3);
		 root.left=new TreeNode(2);
		 root.left.left=new TreeNode(4);
		 root.right.right=new TreeNode(5);
		 levelTwoQueue(root);
	}

	// Collections.reverse(list)

	// two stack
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		Stack<TreeNode> s1=new Stack<TreeNode>();
		int level=1;
		List<Integer> item=new ArrayList<Integer>();
		item.add(root.val);
		res.add(item);
		s1.push(root);
		while(!s1.isEmpty()){
			Stack<TreeNode> s2=new Stack<TreeNode>();//s2 is to store children value
			item=new ArrayList<Integer>();
			while(!s1.isEmpty()){
				TreeNode n=s1.pop();//s1 is to read 
				if(level%2==0){
					if(n.left!=null){
						s2.push(n.left);
						item.add(n.left.val);
					}
					if(n.right!=null){
						s2.push(n.right);
						item.add(n.right.val);
					}
				}else{//odd level need reverse
					if(n.right!=null){
						s2.push(n.right);
						item.add(n.right.val);
					}
					if(n.left!=null){
						s2.push(n.left);
						item.add(n.left.val);
					}
				}
			}
			level++;
			if(item.size()>0)
				res.add(item);
			s1=s2;
		}
		return res;
	}
	public static void levelTwoQueue(TreeNode root){
		Queue<TreeNode> q1=new LinkedList<TreeNode>();
		q1.add(root);
		int level=1;
		
		System.out.println("====="+level);
		while(!q1.isEmpty()){
			Queue<TreeNode> q2=new LinkedList<TreeNode>();
			while(!q1.isEmpty()){
				TreeNode n=q1.poll();
				System.out.println(n.val);
				if(n.left!=null){
					q2.add(n.left);
				}
				if(n.right!=null){
					q2.add(n.right);
				}
			}
			q1=q2;
			level++;
			System.out.println("====="+level);
		}
	}

}
