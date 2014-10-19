package similar_consecutive_sum_one_loop_max_min;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */
public class BestTimetoBuyandSellStock1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	/**
	 * 保证后面的最大值减去前面的最小值， 因此后面的减去前面的，同时保证前面的时最小值，另一方面更新全局的最大值
	 * */
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){  
            return 0;  
        }
        int min=prices[0],max=0;
        for(int i=1;i<prices.length;i++){
            max=Math.max(prices[i]-min,max);
            min=Math.min(prices[i],min);
        }
        return max;
    }

}
