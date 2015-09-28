package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	public static void main(String[] args){
		String s = "catsanddog";
		Set<String>	dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		WordBreak2 wb=new WordBreak2();
		List<String> ret = wb.wordBreak2(s, dict);
		System.out.println(ret);

	}

	public List<String> wordBreak(String s, Set<String> dict) {
		// back track
		List<String> ret = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		helper(s, words, 0, dict, ret);
		return ret;
	}

	public void helper(String s, List<String> words, int index,
			Set<String> dict, List<String> ret) {
		if (index == s.length()) {
			String sentence = "";
			for (String w : words) {
				sentence += " " + w;
			}
			ret.add(sentence.substring(1));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			String w = s.substring(index, i + 1);
			if (dict.contains(w)) {
				words.add(w);
				helper(s, words, i + 1, dict, ret);
				words.remove(words.size() - 1);
			}
		}
	}
	    public static List<String> wordBreak2(String s, Set<String> dict) {
	        List<String> dp[] = new ArrayList[s.length()+1];
	        dp[0] = new ArrayList<String>();
	        for(int i=0; i<s.length(); i++){
	            //i是开始位置
	            if( dp[i] == null ) continue; //前面的部分必须是可以匹配的
	            for(String word:dict){
	                int len = word.length();
	                int end = i+len;
	                if(end > s.length()) continue;
	                if(s.substring(i,end).equals(word)){
	                    if(dp[end] == null){
	                        dp[end] = new ArrayList<String>();
	                    }
	                    dp[end].add(word);//记录上一个位置
	                }
	            }
	        }
	        System.out.println(Arrays.toString(dp));
	        List<String> ans = new LinkedList<String>();
	        if(dp[s.length()] == null) return ans; 
	        ArrayList<String> tmp = new ArrayList<String>();
	        dfsStringList(dp,s.length(),ans, tmp);
	        return ans;
	    }

	    public static void dfsStringList(List<String> dp[],int end,List<String> res, ArrayList<String> tmp){
	        if(end <= 0){
	            String ans = tmp.get(tmp.size()-1);
	            for(int i=tmp.size()-2; i>=0; i--)
	                ans += (" " + tmp.get(i) );
	            res.add(ans);
	            return;
	        }
	        for(String str:dp[end]){
	            tmp.add(str);
	            dfsStringList(dp,end-str.length(), res, tmp);
	            tmp.remove(tmp.size()-1);
	        }
	    }
	
	}
