package dfs;

import java.util.Stack;

import util.TreeNode;

public class KthSmallestElementInBST {
	//#1
	public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            k--;
            if(k==0){
                return node.val;
            }
            node = node.right;
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        return  -1;
    }
	//#2 this seems like binary search, it takes o(nlogn) still
	// since it needs to count nodes in left sub tree, which use dfs, and takes o(n)
	public int kthSmallest2(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest2(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest2(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
    //#3 this actually takes o(k)
    int val = -1;
    int cnt = 0;
    public void inOrder(TreeNode root, int k){
        if(root == null)
            return;
        if(root.left!=null)
            inOrder(root.left, k);
        cnt++;
        if(cnt == k){
            val = root.val;
            return;
        }
        if(root.right!=null)
            inOrder(root.right, k);
    }
    public int kthSmallest3(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }
}
