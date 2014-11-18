package linkedlist;

import util.ListNode;
import util.Util;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList r = new ReorderList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		r.reorderList(head);
		Util.logLinkedList(head);
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head, slow = head, pre = head, temp1 = null, temp2 = null;
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			fakeHead = fakeHead.next;
		}
		// slow is the middle point
		fakeHead.next = null;
		ListNode righthead = reverseRightHalf(slow);
//		Util.logLinkedList(righthead);

		while (pre != null) {
			temp1 = pre.next;
			temp2 = righthead.next;
			pre.next = righthead;
			righthead.next = temp1;
			pre = temp1;
			righthead = temp2;
		}
		// Util.logLinkedList(head);

	}

	public ListNode reverseRightHalf(ListNode head) {
		if (head.next == null)
			return head;
		ListNode cur = head, temp = head, prev = null;
		while (cur != null) {
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

	public static void reorderList2(ListNode head) {
		if (head == null || head.next == null)
			return;

		// partition the list into 2 sublists of equal length
		ListNode slowNode = head, fastNode = head;
		while (fastNode.next != null) {
			fastNode = fastNode.next;
			if (fastNode.next != null) {
				fastNode = fastNode.next;
			} else {
				break;
			}
			slowNode = slowNode.next;
		}
		// 2 sublist heads
		ListNode head1 = head, head2 = slowNode.next;
		// detach the two sublists
		slowNode.next = null;
		
		// reverse the second sublist
		ListNode cur = head2, post = cur.next;
		cur.next = null;
		while (post != null) {
			ListNode temp = post.next;
			post.next = cur;
			cur = post;
			post = temp;
		}
		head2 = cur; // the new head of the reversed sublist
//		Util.logLinkedList(head2);
		//head 1 has more nodes than head2
		
		Util.logLinkedList(head1);
		// merge the 2 sublists as required
		ListNode p = head1, q = head2;
		while (q != null) {
			ListNode temp1 = p.next;
			ListNode temp2 = q.next;
			p.next = q;
			q.next = temp1;
			p = temp1;
			q = temp2;
		}
	}

}
