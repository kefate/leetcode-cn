package interview.primary.array;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *
 * @author kefate
 * @date 2020/3/6
 */
public class TradeStoke2 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] price2 = new int[]{1, 2, 3, 4, 5};
        int[] price3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(price1));
        System.out.println(maxProfit(price2));
        System.out.println(maxProfit(price3));

        int[] badCase = new int[]{2, 2, 5};
        System.out.println(maxProfit(badCase));
    }
}
