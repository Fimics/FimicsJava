package data2.stuucture.dp;

/**
 * 最大连续子序列和
 */
public class MaxSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int dp = nums[0];
		int max = dp;
		for (int i = 1; i < nums.length; i++) {
			if (dp <= 0) {
				dp = nums[i];
			} else {
				dp = dp + nums[i];
			}
			max = Math.max(dp, max);
		}
		return max;
	}

	/**
	 * dp[i]是以i结尾的连续子序列和
	 * @param nums
	 * @return
	 */
	static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			int prev = dp[i - 1];
			if (prev <= 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = prev + nums[i];
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
