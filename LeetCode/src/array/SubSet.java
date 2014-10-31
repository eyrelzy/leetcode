package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.Util;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[3];
		test[0]=2;
		test[1]=1;
		test[2]=3;
		List<List<Integer>> list=subsets(test);
//		Util.logIntegerList(list);
	}
public static void print(List<Integer> l){
	
		System.out.println("@"+l.toString());
}
	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ret=new LinkedList<List<Integer>>();
		Arrays.sort(S);
		ret.add(new LinkedList<Integer>());
		for(int i=0;i<S.length;i++){
			List<Integer> arr=new LinkedList<Integer>();
			int size=ret.size();
			for(int j=0;j<size;j++){
//				arr=ret.get(j);//添加arr.add(S[i])，导致把原来的ret.get(j)也改变了
				arr=new LinkedList<Integer>(ret.get(j));
				print(arr);
				arr.add(S[i]);
				ret.add(arr);
			}
//			ret.add(arr);
			System.out.println("====="+ret.size()+"======");
			Util.logIntegerList(ret);
			System.out.println("====="+ret.size()+"======");
		}
		return ret;
	}
}
