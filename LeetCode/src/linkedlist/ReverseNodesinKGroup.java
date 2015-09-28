package linkedlist;

import util.ListNode;
import util.Util;

public class ReverseNodesinKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		 head.next=new ListNode(2);
//		 head.next.next=new ListNode(3);
//		 head.next.next.next=new ListNode(4);
//		 head.next.next.next.next=new ListNode(5);
//		 head.next.next.next.next.next=new ListNode(6);
		 ReverseNodesinKGroup rn=new ReverseNodesinKGroup();
		 ListNode root=rn.reverseKGroup(head, 3);
		 Util.logLinkedList(root);
		
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null)
			return null;
        int i=0;
        ListNode curr=head, prev=null;
        while(i<k&&curr!=null){
            curr=curr.next;
            i++;
        }
        if(i==k){
            curr=head;
            i=0;
            while(i<k){
                ListNode tmp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=tmp;
                i++;
            }
           
//            return prev;
        }else{
            return head;
        }
        if (curr != null) {
			head.next = reverseKGroup(curr, k);
		}
		return prev;
       
    }

}
