package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "", "" };
		Anagrams an = new Anagrams();
		System.out.println(an.anagrams(strs).size());
	}

	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] carr = strs[i].toCharArray();
			Arrays.sort(carr);
			String s = String.valueOf(carr);
			List<String> lst = new ArrayList<String>();
			lst.add(strs[i]);
			System.out.println(Arrays.toString(carr)+"s"+s);
			if (!hm.containsKey(s))
				hm.put(s, lst);
			else {
				hm.get(s).add(strs[i]);
			}
		}

		Iterator iter = hm.values().iterator();
		while (iter.hasNext()) {
			ArrayList<String> item = (ArrayList<String>) iter.next();
			if (item.size() > 1)
				res.addAll(item);
		}
		return res;
	}
}
