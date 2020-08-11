package binarysearch.solution_0034;

/**
 * @Classname Solution3
 * @Description [查询左右界]
 * @Algorithm BinarySearch
 * @TimeComplexity O(logn)
 * @SpaceComplexity O(1)
 * @Url https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 * @Compiler CVBear
 * @Date 2020/7/28 15:26
 */
public class Solution3 {

    // searchRange函数与Solution1相同
    public int[] searchRange(int[] nums, int target) {
        // 1.定义结果集
        int [] ans = {-1, -1};

        // 2.空判
        if (nums == null || nums.length == 0) {
            return ans;
        }

        // 3.[查询左边界]
        int leftIndex = indexOfLeft(nums, target);

        // 3.[检越]避免不在的情况和越界情况,因为left总是往mid+1的方向->
        if (leftIndex == nums.length || target != nums[leftIndex]) {
            return ans;
        }

        // 4.查询target的下一个元素的[左边界]索引-1即可
        int rightIndex = indexOfRight(nums, target);

        // 5.设置
        ans[0] = leftIndex;
        ans[1] = rightIndex;

        return ans;
    }

    //双闭区间版[l,r]
    private int indexOfLeft(int[] nums, int target) {
        // 1.[定左右]
        int l = 0;
        int r = nums.length-1;

        // 2.[定区间]
        while (l <= r) {
            // 3.[取中值]
            int mid = l + (r - l) /2;

            // 4.[裁剪与收缩]
            if (nums[mid] < target) {
                l = mid + 1;// [裁剪]后 [mid+1,r]
            } else {
                r = mid - 1;// [收缩] [l,mid-1] 不用担心[mid]错过
            }
        }

        return l;// r+1,r终止在l左侧
    }


    /**
     * 左闭右开版[l,r)
     * @param nums
     * @param target
     * @return
     */

    /**
     * 双闭区间版[l,r]
     * @param nums
     * @param target
     * @return
     */
    private static int indexOfRight(int[] nums, int target) {
        // 1.[定左右]
        int l = 0;
        int r = nums.length-1;

        // 2.[定区间]
        while (l <= r) {// [0,r]双指针可以在[0,n]移动
            // 3.[取中值]
            int mid = l + (r - l) /2;
            // 4.[裁剪与收缩]
            if (nums[mid] > target) {
                r = mid - 1;// [裁剪]后 [mid+1,r)
            } else {
                l = mid + 1;// 收缩[l,mid)实际移动范围[l,mid]
            }
        }

        return r;// r在l左侧,这种收缩行为
    }
}
