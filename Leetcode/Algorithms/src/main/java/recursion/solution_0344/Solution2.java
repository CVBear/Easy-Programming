package recursion.solution_0344;

/**
 * @Classname Solution
 * @Description [尾递归]反转字符串
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/reverse-string/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    public void reverseString(char[] s) {
        // 1.[定左右]
        int left = 0;
        int right = s.length - 1;
        // 2.[递归]
        recursion(s, left, right);
    }

    private void recursion(char[] s, int left, int right) {
        // 1.[递归出口]: 终止条件
        if (left >= right) {
            return;
        }

        // 2.[递归体]：交换(逻辑)
        char swap = s[left];
        s[left++] = s[right];
        s[right--] = swap;
        recursion(s, left , right);// [尾递归]: 递归出现在末尾！
    }
}
