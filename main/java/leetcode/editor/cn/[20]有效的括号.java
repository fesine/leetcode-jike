package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1725 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class IsValidBrackets {

    private Map<Character, Character> charMap = new HashMap<>();

    public IsValidBrackets(){
        this.charMap.put(')', '(');
        this.charMap.put(']', '[');
        this.charMap.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        //将s转换成char[]
        Stack<Character> stack = new Stack();
        //char[] chars = s.toCharArray();
        //for (int i = 0; i < chars.length; i++) {
        //    if(!checkChar(chars[i],stack)){
        //        return false;
        //    }
        //
        //}
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.charMap.containsKey(c)) {
                char check = stack.isEmpty() ? '#' : stack.pop();
                if (this.charMap.get(c) != check) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    private boolean checkChar(char aChar, Stack<Character> stack) {
        if (stack.isEmpty()) {
            stack.add(aChar);
            return true;
        }else{
            switch (aChar){
                case ')' :
                    if(stack.pop().equals('(')){
                        return true;
                    }else{
                        return false;
                    }
                case ']' :
                    if(stack.pop().equals('[')){
                        return true;
                    }else{
                        return false;
                    }
                case '}' :
                    if(stack.pop().equals('{')){
                        return true;
                    }else{
                        return false;
                    }
                default:
                    stack.add(aChar);
                    return true;
            }
        }

    }

    public static void main(String[] args) {
        String str = "()[]{{}}";
        IsValidBrackets main = new IsValidBrackets();
        boolean valid = main.isValid(str);
        System.out.println(valid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
