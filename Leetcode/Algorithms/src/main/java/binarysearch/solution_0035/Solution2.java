package binarysearch.solution_0035;

/**
 * @Classname Solution
 * @Description [查询左边界]
 * 左边界: 求[第一个]等于或者大于的数的位置
 * @Algorithm BinarySearch
 * @TimeComplexity O(logn)
 * @SpaceComplexity O(1)
 * @Url https://leetcode-cn.com/problems/search-insert-position/
 * @Compiler CVBear
 * @Date 2020/7/26 9:58
 *
 * 示例1
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class Solution2 {

    // 统一东部
    public int searchInsert(int[] nums, int target) {
        // 1.[定左右]
        int l = 0;
        int r = nums.length;

        // 2.[定区间]
        while (l < r) {//[l,r)
            int mid = l + (r - l)/2;
            if (nums[mid] < target) l = mid + 1;  // [裁剪] 更新区间[mid+1,r]
            else  r = mid;                        // 边界[收缩] 更新区间[l,mid]不是[l,mid)
        }

        // 3.[返回边界]
        return l;
    }
}
