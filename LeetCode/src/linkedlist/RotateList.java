package linkedlist;

import util.ListNode;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode rotateRight(ListNode head, int n) {
        if(n==0)
            return head;
        if(head==null)
            return null;
        int i=0;
        ListNode fast=head, slow=head,nhead=head;
        while(i<n&&fast!=null){
            fast=fast.next;
            i++;
        }
        //if n is more than link length
        //ask for the result when n is more than length, here we use mode if so
        //if n=4,[1,2,3], we return n=1,[1,2,3], that is[3,1,2]
        if(fast==null){
            //reverse linkedlist
            int mode=n%i;
            return rotateRight(head,mode);
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        nhead=slow.next;
        slow.next=null;
        fast.next=head;
        return nhead;
        
    }
}
