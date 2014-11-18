package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int evalRPN(String[] tokens) {
        int result=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(!isOperator(s)){
                stack.push(Integer.parseInt(s));
                result=Integer.parseInt(s);//case: "18"->18
            }else{
                int arg1=stack.pop();
                int arg2=stack.pop();
                if(s.equals("+")){
                    result=arg2+arg1;
                }else if(s.equals("-")){
                    result=arg2-arg1;
                }else if(s.equals("*")){
                    result=arg2*arg1;
                }else{
                    result=arg2/arg1;
                }
                stack.push(result);
            }
        }
        return result;
    }
    public boolean isOperator(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }
}
