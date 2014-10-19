package dp;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

当我们爬最后一步的时候，是两种情况：
1. 爬一步
2. 爬两步
把以上方式全部加一起，就是总的方案的个数
 * */
public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs1(9));
		System.out.println(climbStairs2(9));
	}

	// DP 动态规划问题 dynamic problem
	public static int climbStairs1(int n) {
		// no odd or even
		// 空间换时间
		int[] data = new int[n + 1];

		data[0] = 0;
		data[1] = 1;
		if (n >= 2)
			data[2] = 2;
		for (int i = 3; i <= n; i++) {
			data[i] = data[i - 1] + data[i - 2];
		}
		return data[n];

	}

	// follow-up
	public static int climbStairs3(int n) {
		// 2014-2-10 update
		if (n < 4)
			return n;
		int a = 2, b = 3, c = 5;
		for (int i = 5; i <= n; i++) {
			a = c;
			c = b + c;
			b = a;
		}
		return c;

	}

	public static int climbStairs2(int n) {
		// no odd or even
		// fibonacci seq
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}
}
