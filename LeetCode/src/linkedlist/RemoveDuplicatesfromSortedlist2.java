package linkedlist;

import util.ListNode;
import util.Util;

public class RemoveDuplicatesfromSortedlist2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);
		 head.next.next.next.next=new ListNode(4);
		 head.next.next.next.next.next=new ListNode(3);
		 head.next.next.next.next.next.next=new ListNode(5);
		RemoveDuplicatesfromSortedlist2 rd = new RemoveDuplicatesfromSortedlist2();
		ListNode n = rd.deleteDuplicates(head);
		Util.logLinkedList(n);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode fh = new ListNode(-1);
		fh.next = head;
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		boolean flag = false;
		while (true) {
			flag=false;
			while (head!=null&&head.next != null && head.val == head.next.val) {
				head = head.next;
				fh = fh.next;
				flag = true;
				//
			}
			if(!flag)
				break;
			head=head.next;
			fh=fh.next;
		}
		if (head==null)
			return null;
//		if (!flag) {
//			head = head.next;
//			fh = fh.next;
//		}
		ListNode pre = head, post = head.next;
		while (post != null) {
			if (pre.val != post.val) {
				fh = fh.next;
				pre = pre.next;
				post = post.next;
			} else {
				while (post.next != null && post.val == post.next.val) {
					post = post.next;
				}
				pre = post.next;
				fh.next = pre;
				if (pre == null)
					break;
				post = pre.next;
			}
		}
		return head;
	}
	//this is simpler
	//pre-next=cur
	public ListNode deleteDuplicates1(ListNode head) {  
	    if(head == null)  
	        return head;  
	    ListNode helper = new ListNode(0);  
	    helper.next = head;  
	    ListNode pre = helper;  
	    ListNode cur = head;  
	    while(cur!=null)  
	    {  
	        while(cur.next!=null && pre.next.val==cur.next.val)  
	        {  
	            cur = cur.next;  
	        }  
	        if(pre.next==cur)  
	        {  
	            pre = pre.next;  
	        }  
	        else
	        {  
	            pre.next = cur.next;  
	        }  
	        cur = cur.next;  
	    }  
	          
	    return helper.next;  
	}
}
