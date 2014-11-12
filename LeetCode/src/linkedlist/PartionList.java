package linkedlist;

import util.ListNode;
import util.Util;

public class PartionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Given 1->4->3->2->5->2 and x = 3,
//				return 1->2->2->4->3->5.
		ListNode head=new ListNode(1);
//		head.next=new ListNode(1);
		
		ListNode ret=partition(head, 0);
		Util.logLinkedList(ret);
	}
	//probably create additional node.
	public static ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1), big=new ListNode(-1),p=head;
        ListNode bighead=big,smallhead=small;
        while(p!=null){
            if(p.val<x){
                small.next=new ListNode(p.val);
                small=small.next;
            }
            else{
               big.next=new ListNode(p.val);
               big=big.next;
            }
            p=p.next;
        }
        small.next=bighead.next;
        return smallhead.next;
    }
	//won't create additional node
	public static ListNode partition1(ListNode head, int x){
		if(head == null)  
	        return null;  
	    ListNode helper = new ListNode(0);  
	    helper.next = head;
	    ListNode walker=helper,runner=helper;
	   
	    while(runner.next!=null){
	    	if(runner.next.val<x){
	    		if(runner!=walker){
	    			ListNode tmp=runner.next;
	    			runner.next=runner.next.next;
	    			tmp.next=walker.next;
	    			walker.next=tmp;
	    			walker=walker.next;
	    		}else{
	    			runner=runner.next;
	    			walker=walker.next;
	    		}
	    		
	    	}else{
	    		runner=runner.next;
	    	}
	    }
		
		return helper;
	}

}
