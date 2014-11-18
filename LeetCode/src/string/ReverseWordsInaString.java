package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInaString rw = new ReverseWordsInaString();
		String s="    ";
		String ret=rw.reverseWords1(s);
		System.out.println("?"+ret+"?");
		
	}

	public String reverseWords(String s) {
		String[] ss = s.trim().split("\\s+");
		List<String> tokens = new ArrayList<String>();
		for (String str : ss) {
			tokens.add(str);
		}
		Collections.reverse(tokens);
		String ret = "";
		for (String str : tokens) {
			ret += str+" ";
		}
		return ret.trim();
	}
	public String reverseWords1(String s){
		StringBuffer sb=new StringBuffer();
		int i=s.length()-1;
		while(i>=0){
			char c=s.charAt(i);
			if(c==' '){
				i--;
			}else{
				int j=i;
				char cc=s.charAt(j);
				while(cc!=' '){
					j--;
					cc=s.charAt(j);
				}
				sb.append(s.substring(j+1, i+1)+" ");
				i=j;
			}
		}
		if(sb.length()>1)
			sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
