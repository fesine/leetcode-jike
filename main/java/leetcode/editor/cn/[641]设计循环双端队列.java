package leetcode.editor.cn;
//设计实现双端队列。
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 48 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {


    /**
     * 操作次数 1-1000
     */
    volatile int mod;

    /**
     * 队列大小
     */
    volatile int capacity;

    volatile int size;

    private MyNode node;

    /**
     * 头结点
     */
    private MyNode head;

    /**
     * 尾结点
     */
    private MyNode rear;





    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 1 || k > 1000) {
            throw new RuntimeException("容量范围在1-1000内");
        }
        this.capacity = k;

    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if (isEmpty()) {
            node = new MyNode(value);
            this.head = node;
            this.rear = node;
            node.prev = node;
            node.next = node;
        }else{
            if (mod >= 1000) {
                return false;
            }
            //添加到头结点,暂存当前结点
            //创建新结点
            node = new MyNode(value);
            node.next=this.head;
            this.head.prev = node;
            //将暂存节点的上一节点设置为新结点
            this.head = node;
        }
        size++;
        mod++;
        return true;

    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            node = new MyNode(value);
            this.rear = node;
            this.head = node;
            node.prev = node;
            node.next = node;
        } else {
            if (mod >= 1000) {
                return false;
            }
            //创建新结点
            node = new MyNode(value);
            node.prev = this.rear;
            this.rear.next = node;
            //将暂存节点的上一节点设置为新结点
            this.rear = node;
        }
        size++;
        mod++;
        return true;

    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (mod >= 1000) {
            return false;
        }
        //删除头结点，即将当前结点指向头结点的下一结点，并将下一节点设置为头结点
        node = this.head.next;
        this.head = node;
        size--;
        mod++;
        return true;


    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (mod >= 1000) {
            return false;
        }
        //删除尾结点，即将当前结点指向尾结点的上一结点，并将上一节点设置为尾结点
        node = this.rear.prev;
        this.rear = node;
        size--;
        mod++;
        return true;

    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.head.val;

    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.rear.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;

    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    private class MyNode{
        /**
         * 元素值 1-1000
         */

        int val;

        /**
         * 前结点
         */
        MyNode prev;

        /**
         * 后结点
         */
        MyNode next;

        MyNode (int val){
            this.val = val;
        }
    }

    /**
     * ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront",
     * "insertFront","getRear","getFront","getFront","deleteLast","getRear"]
     * [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
     * [null,true,true,7,true,7,true,3,9,9,true,0]
     * [null,true,true,7,true,7,true,0,9,9,true,7]
     * @param args
     */
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        System.out.println(circularDeque.insertFront(7));                    // 返回 true
        System.out.println(circularDeque.insertLast(0));
        System.out.println(circularDeque.getFront());   // 返回 4// 返回 true
        System.out.println(circularDeque.insertLast(3));                   // 返回 true
        System.out.println(circularDeque.getFront());   // 返回 4// 返回 true
        System.out.println(circularDeque.insertFront(9));                    // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.getFront());                // 返回 2
        System.out.println(circularDeque.getFront());                // 返回 2
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.getRear());                    // 返回 true

    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
