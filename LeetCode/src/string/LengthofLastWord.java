package string;

import util.Util;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="hello world    f";
		Util.log(lengthOfLastWord(test));
	}
	public static int lengthOfLastWord(String s) {
        if(s.trim().length()==0)
        return 0;
        //remove more than one white spaces
        String[] strs=s.split("\\s+");
        return strs[strs.length-1].length();
    }
}
