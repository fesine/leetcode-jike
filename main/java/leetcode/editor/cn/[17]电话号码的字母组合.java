package leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 834 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        search("",digits,0,map,result);

        return result;

    }

    private void search(String s, String digits, int i, Map<Character, String> map, List<String> result) {
        //退出条件
        if(i == digits.length()){
            result.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            //递归 i表示level，s+letters.charAt(j) 处理当前数据
            search(s+letters.charAt(j),digits,i+1,map,result);
        }
        //清空
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("23");
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
