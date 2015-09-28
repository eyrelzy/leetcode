package dp;

public class BestTimetoBuyAndSellStock {
  // problem 1:
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
      return 0;
    int min_price = prices[0];
    int max_profit = 0;
    int[] opt = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      opt[i] = Math.max(opt[i - 1], prices[i] - min_price);
      min_price = Math.min(min_price, prices[i]);
      max_profit = Math.max(max_profit, opt[i]);
    }
    return max_profit;
  }

  // problem III
  public int maxProfit3(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int max_profit = 0;
    int[] left = new int[prices.length]; // 0...i
    int[] right = new int[prices.length]; // i...len

    int min = prices[0], max = prices[prices.length - 1];
    for (int i = 1; i < prices.length; i++) {
      left[i] = Math.max(left[i - 1], prices[i] - min); // sell or not at day ith
      min = Math.min(prices[i], min);
    }

    for (int i = prices.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], max - prices[i]); // buy or not at day ith
      max = Math.max(prices[i], max);

    }

    for (int i = 0; i < prices.length; i++) {
      max_profit = Math.max(max_profit, left[i] + right[i]);
    }
    return max_profit;
  }
}
