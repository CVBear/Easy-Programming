package binarysearch.solution_0035;

/**
 * @Classname Solution1
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
public class Solution1 {

    public int searchInsert(int[] nums, int target) {
        // 0.特判
        if(nums.length == 0) {
            return 0;
        }

        // 1.[定左右]
        int l = 0;
        int r = nums.length;

        // 2.[定区间]
        while (l < r) {//[lo,hi)
            int mid = l + (r - l)/2;
            if (target > nums[mid]) l = mid + 1;  // [mid+1,hi) [大中则进],V < target一定是不是解,比如示例1中 3 < 5一定不是解
            else if (target < nums[mid]) r = mid; // [lo,mid)   [小中则中]①,因为取mid-1会导致比如查询2[2,2)产生无效区间就查不到元素
            else r = mid;                         // [mid]      [等中则中]为什么不是[等中则返]因为如果有重复多元素的情况取到的中指一定不是则右边界需要继续收缩为什么不是mid-1同①
        }

        // 3.[返回边界]
        return l;
    }

}
