package recursion.solution_0024;

/**
 * @Classname Solution1
 * @Description 24.两两交换链表中的节点
 * @Algorithm Recursion[递归]
 * @Url https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        // 1.[递归出口]: 终止条件
        if(head == null || head.next == null) {
            return head;
        }

        // 2.[递归体]: 交换(逻辑)
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 3.[连接]与[下潜]
        firstNode.next = swapPairs(secondNode.next);// 终止后[回溯]
        secondNode.next = firstNode;// [交换]

        return secondNode;
    }
}



