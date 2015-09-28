package dfs;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		ConvertSortedListToBST cst =  new ConvertSortedListToBST();
		TreeNode root = cst.sortedArrayToBST(nums);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)    return null;
        TreeNode root = null;
        createBST(root, nums, 0, nums.length-1);
        return root;
    }
    public void createBST(TreeNode root, int[] num, int start, int end){
		if(start>end)   return;
		int mid=(start+end)/2;
		root = new TreeNode(num[mid]);
		createBST(root.left, num, start,mid-1);
		createBST(root.right, num, mid+1, end);
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
