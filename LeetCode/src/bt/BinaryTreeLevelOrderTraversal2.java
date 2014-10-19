package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;
import util.Util;

public class BinaryTreeLevelOrderTraversal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(3);
		n.left = new TreeNode(9);
		n.right = new TreeNode(20);
		n.right.left = new TreeNode(15);
		n.right.right = new TreeNode(7);
		List<List<Integer>> ret=levelOrderBottom(n);
		Util.logIntegerList(ret);
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> qt = new LinkedList<TreeNode>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null)
			return ret;
		qt.add(root);
		st.push(new TreeNode(Integer.MIN_VALUE));
		int incnt = 1, outcnt = 0;
		while (!qt.isEmpty()) {
			TreeNode n = qt.poll();
			outcnt++;
			st.push(n);
			if (n.right != null) {
				qt.add(n.right);
			}
			if (n.left != null) {
				qt.add(n.left);
			}
			if (incnt == outcnt) {
				st.push(new TreeNode(Integer.MIN_VALUE));
				incnt=qt.size();
				outcnt=0;
			}
		}
//		Util.log("size"+st.size());
		List<Integer> sub=new ArrayList<Integer>();
		while(!st.isEmpty()){
			int v=st.peek().val;
			
			if(v!=Integer.MIN_VALUE){
				sub.add(v);
				Util.log(v);
			}
			else{
				if(sub.size()!=0)
					ret.add(sub);
				sub=new ArrayList<Integer>();
			}
			st.pop();
		}
		return ret;
	}
	//每次不是取出一个节点，而是取出在queue中的所有节点，这样就取出了一层的节点，将他们一同输出
	public ArrayList<ArrayList<Integer>> levelOrderBottom2(TreeNode root) {  
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  
        if (root == null)  
            return result;  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();  
          
        //初始化先放入根结点到队列中, 为第一层结点  
        queue.add(root);  
          
        //这里采取一层层的方式加入到队列中  
        while (!queue.isEmpty()){  
            ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();  
            ArrayList<Integer> tempValueList = new ArrayList<Integer>();  
              
            //先取出队列中的所有结点，因为它们是属于同一个层次的,并把这一层结点对应的ArrayList<Integer>值加入到list中。  
            while (!queue.isEmpty()){  
                TreeNode node = queue.remove();  
                tempList.add(node);  
                tempValueList.add(node.val);  
            }  
            list.add(tempValueList);  
              
            //对刚取出的这一个层次的下一个层次进行遍历加入到队列中。  
            for (int i=0; i<tempList.size(); ++i){  
                TreeNode node = tempList.get(i);  
                if (node.left != null){  
                    queue.add(node.left);  
                }  
                if (node.right != null){  
                    queue.add(node.right);  
                }  
            }  
        }  
          
        //结果List的翻转  
        for (int i=list.size()-1; i>=0; --i){  
            result.add(list.get(i));  
        }  
        return result;  
    }  
}
