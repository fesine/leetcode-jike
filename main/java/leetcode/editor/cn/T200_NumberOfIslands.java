//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1980 👎 0


package leetcode.editor.cn;

/**
 * Java：岛屿数量
 */
public class T200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new T200_NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[4][4];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};
        solution.numIslands(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * x y移动的四个方向
         */
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        char[][] g;

        public int numIslands(char[][] grid) {
            int num = 0;
            g = grid;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] == '0') {
                        continue;
                    }
                    num += sink(i, j);
                }
            }
            return num;
        }

        private int sink(int i, int j) {
            if (g[i][j] == '0') {
                return 0;
            }
            // 置0
            g[i][j] = '0';
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                    if (g[x][y] == '0') {
                        continue;
                    }
                    sink(x, y);
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
