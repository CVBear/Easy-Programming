package binarysearch.solution_0278;/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * @Classname Solution2.java
 * @Description [查询左边界]
 * @Strategy Decrease and Conquer
 * @Algorithm BinarySearch
 * @Url https://leetcode-cn.com/problems/first-bad-version/
 * @Compiler CVBear
 * @Date 2020/7/26 19:08
 */
public class Solution2 {

    public int firstBadVersion(int n) {
        // 1.[定左右],范围: [0,n)
        int l = 0;
        int r = n;

        // 2.[定区间]查询左边界
        while (l < r) {// [l,r)如果区间为[l,数组长度]则会索引越界

            // 3.[取中值]
            int mid = l + (r-l)/2;

            // 4.[排除法]: 减掉无效区间即不是解的部分
            if (!isBadVersion(mid)) {
                l = mid + 1;
            } else {
                r = mid;// mid相较第一种写法往后移了一个位置因此不
            }
        }

        return l;// r也可
    }

    // 仅仅为了不报错这个不正确
    boolean isBadVersion(int version){return true;}
}

