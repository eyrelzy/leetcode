package linkedlist;

import util.ListNode;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head, slow=head;
        while(fast.next!=null){
            fast=fast.next;
            if(fast.next!=null){
                fast=fast.next;
            }else
                break;
            slow=slow.next;
        }
        ListNode post=slow.next, pre=head;
        slow.next=null;
        ListNode left=sortList(pre);
        ListNode right=sortList(post);
        ListNode p=left, q=right;
        return mergeLink(p,q);
        
    }
    public ListNode mergeLink(ListNode head1, ListNode head2) {
        ListNode fhead=new ListNode(-1),p=head1,q=head2;
        fhead.next=p;
        ListNode cur=fhead;
        while(p!=null&&q!=null){
            if(p.val>q.val){
              ListNode tmp=q.next;
              q.next=cur.next;
              cur.next=q;
              cur=q;
              q=tmp;
              
            }else{
                cur=cur.next;
                p=p.next;
            }
        }
        if(q!=null){
            cur.next=q;
        }
        return fhead.next;
    }

}
