package linkedlist;

import util.ListNode;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(4);
		new RemoveDuplicates().display_list(head);
		System.out.println();
		new RemoveDuplicates().display_list(new RemoveDuplicates()
				.deleteDuplicates(head));
	}

	public void display_list(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + ",");
			p = p.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode p = head, q = p.next;
		//the iterator condition is vital!
		while (p != null && p.next != null) {
			q = p.next;
			if (q.val == p.val) {
				p.next = q.next;
			} else {
				p = p.next;
			}
		}
		return head;
	}

}
