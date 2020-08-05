package recursion.solution_0024;

/**
 * @Classname Solution2
 * @Description 迭代
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        // 1.定义[虚拟头结点]:
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 2.定义[连接节点]和[跳跃节点]
        ListNode linkNode = dummyHead;// [连接节点]: 上下层连通
        ListNode jumpNode = head;// [跳跃节点]:0 2 4 6 8...每次跳到需要交换的第一个位置

        // 3.[循环]
        while (jumpNode != null && jumpNode.next != null) {
            //[循环体]

            // 获取[交换节点]
            ListNode firstNode = jumpNode;
            ListNode secondNode =  jumpNode.next;

            // 交换(逻辑)
            jumpNode = secondNode.next;  // [下一跳]
            firstNode.next = jumpNode;   // 第一个节点指向[下一跳]
            secondNode.next = firstNode; // [第二节点]指向[第一节点]

            // [连接]与[下潜]
            linkNode.next = secondNode;
            linkNode = firstNode;
        }

        // 4.[返回]
        return dummyHead.next;
    }

    // 简化后
    public ListNode swapPairs2(ListNode head) {
        // 1.定义[虚拟头结点]:
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 2.定义[连接节点]和[跳跃节点]
        ListNode linkNode = dummyHead;// [连接节点]: 上下层连通

        // 3.[循环]
        while (head != null && head.next != null) {
            // [循环体]

            // 获取[交换节点]
            ListNode firstNode = head;
            ListNode secondNode =  head.next;
            head = secondNode.next;// [下一跳]

            // 交换(逻辑)
            firstNode.next = head;// 第一个节点指向[下一跳]
            secondNode.next = firstNode;// [第二节点]指向[第一节点]

            // [连接]与[下潜]
            linkNode.next = secondNode;
            linkNode = firstNode;
        }

        // 4.[返回]
        return dummyHead.next;
    }
}



