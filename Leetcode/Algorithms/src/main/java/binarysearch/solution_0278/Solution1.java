package solution_0278;/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * @Classname Solution1
 * @Description [查询左边界]
 * @Strategy Decrease and Conquer
 * @Algorithm BinarySearch
 * @Url https://leetcode-cn.com/problems/first-bad-version/
 * @Compiler CVBear
 * @Date 2020/7/26 19:08
 */
public class Solution1 {
    public int firstBadVersion(int n) {
        // 1.[定左右],范围: [0,n]
        int l = 0;
        int r = n;

        // 2.[定区间]查询左边界
        while (l <= r) {

            // 3.[取中值]
            int mid = l + (r-l)/2;

            // 4.[裁剪与收缩]: 减掉无效区间即不是解的部分
            if (!isBadVersion(mid)) {
                l = mid + 1;// 减掉无效区间[l,mid]后更新有效区间区间为[mid+1,r]
            } else {
                r = mid - 1;// 将右边界收缩下一轮区间[l,mid-1]不用担心错过[mid]因为最后l会+1刚好落在你想找的位置
            }
        }

        return l;
    }

    // 仅仅为了不报错这个不正确
    boolean isBadVersion(int version){return true;}
}

