package bit;

public class SingleNumber2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,5,4,4,4,5,5};  
		System.out.println(singleNumber(A));
		System.out.println(16>>3);
	}

	public static int singleNumber(int[] A) {  
        // 创建一个长度为32的数组countsPerBit，  
        // countsPerBit[i]表示A中所有数字在i位出现的次数  
        int[] countsPerBit = new int[32]; //all the bit 
        int result = 0;  
        for(int i=0; i<32; i++){  
            for(int j=0; j<A.length; j++){  
                if(((A[j] >> i) & 1) == 1){//to see if it is one in this ith bit position
                    countsPerBit[i] = (countsPerBit[i] + 1) % 3;  
                }  
            }
            //now coutsPerBit[i] is the sum left with the single number
            //<<i, is to recover from >>i
            //here we have sth like 1000+100+1
            result |= (countsPerBit[i] << i);  //same as result+=(countPerBit[i]<<i)
        }  
        return result;  
    }  
}
