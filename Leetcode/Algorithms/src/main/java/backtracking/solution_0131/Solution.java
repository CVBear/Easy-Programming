package backtracking.solution_0131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Classname Solution
 * @Description 131.分割回文串
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/palindrome-partitioning/
 * @Compiler CVBear
 * @Date 2020/8/11 15:11
 */
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();

        // 1.[定义结果值]
        List<List<String>> res = new ArrayList<>();

        // 2.[特判]
        if (len == 0) {
            return res;
        }

        // 3.[月光宝盒] stack
        Deque<String> path = new ArrayDeque<>();

        // 4.[回溯]
        backtrack(s, 0, len, path, res);
        return res;
    }

    private void backtrack(String s, int start, int end, Deque<String> path, List<List<String>> res) {
        // 1.[爱情的终点]: 将path(答案)存储起来
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 2.[迭代选择]
        for (int i = start; i < end; i++) {
           // 减枝
           if (!isPalindrome(s,start,i)) {
               continue;
           }

           // [选择(拿得起)]: 路径填充
           path.addLast(s.substring(start, i+1));
           backtrack(s, i+1, end, path, res);

           path.removeLast();
        }

    }

    private boolean isPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}