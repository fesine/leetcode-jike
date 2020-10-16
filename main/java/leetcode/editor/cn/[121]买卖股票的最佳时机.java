package leetcode.editor.cn;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1240 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        return dp(prices);
    }

    /**
     * 暴力普通循环遍历数组
     * @param prices
     * @return
     */
    private int findMax(int[] prices) {
        int max = 0;
        //找出最低购入价格
        for (int i = 0; i < prices.length-1; i++) {
            int buy = prices[i];
            for (int j = i; j < prices.length; j++) {
                int sale = prices[j];
                if(sale - buy <= 0){
                    continue;
                }
                max = Math.max(max,sale-buy);
            }
        }
        return max;
    }

    private int dp(int[] prices){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(new MaxProfit().maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
