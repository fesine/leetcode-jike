package leetcode.editor.cn;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1168 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //方法一，需要理解
        //if (l1 == null) {
        //    return l2;
        //}
        //else if (l2 == null) {
        //    return l1;
        //}
        //else if (l1.val < l2.val) {
        //    l1.next = mergeTwoLists(l1.next, l2);
        //    return l1;
        //}else{
        //    l2.next = mergeTwoLists(l1, l2.next);
        //    return l2;
        //}
        //方法二，背诵
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并剩余链表
        prev.next = l1 == null ? l2:l1;

        return preHead.next;

    }

    public static void main(String[] args) {
        MergeTwoLists main = new MergeTwoLists();
        MergeTwoLists.ListNode l1 = main.new ListNode(1);
        MergeTwoLists.ListNode l1_1 = main.new ListNode(2);
        MergeTwoLists.ListNode l1_2 = main.new ListNode(4);
        l1.next = l1_1;
        l1_1.next=l1_2;
        MergeTwoLists.ListNode l2 = main.new ListNode(1);
        MergeTwoLists.ListNode l2_1 = main.new ListNode(2);
        MergeTwoLists.ListNode l2_2 = main.new ListNode(3);
        l2.next=l2_1;
        l2_1.next = l2_2;
        ListNode result = main.mergeTwoLists(l1, l2);
        System.out.println();
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
