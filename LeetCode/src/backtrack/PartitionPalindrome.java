package backtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionPalindrome pp = new PartitionPalindrome();
		pp.partition2("aaba");
	}

	public List<List<String>> partition(String s) {
		List<List<String>> retlist = new ArrayList<List<String>>();
		List<String> sublist = new ArrayList<String>();
		partitionSub(s, 0, s.length(), sublist, retlist);
		return retlist;
	}

	public void partitionSub(String s, int start, int n, List<String> sublist,
			List<List<String>> retlist) {
		if (start == n) {
			List<String> nsub = new ArrayList<String>(sublist);
			// String valid = "";
			// for (String as : nsub) {
			// valid += as;
			// }
			// if (valid.equals(s)) {
			retlist.add(nsub);
			System.err.println(nsub);
			// }
		}
		for (int j = start + 1; j <= n; j++) {
			String ss = s.substring(start, j);
			if (isPalindrome(ss)) {
				sublist.add(ss);
				partitionSub(s, j, n, sublist, retlist);
				sublist.remove(sublist.size() - 1);
				// System.out.println(sublist);
			}
		}

	}

	public boolean isPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		String rs = sb.reverse().toString();
		if (rs.equals(s)) {
			return true;
		}
		return false;
	}
	//see http://www.lifeincode.net/programming/leetcode-palindrome-partitioning-i-and-iijava/
//try dp but failed
	public List<List<String>> partition2(String s) {
		int n=s.length();
		List<List<String>>[] ret=(List<List<String>>[]) Array.newInstance(List.class, n);
		List<String> sub=new ArrayList<String>();
		List<List<String>> arr=new ArrayList<List<String>>();
		sub.add(s.substring(0,1));
		arr.add(sub);
		ret[0]=arr;
		for(int i=1;i<=s.length();i++){
			for(int j=0;j<i;j++){
				if(isPalindrome(s.substring(j,i))){
					List<List<String>> ll=ret[j];
					List<List<String>> nl=new ArrayList<List<String>>();
					for(List<String> l:ll){
						List<String> nn=new ArrayList<String>(l);
						nn.add(s.substring(j,i));
						nl.add(nn);
					}
					ret[i]=nl;
				}
			}
		}
		return ret[n-1];
	}
}
