package binarysearch.framework.right;

/**
 * @Classname BinarySearch3
 * @Description [查询右边界]
 * 利用[统一西部]的思想
 * 注意要获取右中位不然会因为向下取整导致死循环获取不到右边界
 * @Compiler CVBear
 * @Date 2020/7/29 9:10
 */
class BinarySearch3 {

    /**
     * 开区间版[l,r]
     *
     * @param nums
     * @param target
     * @return
     */
    public int indexOfRight(int[] nums, int target) {
        // 1.[定左右]
        int left = 0;
        int right = nums.length-1;// 修改①

        // 3.[定区间]
        while (left < right) {// [0,r) 修改② 双指针技巧 left→逃跑 逃跑<-right
            // 4.[取中值]
            int mid = left + (right - left + 1) / 2;// 注意点
            // 5.[裁剪与收缩]
            if (nums[mid] > target) {// mid及右侧不是解
                right = mid - 1;// [裁剪]
            } else {
                left = mid;// 边界[收缩]
            }
        }

        // 2.[检越]
        if ((right == 0 && target != nums[right]) || (right >= nums.length-1 && target != nums[right])) return -1;

        // 6.[返边界] 方便记忆查询哪边返回哪边
        return right;
    }
}
