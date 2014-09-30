import java.awt.List;

import util.ListNode;

public class SwapPairsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);
		n1.next.next.next.next.next = new ListNode(6);
		ListNode head=swapPairs(n1);
		while(head!=null){
			log(head.val+"");
			head=head.next;
		}
	}
	public static void log(String s) {
		System.out.println(s);
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if(head.next==null){
			return head;
		}
		ListNode ret=swapPairs(head.next.next);
		ListNode post=head.next;
		head.next=ret;
		post.next=head;
		head=post;
		return head;
	}


}
