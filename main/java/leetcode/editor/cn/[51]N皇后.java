package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 507 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolveNQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //生成棋盘
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board,0);
        return res;
    }

    private void backtrack(String[][] board, int row) {
        //退出条件
        if(board.length == row){
            res.add(getStrings(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if(!isValid(board,row,col)){
                continue;
            }
            //选择
            board[row][col] = "Q";
            //下转
            backtrack(board,row+1);
            //取消选择
            board[row][col] = ".";
        }
    }

    private List<String> getStrings(String[][] board) {
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = Arrays.toString(board[i]).replace(",", "");
            sub.add(s.substring(1,s.length()-1));
        }
        return sub;
    }

    /**
     * 判断是否合法
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        //检查列是否有Q
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        //检查右上方是否有Q
        for (int i =row -1,j=col+1; i>=0 && j< n ;i--,j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        //检查左上方是否有Q
        for (int i =row -1,j=col-1; i>=0 && j>=0 ;i--,j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(8);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
