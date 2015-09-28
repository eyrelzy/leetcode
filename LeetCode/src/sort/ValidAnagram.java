package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		char[] sarr = s.toCharArray();
		Arrays.sort(sarr);
		char[] tarr = t.toCharArray();
		Arrays.sort(tarr);
		
		for(int i=0; i<sarr.length; i++){
			if(sarr[i] != tarr[i]){
				return false;
			}
		}
		return true;
	}
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                map.put(c, cnt+1);
            }else{
                map.put(c, 1);
            }
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                map.put(c, cnt-1);
            }else{
                return false;
            }
        }
        for(Integer ent : map.values()){
            if(ent!=0){
            	return false;
            }
        }
        return true;
    }
}
