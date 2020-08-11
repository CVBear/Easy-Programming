package recursion.solution_0206;

/**
 * @Classname Solution
 * @Description 206.反转链表
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/reverse-linked-list/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {
        // 1.[终止条件]
        if (head == null || head.next == null) {
            return head;
        }

        // 2.[递归调用]: 终止时tail为最后一个,head为倒数第二个
        ListNode tail = reverseList(head.next);
        ListNode prev = head; // head相当于prev
        ListNode cur = head.next; // 实际的cur是head的下一个
        cur.next = prev; // ①反指
        prev.next = null; // ②
        return tail;
    }

    // 简化代码
    public ListNode reverseList2(ListNode head) {
        // 1.[终止条件]
        if (head == null || head.next == null) {
            return head;
        }

        // 2.[递归调用]: 终止时tail为最后一个,head为倒数第二个
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}


