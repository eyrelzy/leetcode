package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String test="25525511135";
	RestoreIPAddresss rip=new RestoreIPAddresss();
	List<String> l=rip.restoreIpAddresses(test);
	System.out.println(l);
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<String>();
		if (s.length() < 4)// cases
		{
			return ret;
		}
		rec(s, 0, ret, new String(), 0);
		return ret;
	}

	public void rec(String s, int index, List<String> ret, String item,
			int level) {
		if (level == 4 && index == s.length()) {
			ret.add(item);
			return;
		}
		if (index > s.length()) {
			return;
		}
		if (level == 4 && index < s.length()) {
			return;
		}
		for (int i = 1; i < 4 && (i + index <= s.length()); i++) {
			String str = s.substring(index, index + i);
			if (isValid(str)) {
				if (level == 0) {
					rec(s, index + i, ret, str, level + 1);
				} else
					rec(s, index + i, ret, item + "." + str, level + 1);
			}
		}

	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3)
			return false;
		int num = Integer.parseInt(str);
		if (str.charAt(0) == '0' && str.length() > 1)
			return false;
		if (num >= 0 && num <= 255)
			return true;
		return false;
	}
}
