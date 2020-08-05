package recursion.solution_0344;

/**
 * @Classname Solution
 * @Description [迭代]反转字符串
 * @Algorithm Iteration
 * @Url https://leetcode-cn.com/problems/reverse-string/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {

    public void reverseString(char[] s) {
        // 1.[定左右]
        int left = 0;
        int right = s.length - 1;
        // 2.[循环]
        while (left < right) {
            // [循环体]: 交换(逻辑)
            char swap = s[left];
            s[left++] = s[right];
            s[right--] = swap;
        }
    }
}
