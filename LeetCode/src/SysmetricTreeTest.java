

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class SysmetricTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(3);
		root.right.left=new TreeNode(4);
		root.right.left.left=new TreeNode(5);
		Boolean ret=levelorder(root);
		log(ret+"");
	}
	public static void log(String s) {
		System.out.println(s);
	}
	public static boolean levelorder(TreeNode root) {
		if(root==null)
			return true;
		Queue<TreeNode> tq=new LinkedList<TreeNode>();
		tq.add(root);
		int incount=1,outcount=0;
		int level=1;
		while(!tq.isEmpty()){
			TreeNode n=tq.poll();
			log("level"+level+" : "+n.val);
			outcount++;
			if(n.left!=null){
				tq.add(n.left);
			}
			else{
				tq.add(new TreeNode(Integer.MIN_VALUE));
			}
			if(n.right!=null){
				tq.add(n.right);
			}
			else{
				tq.add(new TreeNode(Integer.MIN_VALUE));
			}
			if(incount==outcount){
				log("");
				incount=tq.size();//vital!!!
				Queue<TreeNode> temp=new LinkedList<TreeNode>(tq);
				Queue<TreeNode> temp2=new LinkedList<TreeNode>(tq);
				Stack<TreeNode> temps=new Stack<TreeNode>();
				while(!temp.isEmpty()){
					temps.push(temp.poll());
				}
				while(!temps.isEmpty()){
					if(temps.pop().val!=temp2.poll().val)
						return false;
				}
				outcount=0;
				level++;
			}
		}
		return true;
	}
	public boolean isSymmetric(TreeNode root){
		if(root==null)
			return true;
		return isSymmetric(root.left,root.right);
	}
	public boolean isSymmetric(TreeNode a,TreeNode b){
		if(a==null) return b==null;
		if(b==null)	return false;
		if(a.val!=b.val) return false;
		if(!isSymmetric(a.left, b.right))	return false;
		if(!isSymmetric(a.right, b.left))	return false;
		return true;
	}
	public boolean isSymmetric2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>(),
                            r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while(!l.isEmpty() && !r.isEmpty()){
            TreeNode temp1=l.poll(),
                     temp2=r.poll();
            if(temp1==null && temp2!=null || temp1!=null && temp2==null)
                return false;
            if(temp1!=null){
                if(temp1.val!=temp2.val) return false;
                l.add(temp1.left);
                l.add(temp1.right);
                r.add(temp2.right);
                r.add(temp2.left);
            }
        }
        return true;
    }
}
