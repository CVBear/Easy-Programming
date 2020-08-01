package binarysearch.solution_0153;

/**
 * @Classname Solution
 * @Description [裁剪] [无效区间] 收缩[有效区间]
 * @Algorithm BinarySearch
 * @Url https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Compiler CVBear
 * @Date 2020/7/27 19:08
 */
class Solution {

    public int findMin(int[] nums) {
        // 0.空判
        if (nums == null || nums.length == 0) return -1;

        // 1.[定左右],范围: [0,x]
        int l = 0;
        int r = nums.length - 1;

        // 2.[定区间]允许双指针重合因此选择这种写法
        while (l <= r) {// [l,r]

            // 整个区间[l,r]呈现递增趋势则l就是[最小值]
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            // 3.[取中值]
            int mid = l + (r - l) / 2;

            //连续递增说明最小值不在这个区间排除掉
            if (nums[l] <= nums[mid]) {
                // [最小值]不在[l,mid]区间中设置下一次区间[mid+1,r]①
                l = mid + 1;
            } else {
                // [最小值]在[l,mid]区间中设置下一次区间[l,mid]②
                r = mid;
            }
        }

        return -1;
    }
}