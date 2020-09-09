package leetcode.editor.cn;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class UniquePathsWithObstacles {
    /**
     * 使用二维数组，最下方一排和最右边一列，路径只有1，先填充完成
     * 然后依次递减
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //最后一行
        for (int i = m-1; i >= 0; i--) {
            if(obstacleGrid[i][n-1] == 1){
                dp[i][n - 1] = 0;
                break;
            }else{
                dp[i][n - 1] = 1;
            }
        }
        //最后一列
        for (int i = n-1; i >=0 ; i--) {
            if(obstacleGrid[m - 1][i] == 1){
                dp[m - 1][i] = 0;
                break;
            }else{
                dp[m - 1][i] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[1][1] = 1;
        obstacleGrid[1][1] = 1;
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
