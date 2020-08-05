package binarysearch.solution_0034;

/**
 * @Classname Solution2.java
 * @Description [查询左右界]
 * @Algorithm BinarySearch
 * @TimeComplexity O(logn)
 * @SpaceComplexity O(1)
 * @Url https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 * @Compiler CVBear
 * @Date 2020/7/28 15:26
 */
public class Solution2 {

    // searchRange函数与Solution1相同
    public int[] searchRange(int[] nums, int target) {
        // 1.定义结果集
        int [] ans = {-1, -1};

        // 2.空判
        if (nums == null || nums.length == 0) return ans;

        // 3.[查询左边界]
        int leftIndex = indexOfLeft(nums, target);

        // 3.[检越]避免不在的情况和越界情况,因为left总是往mid+1的方向->
        if (leftIndex == nums.length || target != nums[leftIndex]) {
            return ans;
        }

        // 如果3过了证明nums中肯定含有target
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
     * 技巧点：取右中位因为这种写法取左中位会导致[死循环]永远取不到[右边界]
     * @param nums
     * @param target
     * @return
     */
    private int indexOfRight(int[] nums, int target) {
        // 1.[定左右]
        int l = 0;
        int r = nums.length - 1;

        // 2.[定区间]
        while (l < r) {// [0,r)双指针可以在[0,n]移动

            // [检越] 本题不用
            //if (r >= nums.length || nums[nums.length-1] != nums[target]) return -1;

            // 3.[取中值]
            int mid = l + (r - l + 1) /2;// 技巧① 不获取[右中位值]则取不到右边界
            // 4.[裁剪与收缩]
            if (nums[mid] > target) {
                r = mid - 1;// [裁剪]后 [mid+1,r)
            } else {
                l = mid;    // [边界收缩]从左向右收缩更新区间为[l,mid)实际移动范围[l,mid]
            }
        }

        return l;// r 终止时[双指针重合]
    }

    /**
     * 不推荐的写法,由于r的初始值引起越界问题还需要增加多余的判断
     * @param nums
     * @param target
     * @return
     */
    private static int indexOfRight2(int[] nums, int target) {
        // 1.[定左右]
        int l = 0;
        int r = nums.length;

        // 2.[防止越界] 这里针对的情况如: [1] 1 返回[0,0]
        if (target > nums[r-1]) return nums.length;
        if (target <= nums[r-1]) return 0;

        // 2.[定区间]
        while (l < r) {// [0,r)双指针可以在[0,n]移动
            // 3.[取中值]
            int mid = l + (r - l + 1) /2;
            // 4.[裁剪与收缩]
            if (nums[mid] > target) {
                r = mid - 1;// [裁剪]后 [mid+1,r)
            } else {
                l = mid;    // 从左向右收缩更新区间为[l,mid)实际移动范围[l,mid]
            }
        }

        return l;// r 终止时[双指针重合]
    }
}
