package greedy;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation gs = new GasStation();
		int[] gas = { 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
				81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96,
				97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
				47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
				63, 64, 65, 66 };
		int[] cost = { 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
				41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56,
				57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72,
				73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
				89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5,
				6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
				23, 24, 25, 26 };
		int[] gas1 = { 2, 3, 1 };
		int[] cost1 = { 3, 1, 2 };
		System.out.println(gas.length);
		System.out.println(gs.canCompleteCircuit2(gas1, cost1));

	}

	// STILL HAVE SOME BUGS ON SOME CASES
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int tmp = 0, ret = 0, sum = Integer.MAX_VALUE;
		for (int i = 0; i < gas.length; i++) {
			tmp += gas[i] - cost[i];
			gas[i] = gas[i] - cost[i];
			if (sum >= gas[i]) {
				ret = i;
				sum = gas[i];
			}
		}
		if (tmp >= 0)
			return (ret + 1) % gas.length;
		else
			return -1;
	}

	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int tmp = 0, ret = 0, sum = 0;
		for (int i = 0; i < gas.length; i++) {
			gas[i] = gas[i] - cost[i];
			sum += gas[i];

			if (gas[i] > tmp) {

				ret = i;
				tmp = gas[i];
			}
		}
		System.out.println(gas[74]);
		if (sum >= 0)
			return ret;
		else
			return -1;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] tmp = new int[gas.length + 1];
		int i = 0;
		for (int j = 0; j < gas.length; j++) {
			tmp[0] = gas[j];
			for (i = 0; i < gas.length; i++) {
				if (tmp[i] >= cost[i]) {
					tmp[i + 1] = tmp[i] - cost[i] + gas[(i + 1) % gas.length];
				} else
					break;
			}
			if (i == gas.length) {
				return j;
			}
		}
		return -1;
	}
}
