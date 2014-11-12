package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static List<List<Integer>> combine(int n, int k) {
        //a classical backtrack problem, you have to backtrack to orignal state with dfs.
        List<List<Integer>> combresult=new ArrayList<List<Integer>>();
        helper(n,k,combresult, new ArrayList<Integer>(), 1);
        return combresult;
        
    }
    public static void helper(int n, int k, List<List<Integer>> combresult, List<Integer> result, int start){
        if(result.size()==k){
            combresult.add(result);
            return;
        }
        else{
            for(int i=start;i<=n;i++){
                result.add(i);
                helper(n,k,combresult, result, i+1);
                result.remove(result.size()-1);
            }
        }
        return;
    }

}
