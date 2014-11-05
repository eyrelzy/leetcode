package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {
	public static void log(String s) {
		System.out.println(s);
	}

	public static void log(int a) {
		System.out.println(a + "");
	}

	public static void log(double a) {
		System.out.println(a + "");
	}

	public static void logDoubleIntegerList(List<List<Integer>> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				System.out.println(arr.get(i).get(j));
			}
		}
	}
	public static void logMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void logIntegerList(List<List<Integer>> ret) {
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}
	public static void logStringList(List<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	public static void logLinkedList(ListNode head){
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
	}
	public static void logLevelTree(TreeNode root){
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode n=q.poll();
			System.out.print(n.val+"\t");
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}
}
