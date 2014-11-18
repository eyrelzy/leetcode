package linkedlist;

import util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int carry = 0;
		ListNode list1 = l1, list2 = l2, result = new ListNode(-1), head = result;
		while (list1 != null || list2 != null) {
			if (list1 != null) {
				carry += list1.val;
				list1 = list1.next;
			}
			if (list2 != null) {
				carry += list2.val;
				list2 = list2.next;
			}

			if (carry >= 10) {
				result.next = new ListNode(carry - 10);
				carry = 1;
			} else {
				result.next = new ListNode(carry);
				carry = 0;
			}

			result = result.next;
		}
		if (carry == 1)
			result.next = new ListNode(1);
		return head.next;
	}

}
