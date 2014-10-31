package linkedlist;

import util.ListNode;
import util.Util;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1=new ListNode(1);
		n1.next=new ListNode(2);
		Util.logLinkedList(removeNthFromEnd(n1, 2));
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        	return null;
        if(head.next==null)
        	return null;
		int p=1;
        ListNode pre=head,cur=head;
        while(p<=n){
            pre=pre.next;
            p++;
        }
        //did not consider this case
        //case of removing head
        if(pre==null){
        	return head.next;
        }
        while(pre.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}
