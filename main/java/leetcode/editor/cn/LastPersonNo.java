package leetcode.editor.cn;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/27
 */
public class LastPersonNo {

    private int solution(int n,int k){
        Node node = init(n);



        return iter(node,k,n);

    }

    private int iter(Node node ,int k,int n){
        Node temp = node;
        int count = n;
        //if (temp.next == temp) {
        //    return temp.val;
        //}
        if (count == k - 1) {
            for (int i = 0; i < count; i++) {
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();
            return 0;
        }
        for (int i = 1; i <= k-1; i++) {
            if(i == k-1){
                temp.next = temp.next.next;
                count--;
            }else{
                temp = temp.next;
            }
        }
        return iter(temp.next,k,count);
    }

    private Node init(int n){
        if (n <= 0) {
            throw new RuntimeException("节点数量不可小于1。");
        }
        Node head = new Node(1);
        if (n == 1) {
            return head;
        }
        Node temp = head;
        for (int i = 2; i <= n; i++) {
            Node next = new Node(i);
            temp.next = next;
            temp = next;
            if (i == n) {
                next.next = head;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int solution = new LastPersonNo().solution(10,3);
        //System.out.println(solution);
    }


}

class Node {

    int val;

    Node next;

    public Node(int val){
        this.val = val;
    }

}
