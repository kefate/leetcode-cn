package interview.primary.array;

import java.util.ArrayList;
import java.util.List;

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
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 删除相邻的重复元素
        List<Integer> removeRepeatPrices = new ArrayList<>();
        removeRepeatPrices.add(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] != prices[i - 1]) {
                removeRepeatPrices.add(prices[i]);
            }
        }
        if (removeRepeatPrices.size() == 1) {
            return 0;
        }
        if (removeRepeatPrices.size() == 2) {
            int dif = removeRepeatPrices.get(1) - removeRepeatPrices.get(0);
            return Math.max(dif, 0);
        }

        // 元素个数大于2，设置极大/小值标识
        boolean[] maxFlag = new boolean[removeRepeatPrices.size()];
        boolean[] minFlag = new boolean[removeRepeatPrices.size()];
        setMaxMinFlag(removeRepeatPrices, maxFlag, minFlag);


        // true：下一步只能买，false：下一步只能卖
        boolean buySaleFlag = true;
        int low = 0, high = 0;
        int profit = 0;
        for (int i = 0; i < removeRepeatPrices.size(); i++) {
            if (buySaleFlag && minFlag[i]) {
                low = removeRepeatPrices.get(i);
                buySaleFlag = false;
            } else if (!buySaleFlag && maxFlag[i]) {
                high = removeRepeatPrices.get(i);
                buySaleFlag = true;
                profit += high - low;
            }
        }
        return profit;
    }

    private static void setMaxMinFlag(List<Integer> removeRepeatPrices, boolean[] maxFlag, boolean[] minFlag) {
        for (int i = 0; i < removeRepeatPrices.size(); i++) {
            minFlag[i] = false;
            maxFlag[i] = false;
            if (i == 0) {
                if (removeRepeatPrices.get(i) < removeRepeatPrices.get(i + 1)) {
                    minFlag[i] = true;
                } else {
                    maxFlag[i] = true;
                }
                continue;
            }
            if (i == removeRepeatPrices.size() - 1) {
                if (removeRepeatPrices.get(i) < removeRepeatPrices.get(i - 1)) {
                    minFlag[i] = true;
                } else {
                    maxFlag[i] = true;
                }
                continue;
            }
            if (removeRepeatPrices.get(i) < removeRepeatPrices.get(i - 1)
                    && removeRepeatPrices.get(i) < removeRepeatPrices.get(i + 1)) {
                minFlag[i] = true;
            } else if (removeRepeatPrices.get(i) > removeRepeatPrices.get(i - 1)
                    && removeRepeatPrices.get(i) > removeRepeatPrices.get(i + 1)) {
                maxFlag[i] = true;
            }
        }
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
