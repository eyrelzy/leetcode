package dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import util.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node1=new UndirectedGraphNode(0);
		UndirectedGraphNode node2=new UndirectedGraphNode(1);
		UndirectedGraphNode node3=new UndirectedGraphNode(2);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node3.neighbors.add(node3);
		node3.neighbors.add(node1);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		CloneGraph cg=new CloneGraph();
		UndirectedGraphNode n=cg.cloneGraph(node1);
//		cg.printResult(n);
		
	}
	public void printResult(UndirectedGraphNode n){
		System.out.println(n.label);
		 for(UndirectedGraphNode u: n.neighbors){
			 System.out.println(u.label);
		 }
		 System.out.println("#");
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> hm=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		if(node==null)
			return null;
		UndirectedGraphNode head=new UndirectedGraphNode(node.label);
		hm.put(node,head);
		System.out.println(hm.get(node).label);
		dfs(node,hm);
		return head;
    }
	public void dfs(UndirectedGraphNode node,HashMap<UndirectedGraphNode, UndirectedGraphNode> hm){
		if(node==null)
			return ;
		for(UndirectedGraphNode un: node.neighbors){
			if(hm.containsKey(un)){
				
			}else{
				UndirectedGraphNode unode=new UndirectedGraphNode(un.label);
				hm.put(un,unode);
				dfs(un,hm);
			}
			hm.get(node).neighbors.add(hm.get(un));
			System.out.println(hm.get(node).label+":"+hm.get(un).label);
		}
		System.out.println("#");
	}
	public void bfs(UndirectedGraphNode node,HashMap<UndirectedGraphNode, UndirectedGraphNode> hm){
		Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
		q.add(node);
		while(!q.isEmpty()){
			UndirectedGraphNode n=q.poll();
			for(UndirectedGraphNode un: n.neighbors){
				if(!hm.containsKey(un)){
					UndirectedGraphNode unode=new UndirectedGraphNode(un.label);
					hm.put(un,unode);
					q.add(un);
				}
				hm.get(n).neighbors.add(hm.get(un));
			}
		}
	}
	
}

