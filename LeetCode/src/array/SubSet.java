package array;

import java.util.ArrayList;
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
	
	//dfs method:
	/**
	比如输入集合为［1，2，3］应当是这么运行，
	[]
	[1]
	[1,2]
	[1,2,3] //最底层子循环到头返回删去3，上一层的子循环也到头删去2
	          //而此时，这一层循环刚到2，删去后还可以添加一个3
	[1,3] //删除3，删除1
	[2]
	[2,3] //删除3，删除2
	[3]
	**/
	public List<List<Integer>> subsets1(int[] S) {  
	       List<List<Integer>> res = new ArrayList<List<Integer>>();  
	       List<Integer> tmp = new ArrayList<Integer>();  
	       Arrays.sort(S);  
	       res.add(tmp);
	       dfs(res,tmp,S,0);  
	       return res;  
	    }  
	      
    public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] S, int pos){  
//        for(int i=pos; i<=S.length-1;i++){  
//            tmp.add(S[i]);  
//            res.add(new ArrayList<Integer>(tmp));  
//            dfs(res,tmp,S,i+1);  
//            tmp.remove(tmp.size()-1);  
//        }  
        for(int i=pos; i<=S.length-1;i++){  
        	tmp.add(S[i]);  
        	res.add(new ArrayList<Integer>(tmp));  
        	dfs(res,tmp,S,i+1);  
        	tmp.remove(tmp.size()-1);
        	//去掉该词的时候，看看剩下的当前位置和下一位是不是一样的
        	//[1,2,2,2,2,2]
        	//[1,2]
        	//[1,3]
        	while(i<S.length-1 && S[i]==S[i+1]) 
        		i++;
        }  
    }
	 
}
