package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="[{}]";
		System.out.println(isValid(test));
	}
	//tricky
	public static boolean isValid(String s){
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		char[] chararray=s.toCharArray();
		Stack<Character> st=new Stack<Character>();
		for(char c:chararray){
			//只有是[,(,{才会放入栈中，否则会选择是否弹出，弹出不了就说明invalid
			if(map.keySet().contains(c)){
				st.push(c);
			}
			else if(map.values().contains(c)){
				if(!st.isEmpty()&&map.get(st.peek())==c){
					st.pop();
				}
				else{
					return false;
				}
			}
		}
		
		return st.isEmpty();
	}

}
