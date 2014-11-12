package linkedlist;

import util.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode prehead=new ListNode(-1);
        prehead.next=head;
        ListNode cur=head.next, pre=head,q=prehead;
        while(cur!=null){
            if(cur.val>=pre.val){
                cur=cur.next;
                pre=pre.next;
            }else{
                //insert into sorted list
                while(q.next.val<=cur.val){
                    q=q.next;
                }
                pre.next=cur.next;
                cur.next=q.next;
                q.next=cur;
                cur=pre.next;
                q=prehead;
            }
        }
        return prehead.next;
    }
}
