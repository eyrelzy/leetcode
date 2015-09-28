package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.ListNode;

public class MergeKLists {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MergeKLists mk = new MergeKLists();
    ListNode l1=new ListNode(1);
    ListNode l2=new ListNode(2);
    ListNode[] lists = new ListNode[2];
    lists[0]=l1;
    lists[1]=l2;
    ListNode head = mk.mergeKLists_heap(lists);
    System.out.print(head);
     
  }

  public ListNode mergeKLists_divideConquer(ListNode[] lists) {
    return mergeKLists(lists, 0, lists.length - 1);
  }

  public ListNode mergeKLists_heap(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>
    (lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
       if(o1.val<o2.val)
           return -1;
       else if(o1.val==o2.val)
         return 0;
       else
           return 1;
      }
    });
    for (int i = 0; i < lists.length; i++) {
      if(lists[i]!=null)
        pq.add(lists[i]);
    }
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while(!pq.isEmpty()){
      ListNode top = pq.poll();
      curr.next = top;
      if(top.next!=null){
        pq.add(top.next);
      }
      curr = curr.next;
    }
    return dummy.next;
  }

  public ListNode mergeKLists(ListNode[] lists, int left, int right) {
    if (left > right)
      return null;
    if (left == right)
      return lists[left];
    int mid = (left + right) / 2;
    ListNode l1 = mergeKLists(lists, left, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, right);
    return mergeTwoLists(l1, l2);
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        curr.next = l2;
        break;
      }
      if (l2 == null) {
        curr.next = l1;
        break;
      }
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    return dummy.next;
  }

}
