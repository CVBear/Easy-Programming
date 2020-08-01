package binarysearch.framework.left;

/**
 * @Classname BinarySearch1
 * @Description [查询左边界]闭区间版
 * @Compiler CVBear
 * @Date 2020/7/28 23:24
 */
public class BinarySearch1 {

    public int indexOfLeft(int[] nums, int target) {
        // 1.[定左右]
        int left = 0;
        int right = nums.length-1;

        // 2.[定区间]
        while (left <= right) {//[l,r]
            // 3.[取中值]
            int mid = left + (right - left)/2;
            // 4.[进退三则]
            if (target > nums[mid]) left = mid + 1;        // [mid+1,r] 大中则进
            else if (target < nums[mid]) right = mid - 1;  // [l,mid-1] 小中则退
            else right = mid -1;                           // [r=mid-1] 等中则退
        }

        // 5.[检越]
        if (left >= nums.length || nums[left] != target) return -1;

        // 6.[返边界]
        return left;
    }

}
