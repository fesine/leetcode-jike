package leetcode.editor.cn;

/**
 * 3. n 个人分 m 个月饼，输出多个分配方案。
 * 要求 Max.1st - Max.2nd <= 3，Max(n-1) - Max(n) <= 3
 * 思路：
 * 假设，开始划分一次，划分了a个月饼，则此时n=n-1，m=m-a；
 * 再次划分时，划分了b个月饼，则此时n=n-1，m=m-b；
 * …
 * 最后第n次划分时，划分c个月饼，n=n-1=0，m=m-c=0；
 *
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/27
 */
public class MoonCakeSplit {

    private int solution(int n, int m) {
        if (n > m) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += dp(n - 1, m - i, i);
        }
        return count;
    }

    private int dp(int n, int m, int pre) {
        if(m < 0){
            return 0;
        }
        if ((m == 0 && n > 0) || (n == 0 && m > 0))
            return 0;
        else if (m == 0 && n == 0)
            return 1;
        int count = 0;
        for (int i = pre; i <= pre + 3; i++) {
            count += dp(n - 1, m - i, i);
        }
        return count;
    }

    public static void main(String[] args) {
        int solution = new MoonCakeSplit().solution(3, 8);
        System.out.println(solution);
    }
}
