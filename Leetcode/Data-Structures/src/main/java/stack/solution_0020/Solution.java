package stack.solution_0020;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname Solution
 * @Description 20.有效的括号
 * @DataStructure Stack[栈]
 * @Url https://leetcode-cn.com/problems/valid-parentheses/
 * @Compiler CVBear
 * @Date 2020/8/14 16:40
 */
class Solution {

    public boolean isValid(String s) {
        // 1.申请栈
        Deque<Character> stack = new ArrayDeque<>();

        // 2.转换
        char[] chs = s.toCharArray();

        // 3.迭代
        for (int i = 0; i < chs.length; i++) {
            // [入栈]: 如果是左括号入栈, 如果不是则就是match匹配字符
            char c = chs[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            // [空判]
            if (stack.size() == 0) {
                return false;
            }

            // [弹栈匹配]
            Character right = stack.pop();
            
            if (c == ')') {
                c = '(';
            } else if (c == '}') {
                c = '{';
            } else {
                c = '[';
            }

            if (right != c) {
                return false;
            }
        }

        // 4.[未匹配完成]
        if (stack.size() != 0) {
            return false;
        }

        // 5.[返回]
        return true;
    }
}