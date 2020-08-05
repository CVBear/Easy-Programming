package recursion.solution_0206;

/**
 * @Classname Solution
 * @Description
 * @Algorithm Recursion
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        // 1.定义指针
        ListNode prev = null;// [前一节点]当前指针前一个
        ListNode next = null;// [下一节点]当前指针下一个
        ListNode cur = head;// [当前指针]

        // 2.[循环]: 操作指针
        while (cur != null) {
            // [下一节点]
            next = cur.next;
            // [当前指针]方向重置prev<-next
            cur.next = prev;

            // [双指针]后移
            prev = cur;
            cur = next;
        }

        return prev;

    }
}


