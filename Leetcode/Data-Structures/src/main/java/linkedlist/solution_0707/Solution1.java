package linkedlist.solution_0707;

/**
 * @Classname Solution1
 * @Description 707.设计链表
 * @DataStructure 链表[单向链表]
 * @Url https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @Compiler CVBear
 * @Date 2020/8/9 8:17
 */
public class Solution1 {
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

class MyLinkedList {

    int size;// 元素个数
    ListNode dummyHead; // 哨兵节点

    // 节点
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * O(n)
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = dummyHead;

        // 循环查找元素O(n)
        for (int i = 0; i <= index; i++) {// 注意i <= index
            cur = cur.next;
        }

        return cur.val;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * O(1)
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     * O(n)
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * O(index)
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        // 矫正
        if (index < 0) {
            index = 0;
        }

        ListNode pre = dummyHead;
        ListNode cur = null;

        // 循环找到pre前驱
        for (int i = 0; i < index; i++) {// 注意 i < index
            pre = pre.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * O(index)
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = dummyHead;

        // 循环找到该删除的节点的前驱 pre
        for (int i = 0; i < index; i++) {//注意 i < index
            pre = pre.next;
        }

        // 重置指针
        pre.next = pre.next.next;
        size--;
    }
}
