package linkedlist;

import util.ListNode;

public class IntersectionofTwoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headA = new ListNode(0);
		ListNode c1 = new ListNode(1);
		ListNode c2 = new ListNode(2);
		ListNode c3 = new ListNode(3);
		headA.next = c1;
		headA.next.next = c2;
		headA.next.next.next = c3;
		ListNode headB = new ListNode(-1);
		headB.next = new ListNode(-2);
		headB.next.next = new ListNode(-3);
		headB.next.next = c1;
		// ListNode c1= new ListNode(1);
		// ListNode headA=c1,headB=c1;
		IntersectionofTwoLL it = new IntersectionofTwoLL();
		System.out.println(it.getIntersectionNode(headA, headB).val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode heada = headA, headb = headB;
		while (heada != null && headb != null) {
			heada = heada.next;
			headb = headb.next;
		}
		while (heada != null) {
			headA = headA.next;
			heada = heada.next;
		}
		while (headb != null) {
			headB = headB.next;
			headb = headb.next;
		}
		if (headA == headB)
			return headA;
		while (headA.next != null) {
			if (headA.next == headB.next) {
				return headA.next;
			}
			headA=headA.next;
			headB=headB.next;
		}
		return null;
	}

}
