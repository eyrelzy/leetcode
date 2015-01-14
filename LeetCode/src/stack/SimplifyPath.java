package stack;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath sp=new SimplifyPath();
		String path="/home/";
		String ret=sp.simplifyPath(path);
		System.out.println(ret);
	}
	 public String simplifyPath(String path) {
	        String ret="";
	        String[] strs=path.split("/");
	        Stack<String> stack= new Stack<String>();
	        for(int i=0;i<strs.length;i++){
	            String s=strs[i];
	            if(s.equals(".")||s.equals("")){
	                continue;
	            }else if(s.equals("..")){
	            	if(!stack.isEmpty())
	            		stack.pop();
	            }else{
	                stack.push(s);
	            }
	        }
	        if(stack.isEmpty()){
	        	return "/";
	        }
	        while(!stack.isEmpty()){
	            ret="/"+stack.pop()+ret;
	        }
	        return ret;
	    }

}
