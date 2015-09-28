package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            node = node.right;
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        return result;
	}
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            result.add(root.val);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            node = node.right;
            while(node!=null){
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
        }
        return result;
    }
}
