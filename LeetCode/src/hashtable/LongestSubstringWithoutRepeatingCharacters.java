package hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring1(test));//12
		String test1="hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		System.out.println(lengthOfLongestSubstring1(test1));//12
		String test2="whtaciohordtqkvwcsgspqo";
		System.out.println(lengthOfLongestSubstring1(test2));//12
	}
	//why we need to have two pointers? here it is.
	//TLE
	public static int lengthOfLongestSubstring(String s) {
        char[] carr=s.toCharArray();
        int max_len=0,len=0,pre=0;
        HashSet<Character> hs=new HashSet<Character>();
        for(int i=0;i<carr.length;i++){
            if(hs.add(carr[i])){
                len++;
            }else{
            	
                len=0;
                hs=new HashSet<Character>();
                while(pre<i){
                	if(carr[pre]!=carr[i]){
                		pre++;
                	}else{
                		pre++;
                		break;
                	}
                }
                int temp=pre;
                while(pre<=i){
                	hs.add(carr[pre]);
                	pre++;
                	len++;
                }
                pre=temp;
//                System.out.println("pre:"+carr[pre]);
            }
            max_len=Math.max(max_len,len);
        }
        return max_len;
    }
	//time complexity? O(n)
	public static int lengthOfLongestSubstring1(String s) {
		boolean[] flag = new boolean[256];
		int result = 0;
		int j = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (flag[c]) {
				result = Math.max(result, i - j);
				for (int k = j; k < i; k++) {
					if (arr[k] == c) {
						j = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}	
			} else {
				flag[c] = true;
			}
		}
		result=Math.max(arr.length-j,result);
		return result;
	}
	//o(n^2) or O(2n)
	public static int lengthOfLongestSubstring2(String s) {
		//another idea is to store the last index of the occurrence
		char[] arr = s.toCharArray();
		int pre = 0;
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
	 
		return Math.max(pre, map.size());
		
	}

}
