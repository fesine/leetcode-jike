package leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4660 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbersList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //int a = l1.val;
        //int b = l2.val;
        //int c = a +b;
        //int temp = 0;
        //if(c/10 > 0){
        //    temp = c / 10;
        //    c = c % 10;
        //}
        //ListNode result = new ListNode(c);
        //while (l1.next != null && l2.next != null) {
        //    a = l1.next.val;
        //    b=l2.next.val;
        //    c = a+b+temp;
        //    if (c / 10 > 0) {
        //        temp = c / 10;
        //        c = c % 10;
        //    }else {
        //        temp = 0;
        //    }
        //    //链表没有继续增加
        //    ListNode nextNode = result;
        //    while (nextNode.next != null){
        //        nextNode = nextNode.next;
        //    }
        //    nextNode.next = new ListNode(c);
        //    l1 = l1.next;
        //    l2 = l2.next;
        //}
        ////说明其中有一个list已经为空
        //ListNode tmpNode = null;
        //if(l1.next != null){
        //    tmpNode = l1.next;
        //}else if (l2.next != null){
        //    tmpNode = l2.next;
        //}
        //while (tmpNode != null) {
        //    c = tmpNode.val + temp;
        //    if (c / 10 > 0) {
        //        temp = c / 10;
        //        c = c % 10;
        //    } else {
        //        temp = 0;
        //    }
        //    //链表没有继续增加
        //    ListNode nextNode = result;
        //    while (nextNode.next != null) {
        //        nextNode = nextNode.next;
        //    }
        //    nextNode.next = new ListNode(c);
        //    tmpNode = tmpNode.next;
        //}
        //if(temp > 0){
        //    ListNode nextNode = result;
        //    while (nextNode.next != null) {
        //        nextNode = nextNode.next;
        //    }
        //    nextNode.next = new ListNode(temp);
        //}
        //
        //return result;
        ListNode p = l1, q = l2, head = new ListNode(0);
        ListNode cur = head;
        int temp = 0;
        while (p != null || q != null) {
            int a,b,sum;
            a = p != null ? p.val:0;
            b = q != null ? q.val:0;
            sum = a +b + temp;
            temp = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(temp > 0){
            cur.next = new ListNode(temp);
        }

        return head.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbersList main = new AddTwoNumbersList();
        AddTwoNumbersList.ListNode l1 = main.new ListNode(2);
        AddTwoNumbersList.ListNode l1_1 = main.new ListNode(4);
        AddTwoNumbersList.ListNode l1_2 = main.new ListNode(6);
        l1.next = l1_1;
        l1_1.next = l1_2;
        AddTwoNumbersList.ListNode l2 = main.new ListNode(5);
        AddTwoNumbersList.ListNode l2_1 = main.new ListNode(6);
        AddTwoNumbersList.ListNode l2_2 = main.new ListNode(4);
        AddTwoNumbersList.ListNode l2_3 = main.new ListNode(9);
        AddTwoNumbersList.ListNode l2_4 = main.new ListNode(9);
        AddTwoNumbersList.ListNode l2_5 = main.new ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;
        l2_4.next = l2_5;
        ListNode listNode = main.addTwoNumbers(l1, l2);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
