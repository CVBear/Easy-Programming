package backtracking.solution_0017;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description 17.电话号码的字母组合
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Compiler CVBear
 * @Date 2020/8/11 15:11
 */
class Solution {

    // 字母映射
    private String letterMap[] = {
                " ",    //0 填充
                "",     //1 填充
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
    };

    // 结果列表
    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        // 1.初始化[结果]
        res = new ArrayList<String>();
        if (digits.equals("")) {
            return res;
        }

        // 2.[回溯]
        backtrack(digits, 0, "");
        return res;
    }

    // [回溯]
    private void backtrack(String digits, int index, String s) {
        // 1.[递归出口]
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        // 2.[获取数字]
        Character c= digits.charAt(index);

        // 3.[选择列表]
        String choices = letterMap[c - '0'];

        // 先4.1[下潜]到最后一层梦境 然后4.2迭代选择列表
        // 4.2[迭代]: 迭代梦境层选择列表 从底向上
        for (int i = 0; i < choices.length(); i++) {
            /** 伪代码蕴含的递归算法思想
             * s(digits[0...n-1]) = s(digits[1...n-1])
             * leter(digits[0]) + letter(digits[1]) + letter(digits[2...n-1])
             */
            // 4.1[下潜]
            backtrack(digits, index+1, s + choices.charAt(i));
        }

        // 5.[无需返回]
        return;
    }

    private static void printList(List<String> list){
        for(String s: list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        printList((new Solution()).letterCombinations("234"));
    }
}