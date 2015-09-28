package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums.length == 0)
      return result;

    backtrack(0, nums, new ArrayList<Integer>(), result);

    return result;
  }

  private void backtrack(int index, int[] nums, List<Integer> temp, List<List<Integer>> result) {
    if (index == nums.length) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    int n = nums[index];
    for (int pos = 0; pos <= temp.size(); pos++) {
      List<Integer> copy = new ArrayList<Integer>(temp);
      copy.add(pos, n);
      backtrack(index + 1, nums, copy, result);
    }
  }
}
