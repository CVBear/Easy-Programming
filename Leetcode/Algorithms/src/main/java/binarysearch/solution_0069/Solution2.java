package binarysearch.solution_0069;

/**
 * @Classname Solution2.java
 * @Description [写法2]: 统一西部
 * @Strategy Decrease and Conquer
 * @Algorithm BinarySearch
 * @Url https://leetcode-cn.com/problems/sqrtx/
 * @Compiler CVBear
 * @Compiler CVBear
 * @Date 2020/7/28 9:24
 */
public class Solution2 {

    public static int mySqrt(int x) {
        // 1.[定左右],范围: [0,x]
        long l = 0;
        long r = x;

        // 这道题没有超出[左右边界]的情况因此没做[检越]

        // 2.[定区间]
        while (l < r) {// [l,r)
            // 3.[取(右)中值]
            long mid = l + (r - l + 1)/2;
            long midVal = mid * mid;

            // 4.[裁剪与收缩]
            if (midVal > x) {
                r = mid-1;// [裁剪]一定不是解的部分,更新有效区间为[l,mid-1),实际移动[l,mid-1]
            } else {
                l = mid;// [收缩]解存在的[有效区间]更新有效区间为[mid,r)不能[mid-1不然会漏掉[mid]
            }

        }

        // 5.[返边界]
        return (int)l;
    }
}
