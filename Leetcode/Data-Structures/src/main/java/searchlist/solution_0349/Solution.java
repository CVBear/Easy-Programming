package searchlist.solution_0349;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @Classname Solution
 * @Description 349.两个数组的交集
 * @DataStructure 查找表[Set]
 * @Url https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Compiler CVBear
 * @Date 2020/8/24 11:33
 */
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 1.特判
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        // 2.数组添加至set1
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }

        // 3.获取交集
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }

        // 4.处理返回值
        int[] resArr = new int[set2.size()];
        int index = 0;
        for (int value : set2) {
            resArr[index++] = value;
        }

        return resArr;
    }
}