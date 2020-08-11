package recursion.solution_0021;

/**
 * @Classname Solution2.java
 * @Description 21.合并两个有序链表
 * @Algorithm Itreation[迭代] 虚拟头结点的妙用
 * @Url https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(-1);

        // 创建[移动指针]: 作用是[梦境连接]
        ListNode prevMove = dummyHead;

        //迭代
        while (l1 != null && l2 != null) {
            // [循环体]
            // 谁小[移动指针]指向谁
            if (l1.val < l2.val) {
                prevMove.next = l1;// [梦境连接]
                // [断开]
                l1 = l1.next;
            } else{
                prevMove.next = l2;// [梦境连接]
                // [断开]
                l2 = l2.next;
            }
            // [移动指针] [下潜] 进入下一层梦境
            prevMove = prevMove.next;
        }

        // [连接]未使用完的[有序]部分
        prevMove.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}
