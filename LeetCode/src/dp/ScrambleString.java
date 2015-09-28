package dp;

import java.util.Arrays;

public class ScrambleString {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ScrambleString ss = new ScrambleString();
    ss.isScramble("ab", "ba");
  }

  public boolean isScramble(String s1, String s2) {
    // 1. what is the feature of scramble string, same letter with same count
    if (s1 == null || s2 == null || s1.length() != s2.length())
      return false;
    // 2. why we need dp, not dfs
    if (s1.equals(s2))
      return true;
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    if (!Arrays.equals(arr1, arr2))
      return false;
    for (int i = 1; i < s1.length(); i++) { // i=1 is critical
      if (isScramble(s1.substring(0, i), s2.substring(0, i))
          && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
          && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
        return true;
    }
    return false;
  }


}
