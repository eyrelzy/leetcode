package linkedlist;

import util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode head = addTwoNumbers2(l1, l2);
		System.out.print(head.val);
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
    public  static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val + carry;
            l1 = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry!=0){
            l1 = new ListNode(1);
        }
        return dummy.next;
    }
}
