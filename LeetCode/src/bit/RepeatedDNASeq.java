package bit;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASeq rd=new RepeatedDNASeq();
		String s="AAAAAAAAAAA";
		List<String> arr=rd.findRepeatedDnaSequences(s);
		System.out.println(arr.toString());
	}
	private static int SIZE=10;
    private static int[] dict_int=new int['T'+1];
    private static char[] dict_char={'A','C','G','T'};
    private static int[] POW=new int[SIZE];
     static {
	        for(int i = 0; i < SIZE; i++){
	            POW[i] = (int) Math.pow(4, i);
	        }

	        dict_int['A'] = 0;
	        dict_int['C'] = 1;
	        dict_int['G'] = 2;
	        dict_int['T'] = 3;
	    }
	public String fromIntToChar(int num){
	    char[] ret=new char[SIZE];
	    for(int i=0;i<SIZE;i++){
	        ret[i]=dict_char[num%4];
	        num=num/4;
	    }
	    return new String(ret);
	}
	public int fromCharToInt(char[] s, int index){
	    int num=0;
	    for(int i=0;i<SIZE;i++){
	        num+=dict_int[s[index+i]]*POW[i];
	    }
	    return num;
	}
    public List<String> findRepeatedDnaSequences(String s) {
       List<String> ret=new ArrayList<String>();
       char[] arr=s.toCharArray();
        final int max = fromCharToInt("TTTTTTTTTT".toCharArray(), 0);
	   int[] m = new int[max + 1];

        for(int i = 0; i <= arr.length - SIZE; i++){
            m[fromCharToInt(arr, i)]++;
        }
        for(int i=0;i<m.length;i++){
            if(m[i]>=2){
                ret.add(fromIntToChar(i));
            }
        }
       
       return ret;
    }

}
