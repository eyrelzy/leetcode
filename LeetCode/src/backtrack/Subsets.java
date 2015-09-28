package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Subsets subset = new Subsets();
    int[] nums = {1,1};
    List<List<Integer>> ret = subset.subsetsWithDup(nums);
    System.out.print(ret);
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    helper(0, nums, new ArrayList<Integer>(), result);
    return result;
  }
//DFS
  private void helper(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
    result.add(new ArrayList<Integer>(temp));
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      helper(i + 1, nums, temp, result);
      temp.remove(temp.size() - 1);
    }
  }
  
  // iterative
  public List<List<Integer>> subsets1(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<Integer>());
    Arrays.sort(nums);
    
    for(int i : nums){
      List<List<Integer>> tmp = new ArrayList<List<Integer>>();
      for(List<Integer> subset : result){
        List<Integer> temp = new ArrayList<Integer>(subset);
        temp.add(i);
        tmp.add(temp);
      }
      result.addAll(tmp);
    }
    return result;
  }
  
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    helperDup(0, nums, new ArrayList<Integer>(), result);
    return result;
  }
//DFS
  private void helperDup(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
    result.add(new ArrayList<Integer>(temp));
    for (int i = start; i < nums.length; i++) {
      if(i>start && nums[i] == nums[i-1])
        continue;
      temp.add(nums[i]);
      helper(i + 1, nums, temp, result);
      temp.remove(temp.size() - 1);
    }
  }
  public List<List<Integer>> subsetsWithDup2(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Set<List<Integer>> results = new HashSet<List<Integer>>();
    results.add(new ArrayList<Integer>());
    Arrays.sort(nums);
    
    for(int i : nums){
      Set<List<Integer>> tmp = new HashSet<List<Integer>>();
      for(List<Integer> subset : results){
        List<Integer> temp = new ArrayList<Integer>(subset);
        temp.add(i);
        tmp.add(temp);
      }
      results.addAll(tmp);
    }
    for(List<Integer> val : results){
      result.add(val);
    }
    return result;
  }

}
