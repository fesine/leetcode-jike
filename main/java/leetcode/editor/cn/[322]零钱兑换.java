package leetcode.editor.cn;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 867 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class CoinChange {
    int res = Integer.MAX_VALUE;
    int memo[];

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        //处理大于0的情况
        //return solution1(coins, amount);
        //return solution2(coins, amount);
        //return solution3(coins, amount);
        return solution4(coins, amount);


    }


    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    private int solution1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] < min ){
                    min= dp[i - coins[j]]+1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 :dp[amount];
    }

    /**
     * 动态规划2
     * @param coins
     * @param amount
     * @return
     */
    private int solution4(int[] coins, int amount) {
        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount+1];
        // 给dp赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0){
                    // dp[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],
                    // 这种操作要兑换的硬币数是 dp[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是dp[i]
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

                }
            }
        }
        return dp[amount] == amount + 1 ? -1 :dp[amount];
    }


    private int solution2(int[] coins, int amount) {
        //对coins排序
        Arrays.sort(coins);
        minCoins(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * 递归处理
     * @param coins
     * @param amount
     * @param index
     * @param count
     */
    private void minCoins(int[] coins, int amount, int index, int count) {
        //终止条件
        if(amount == 0){
            res = Math.min(res,count);
            return;
        }
        if(index < 0){
            return;
        }
        //处理当前层amount/coins[index]，兑换最大面值的最大数量
        for (int i = amount/coins[index]; i>=0 && i+count < res ; i--) {
            minCoins(coins,amount-(i*coins[index]),index-1,count+1);
        }
    }


    private int solution3(int[] coins, int amount) {
        memo = new int[amount];

        return findWay(coins, amount);
    }

    private int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        //记忆化处理，memo[n]已经赋值，则直接返回，不用继续循环
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //总金额-当前正在使用的硬币面值
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                // 加1是为了加上得到res结果的那个步骤中,兑换的一个硬币
                min = res + 1;
            }
            memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return memo[amount - 1];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 13;
        System.out.println(new CoinChange().coinChange(coins,amount));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
