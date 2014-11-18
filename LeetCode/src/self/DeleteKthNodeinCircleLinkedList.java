package self;

import util.ListNode;

public class DeleteKthNodeinCircleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(josephus(5, 3));
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=head;
		System.out.println(deleteKth(head, 3));
	}

	/**
	 * f[1] = 0 f[2] = (0+3)%2 = 1 f[3] = (1+3)%3 = 1 f[4] = (1+3)%4 = 0 f[5] =
	 * (0+3)%5 = 3.
	 * */
	// Solution1: math one
	// O(n)
	/*
	 * @param n how many nodes in a circle
	 * 
	 * @param k the steps each time we move forward to delete
	 * 
	 * @return the node would leave out after the whole process suppose the
	 * index starts from zero.
	 */
	static int josephus(int n, int k) {
		if (n == 1)
			return 0;
		return (josephus(n - 1, k) + k) % n;
	}

	// plain solution 2: O(kn)

	static int deleteKth(ListNode head, int k) {
		while (head.next != head) {
			for (int j = 1; j < k - 1; j++) {
				head = head.next;
			}
			head.next = head.next.next;
			head = head.next;
		}
		return head.val;
	}

}
