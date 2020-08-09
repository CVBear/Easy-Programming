package linkedlist.solution_0707;

/**
 * @Classname Solution2
 * @Description [双向链表]
 * @Url [707. 设计链表](https://leetcode-cn.com/problems/pascals-triangle-ii/)
 * @Compiler CVBear
 * @Date 2020/8/9 8:17
 */
public class Solution2 {
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}

class MyLinkedList2 {

    int size;// 元素个数
    ListNode dummyHead, dummyTail; // 哨兵节点 保证头尾添加和删除逻辑一致

    // 节点
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        dummyHead = new ListNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * O(n)
     */
    public int get(int index) {
        ListNode cur = dummyHead.next;

        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            return -1;
        }

        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * O(1)
     */
    public void addAtHead(int val) {
        dummyHead.next = new ListNode(val, dummyHead, dummyHead.next);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     * O(n)
     */
    public void addAtTail(int val) {
        ListNode pre = dummyHead;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = new ListNode(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * O(n)
     */
    public void addAtIndex(int index, int val) {
        ListNode pre = dummyHead;

        for (int i = 0; i < index && pre != null; i++) {
            pre = pre.next;
        }

        if (pre != null) {
            pre.next = new ListNode(val, pre, pre.next);
        }

        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        ListNode pre = dummyHead;
        for (int i = 0; i < index && pre != null; i++) {
            pre = pre.next;
        }

        if (pre != null && pre.next != null) {
            ListNode delNode = pre.next;
            pre.next = delNode.next;
            delNode = null;
        }
        size--;
    }

}
