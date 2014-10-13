import java.util.ArrayList;
import java.util.List;

import util.Util;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr=generateParenthesis(3);
		Util.logStringList(arr);
	}

	public static List<String> generateParenthesis(int n) {
		if(n==0)
			return new ArrayList<String>();
		String sb=new String();
		List<String> ret=new ArrayList<String>();
		rec(n,n,sb,ret);
		return ret;
	}
	
	/**
	 * dfs idea
	 * */
	public static void rec(int left,int right,String sb,List<String> ret){
		if(left>right)
			return;
		if(left==0&&right==0){
			ret.add(new String(sb));
			return;
		}
		if(left>0){
			rec(left-1,right,sb+"(",ret);
		}
		if(right>0){
			rec(left, right-1,sb+")",ret);
		}
	}

}
