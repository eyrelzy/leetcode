package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GrayCode gc = new GrayCode();
    List<Integer> result = gc.grayCode(2);
    System.out.print(1^0);
  }
  public static List<Integer> grayCode(int n) {
    List<Integer> code = new ArrayList<Integer>();
    code.add(0);
    genCodes(code,n,0,1<<n);
    return code;
}
public static void genCodes(List<Integer> code, int n, int curr, int size) {
    if(code.size()==size) return;
    for(int i=0;i<n;i++) {
        int mask = 1<<i;
        int el = (curr^mask);
        if(!code.contains(el)) {
            code.add(el);
            genCodes(code,n,el,size);
        }
    }
}
//}
//  public List<Integer> grayCode(int n) {
//    List<Integer> result = new ArrayList<Integer>();
//    if (n == 0)
//      return result;
//    helper("", result, n);
//    return result;
//  }
//
//  private void helper(String str, List<Integer> result, int n) {
//    if (str.length() == n) {
//      result.add(atoi(str));
//      return;
//    }
//    for (int i = 0; i < n; i++) {
//      helper(str + i, result, n);
//    }
//  }

//  private int atoi(String str) {
//    int result = 0;
//    for (int i = 0; i < str.length(); i++) {
//      result += (str.charAt(i) - '0') * Math.pow(2, str.length() - i - 1);
//    }
//    return result;
//  }
}
