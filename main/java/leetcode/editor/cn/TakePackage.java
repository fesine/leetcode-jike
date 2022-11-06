package leetcode.editor.cn;

/**
 * 司机最多有 N个箱子，可以一次装K的整数倍重量的货物
 * 给一个组数 M1 M2 M3 M4 …… 表示每个编号的货物重量
 * 每次拿的货物编号只能按顺序，比如 M1,M2,M3 不能M2,M4,M6
 * 求一共有多少种方法装货物
 * 输入
 *
 * 4 1
 * 1 2 3 4
 *
 * 输出
 *
 * 10
 * 输入
 *
 * 6 4
 * 1 2 3 4 5 6
 *
 * 输出
 *
 * 3
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/28
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/28
 */
public class TakePackage {

    private int solution(int m,int n){
        if(n ==0 || m == 0){
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int sum = i;
            if(sum % n == 0){
                count++;
            }
            for (int j = i+1; j <= m ; j++) {
                sum += j;
                if (sum % n == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int solution = new TakePackage().solution(6, 4);
        System.out.println(solution);
    }
}
