//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 2655 👎 0


package leetcode.editor.cn;

/**
 * Java：买卖股票的最佳时机
 */
public class T121_BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new T121_BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //public int maxProfit(int[] prices) {
    //    int result = 0;
    //    // 单调栈
    //    Stack<Integer> stack = new Stack<>();
    //    for (int price : prices) {
    //        // 为空添加元素
    //        if (stack.isEmpty()) {
    //            stack.push(price);
    //            continue;
    //        }
    //        // 比较后一个元素是否比已经添加进来的元素值要大，计算差值暂存
    //        if (price > stack.peek()) {
    //            result = Math.max(result, price - stack.peek());
    //        } else {
    //            // 如果比前一个元素小，前一个元素出栈，新元素入栈
    //            stack.pop();
    //            stack.push(price);
    //        }
    //    }
    //    return result;
    //}

    public int maxProfit(int[] prices){
        // 暂存最小买入值
        int min = Integer.MAX_VALUE;
        // 暂存最大差值
        int max = 0;
        for (int price : prices) {
            // price与min比较
            if (price < min) {
                min = price;
                // 比较当前值与最小值的差值
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
