package binarysearch.framework.left;

/**
 * @Classname BinarySearch3
 * @Description [查询左边界]开区间版
 * @Compiler CVBear
 * @Date 2020/7/28 23:24
 */
public class BinarySearch3 {

    public int indexOfLeft111(int[] nums, int target) {
        // 1.[定左右]
        int left = 0;
        int right = nums.length;

        // 2.[定区间]
        while (left < right) {//[l,)
            // 3.[取中值]
            int mid = left + (right - left)/2;
            // 4.[裁剪]与收缩
            if (nums[mid] < target) left = mid + 1; // [裁剪]
            else right = mid;                       // [收缩]
        }

        // 5.[检越]
        if (left >= nums.length || nums[left] != target) return -1;

        // 6.[返边界]
        return left;
    }

}
