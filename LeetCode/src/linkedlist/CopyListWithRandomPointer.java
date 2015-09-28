package linkedlist;

import java.util.HashMap;

import util.RandomListNode;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//quite similar to Clone Graph
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)  
            return head;  
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();  
        RandomListNode nhead = new RandomListNode(head.label);
        map.put(head,nhead);
        RandomListNode curr=head.next, p=nhead;
        while(curr!=null){
            p.next=new RandomListNode(curr.label);
            map.put(curr,p.next);
            p=p.next;
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        return nhead;
    }
	//see follow up constant space improve 
	//http://blog.csdn.net/linhuanmars/article/details/22463599

}
