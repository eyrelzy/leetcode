package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Util;

public class CombinationSum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CombinationSum cs = new CombinationSum();
    int[] candidates = {8, 7, 4, 3};
    int target = 11;
    List<List<Integer>> arr = cs.combinationSum(candidates, target);
    Util.logDoubleIntegerList(arr);
  }

  // public List<List<Integer>> combinationSum(int[] candidates, int target) {
  // List<List<Integer>> res = new ArrayList<List<Integer>>();
  // if(candidates == null || candidates.length==0)
  // return res;
  // Arrays.sort(candidates);
  // helper(candidates,0,target,new ArrayList<Integer>(),res);
  // return res;
  // }
  //
  // private void helper(int[] candidates, int start, int target, List<Integer> item,
  // List<List<Integer>> res)
  // {
  // if(target<0)
  // return;
  // if(target==0)
  // {
  // res.add(new ArrayList<Integer>(item));
  // return;
  // }
  // for(int i=start;i<candidates.length;i++)
  // {
  // // if(i>0 && candidates[i]==candidates[i-1])
  // // continue;
  // item.add(candidates[i]);
  // helper(candidates,i,target-candidates[i],item,res);//here start == i
  // item.remove(item.size()-1);
  // }
  // }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(candidates);
    helper(0, 0, target, candidates, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper(int start, int sum, int target, int[] candidates, List<Integer> temp,
      List<List<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (sum + candidates[i] > target)
        break;
      temp.add(candidates[i]);
      helper(i, sum + candidates[i], target, candidates, temp, result);
      temp.remove(temp.size() - 1);
    }
  }



  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(candidates);
    helper2(0, 0, candidates, target, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper2(int start, int sum, int[] candidates, int target, List<Integer> temp,
      List<List<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1])
        continue;
      if (sum + candidates[i] > target)
        break;
      temp.add(candidates[i]);
      helper2(i + 1, sum + candidates[i], candidates, target, temp, result);
      temp.remove(temp.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper3(1, 0, k, n, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper3(int start, int sum, int k, int n, List<Integer> temp,
      List<List<Integer>> result) {
    if (sum == n && k == 0) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i <= 9; i++) {
      if (sum + i > n || k <= 0)
        break;
      temp.add(i);
      helper3(i + 1, sum + i, k - 1, n, temp, result);
      temp.remove(temp.size() - 1);
    }
  }

  // combinations
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper0(1, k, n, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper0(int start, int k, int n, List<Integer> temp, List<List<Integer>> result) {
    if (k == 0) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i <= n; i++) {
      temp.add(i);
      helper0(i + 1, k - 1, n, temp, result);
      temp.remove(temp.size() - 1);
    }
  }
}
