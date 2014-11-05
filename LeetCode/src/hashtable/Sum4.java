package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ret=new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
            	//fix i and j value, and change k and l using method of 2Sum
            	//O(n^3)
                int k=j+1;
                int l=num.length-1;
                while(k<l){
                    int sum=num[i]+num[j]+num[k]+num[l];
                    if(sum==target){
                        List<Integer> sub=new ArrayList<Integer>();
                        sub.add(num[i]);
                        sub.add(num[j]);
                        sub.add(num[k]);
                        sub.add(num[l]);
                        if(hs.add(sub)){
                            ret.add(sub);
                        }
                        k++;
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ret;
	}

}
