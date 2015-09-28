package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    helper(n, n, n, "", result);
    return result;
  }

  private void helper(int left, int right, int n, String str, List<String> result) {
    if (str.length() / 2 == n && left == 0 && right == 0) {
      result.add(str);
      return;
    }
    if (left < 0 || right < 0 || left > right) {
      // Avoid cases, like ")("
      return;
    }
    helper(left - 1, right, n, str + '(', result);
    helper(left, right - 1, n, str + ')', result);
  }
}
