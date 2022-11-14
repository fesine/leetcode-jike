//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 
// 👍 1555 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：N 皇后
 */
public class T51_NQueens {
    public static void main(String[] args) {
        Solution solution = new T51_NQueens().new Solution();
        // TO TEST
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 生成棋盘
            String[][] board = new String[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = ".";
                }
            }
            backtrack(board, 0);
            return result;
        }

        private void backtrack(String[][] board, int row) {
            if (row == board.length) {
                result.add(getString(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                // 判断合法性
                if (!isValid(board, row, col)) {
                    continue;
                }
                board[row][col] = "Q";
                backtrack(board, row + 1);
                board[row][col] = ".";
            }

        }

        private boolean isValid(String[][] board, int row, int col) {
            int n = board.length;
            // 检查列，当前行所有列的字符
            for (int i = 0; i < n; i++) {
                if ("Q".equals(board[i][col])) {
                    return false;
                }
            }
            // 检查右上角，row-1，col+1
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if ("Q".equals(board[i][j])) {
                    return false;
                }
            }
            // 检查左上角，row-1，col+1
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if ("Q".equals(board[i][j])) {
                    return false;
                }
            }
            return true;
        }

        private List<String> getString(String[][] board) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                // 去掉,
                String sub = Arrays.toString(board[i]).replace(",", "")
                        .replace(" ", "");
                // 去掉[]
                res.add(sub.substring(1, sub.length() - 1));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
