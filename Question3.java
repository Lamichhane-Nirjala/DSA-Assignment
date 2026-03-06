public class Question3 {

    public static int maxProfit(int max_trades, int[] prices) {

        int n = prices.length;

        if (n == 0)
            return 0;

        int[][] dp = new int[max_trades + 1][n];

        for (int i = 1; i <= max_trades; i++) {

            int maxDiff = -prices[0];

            for (int j = 1; j < n; j++) {

                dp[i][j] = Math.max(dp[i][j - 1],
                        prices[j] + maxDiff);

                maxDiff = Math.max(maxDiff,
                        dp[i - 1][j] - prices[j]);
            }
        }

        return dp[max_trades][n - 1];
    }

    public static void main(String[] args) {

        int max_trades = 2;

        int[] prices = {2000, 4000, 1000};

        int profit = maxProfit(max_trades, prices);

        System.out.println("Maximum Profit: " + profit);
    }
}