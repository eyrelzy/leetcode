package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		Set<String> dic = new HashSet<String>();
		dic.add("hot");
		dic.add("dot");
		dic.add("dog");
		dic.add("lot");
		dic.add("log");
		System.out.println(wl.ladderLength("hit", "cog", dic));
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		//
		if (start.equals(end))
			return 0;
		dict.add(end);
		Queue<String> qs = new LinkedList<String>();
		qs.add(start);
		int length = 0;
		int in = 1, out = 0;
		while (!qs.isEmpty()) {
			String ss = qs.poll();
			System.out.println(ss);
			dict.remove(ss);
			out++;
			if (ss.equals(end)) {
				return length + 1;
			}
			// find similar from dict
			for (int i = 0; i < ss.length(); i++) {
				for (char c = 'a'; c < 'z'; c++) {
					char[] arr = ss.toCharArray();
					arr[i] = c;
					String temp = new String(arr);
					if (dict.contains(temp))
						qs.add(temp);
				}
			}
			if (in == out) {
				in = qs.size();
				out = 0;
				length++;
				System.out.println();
			}
			// length=level #
		}
		return 0;
	}

	public ArrayList<String> getSimilarNotVisitedString(String template,
			Set<String> hs) {

		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < template.length(); i++) {
			for (char c = 'a'; c < 'z'; c++) {
				char[] arr = template.toCharArray();
				arr[i] = c;
				String temp = new String(arr);
				if (hs.contains(temp))
					ret.add(temp);
			}
		}
		return ret;
	}

	public boolean compareTwoStrings(String a, String b) {
		int mismatch = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				mismatch++;
				if (mismatch > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
