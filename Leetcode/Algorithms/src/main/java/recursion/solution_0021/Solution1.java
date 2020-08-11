package recursion.solution_0021;

/**
 * @Classname Solution1
 * @Description 21.合并两个有序链表
 * @Algorithm Recursion[递归]
 * @Url https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    // 思想就是 阶段①|谁[空]谁[不返] 阶段②|谁有序谁[返回] 阶段③|谁小谁[有序]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.谁[空]谁[不返]
        if (l1 == null) {
            return l2;
        }

        //2.谁[空]谁[不返]
        if (l2 == null) {
            return l1;
        }

        // 谁小谁[断开] 谁大谁[保持], 谁小谁[返回]
        // [不变式]: 梦境中不变的逻辑
        if (l1.val < l2.val) {
            // [梦境连接] 与 [下潜]
            l1.next = mergeTwoLists(l1.next, l2);// [断开] 与 [保持]
            return l1;
        } else{
            // [梦境连接] 与 [下潜]
            l2.next = mergeTwoLists(l1, l2.next);// [保持] 与 [断开]
            return l2;
        }
    }
}
