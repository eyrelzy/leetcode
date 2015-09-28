package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int in=1, out=0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            out++;
            if(top.left != null)
                queue.add(top.left);
            if(top.right != null)
                queue.add(top.right);
            if(in == out){
                in = queue.size();
                out = 0;
                ret.add(top.val);
            }
        }
        return ret;
    }
}
