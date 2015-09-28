package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresss {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String test = "25525511135";
    RestoreIPAddresss rip = new RestoreIPAddresss();
    List<String> l = rip.restoreIpAddresses(test);
    System.out.println(l);
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    if (s.length() < 4)// cases
    {
      return result;
    }
    helper(s, 0, result, new String(), 4);
    return result;
  }

  private void helper(String s, int index, List<String> result, String temp, int cnt) {
    if (index == s.length() && cnt == 0) {
      result.add(temp);
      return;
    }
    if (cnt == 0 && index < s.length())
      return;

    for (int i = index; i < index + 3 && i < s.length(); i++) {
      String str = s.substring(index, i + 1);
      if (!isValid(str))
        break;
      if (cnt < 4) {
        helper(s, i + 1, result, temp + "." + str, cnt - 1);
      } else {
        helper(s, i + 1, result, temp + str, cnt - 1);
      }
    }
  }

  private boolean isValid(String str) {
    if (str.charAt(0) == '0' && str.length() > 1)
      return false;
    int num = Integer.parseInt(str);
    if (num <= 255 && num >= 0)
      return true;
    return false;
  }
}
