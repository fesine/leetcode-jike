package leetcode.editor.cn;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 622 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Stack<Integer> data;

    private Integer min = null;

    //private Stack<Integer> minData;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack();
        //minData = new Stack();
    }
    
    public void push(int x) {
        //data.push(x);
        //if (minData.isEmpty() || x <= minData.peek()) {
        //    minData.push(x);
        //}
        if (min == null) {
            min = x;
        }else  if (x <= min) {
            //保存前面最小值
            data.push(min);
            //设置当前最小值
            min = x;
        }
        data.push(x);
    }
    
    public void pop() {
        if(data.isEmpty()){
            return;
        }
        //如果弹出的是最小值，将最小值下面一个元素弹出为当前最小值
        if (data.pop().equals(min)) {
            min = data.pop();
        }
        //if (data.pop().equals(minData.peek())) {
        //    minData.pop();
        //}

    }
    
    public int top() {
        return data.peek();

    }
    
    public int getMin() {
        //return minData.peek();
        return min;
    }

    public static void main(String[] args) {
        MinStack main = new MinStack();
        main.push(-2);
        main.push(0);
        main.push(-3);
        System.out.println(main.getMin());
        main.pop();
        System.out.println(main.top());
        System.out.println(main.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
