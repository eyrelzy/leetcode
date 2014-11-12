package math;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberal {
/**
 * 计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
 * 
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new RomanNumberal().romanToInt("VI"));
	}
public int romanToInt(String s) {
	if(s==null)
		return -1;
	Map<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int ret=map.get(s.charAt(0));
    for(int i=1;i<s.length();i++){
    	
    	if(map.get(s.charAt(i))>map.get(s.charAt(i-1))){
    		ret-=map.get(s.charAt(i-1))*2;
    	}
    	ret+=map.get(s.charAt(i));
    }
    return ret;
    
    
    
    }

}
