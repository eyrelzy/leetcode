package dfs;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        TreeNode root=dfs(head);
        return root;
      
    }
    public TreeNode dfs(ListNode head){
         if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        ListNode walker=head,runner=head,pre=new ListNode(-1);
        pre.next=head;
        while(runner!=null&&runner.next!=null){
            pre=pre.next;
            walker=walker.next;
            runner=runner.next.next;
        }
        TreeNode root=new TreeNode(walker.val);
        pre.next=null;
        root.left=dfs(head);
        root.right=dfs(walker.next);
        return root;
    }

}
