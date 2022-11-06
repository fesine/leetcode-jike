package leetcode.editor.cn;

import java.util.Scanner;

/**
 * 小明有一串小写字母组成的字符串
 * 小红有一串比小明长的同样小写字母组成的字符串
 * 输入一个数表示小红最多能替换多少个字符
 * 求小红最少替换多少次字符可以包含小明的字符串，如果替换次数大于限定次数着返回0
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/28
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/28
 */
public class MinReplaceStringTimes {

    private int solution(String a,String b,int times){
        if (a.length() >= b.length()) {
            return 0;
        }
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (a.charAt(i - 1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        int c = m-max;
        return c > times ? 0:c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int c = scanner.nextInt();
        int solution = new MinReplaceStringTimes().solution(a, b, c);
        System.out.println(solution);
    }
}
