package leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 415 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            List<String> subs;
            //不存在添加
            if(!strMap.containsKey(String.valueOf(chars))){
                subs = new ArrayList<>();
                strMap.put(String.valueOf(chars), subs);
            }else{
                //存在则获取列表，并添加
                subs = strMap.get(String.valueOf(chars));
            }
            subs.add(strs[i]);
        }
        for (List<String> value : strMap.values()) {
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagram().groupAnagrams(strs);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
