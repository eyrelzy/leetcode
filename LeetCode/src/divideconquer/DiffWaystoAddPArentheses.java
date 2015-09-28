package divideconquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaystoAddPArentheses {
	public static void main(String[] args){
		String input = "0+1";
		System.err.println(new DiffWaystoAddPArentheses().diffWaysToCompute(input));
	}
	    public List<Integer> diffWaysToCompute(String input) {
	        List<Integer> result = new ArrayList<Integer>();
	        if (input == null || input.length() == 0) {
	            return result;
	        }
	        
	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            if (c != '+' && c != '-' && c != '*') {
	                continue;
	            }
	            
	            List<Integer> part1Result = 
	                diffWaysToCompute(input.substring(0, i));
	            List<Integer> part2Result = 
	                diffWaysToCompute(input.substring(i + 1, input.length()));
	            
	            for (Integer m : part1Result) {
	                for (Integer n : part2Result) {
	                    if (c == '+') {
	                        result.add(m + n);
	                    } else if (c == '-') {
	                        result.add(m - n);
	                    } else if (c == '*') {
	                        result.add(m * n);
	                    }
	                }
	            }
	        }
	        
	        if (result.size() == 0) {
	            result.add(Integer.parseInt(input));
	        }
	        
	        return result;
	    }
}
