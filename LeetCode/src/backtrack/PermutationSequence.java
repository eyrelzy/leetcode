package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps = new PermutationSequence();
		String ret = ps.getPermutation(3, 3);
		System.out.println(ret);
	}

	public int count;
	public String result;

	//TLE
	public String getPermutation(int n, int k) {
		count = 0;
		result = "";
		for (int i = 1; i <= n; i++) {
			StringBuffer sb = new StringBuffer(i);
			int visit[] = new int[n + 1];
			visit[i] = 1;
			sb.append(i);
			int num = 1;
			dfs(visit, sb, n, num, k);
		}
		return result;
	}

	public void dfs(int visit[], StringBuffer sb, int n, int num, int k) {
		if (num == n) {
			count++;
			if (count == k) {
				result = sb.toString();
				return;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (visit[i] == 0) {
				StringBuffer tempSb = new StringBuffer(sb);
				tempSb.append(i);
				visit[i] = 1;
				dfs(visit, tempSb, n, num + 1, k);
				visit[i] = 0;
			}
		}
	}
	//it's more than a backtracing problem, but a math problem.
//AC
	public String getPermutation2(int n, int k) {
	    //math problem.
	        k--;//to transfer it as begin from 0 rather than 1
	        
	        List<Integer> numList = new ArrayList<Integer>();  
	        for(int i = 1; i<= n; i++)
	            numList.add(i);
	        //number list
	       
	        int factorial = 1;    
	        for(int i = 2; i < n; i++)  
	            factorial *= i;
	        //(n-1)!
	        
	        StringBuilder res = new StringBuilder();
	        int times = n-1;
	        while(times>=0){
	            int indexInList = k/factorial;
	            res.append(numList.get(indexInList));  
	            numList.remove(indexInList);  
	            
	            k = k%factorial;//new k for next turn
	            if(times!=0)
	                factorial = factorial/times;//new (n-1)!
	            
	            times--;
	        }
	        
	        return res.toString();
	    }
}
