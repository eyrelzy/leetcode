package linkedlist;

import util.ListNode;

public class MergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test case

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(10);
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(3);
		ListNode head = new MergeTwoLists().mergeTwoLists(head1, head2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(-1);
		ListNode k = head;
		while (l1!= null && l2!= null) {
			if (l1.val < l2.val) {
				k.next = l1;
				l1 = l1.next;
			} else {
				k.next = l2;
				l2 = l2.next;
			}
			k = k.next;
		}
		while (l1 != null) {
			k.next = l1;
			l1 = l1.next;
			k = k.next;
		}
		while (l2!= null) {
			k.next = l2;
			l2 = l2.next;
			k = k.next;
		}
		return head.next;
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
}
