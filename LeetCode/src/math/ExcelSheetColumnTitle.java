package math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle esct=new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(53));
	}
	 public String convertToTitle(int n) {
	        String ret="";
	        do{
	            int digit=(n-1)%26;
	            char c=(char) ('A'+digit);
	            ret=c+ret;
	            n=(n-1)/26;
	        }while(n>0);
	        return ret;
	    }

}
