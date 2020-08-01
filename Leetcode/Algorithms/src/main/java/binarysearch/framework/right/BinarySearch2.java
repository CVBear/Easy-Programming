package framework.right;

/**
 * @Classname BinarySearch2
 * @Description [查询右边界]
 * @Compiler CVBear
 * @Date 2020/7/29 9:10
 */
class BinarySearch2 {

    /**
     * 修改自写法1
     * 闭区间版[l,r]
     *
     * @param nums
     * @param target
     * @return
     */
    private static int indexOfRight(int[] nums, int target) {
        // 1.[定左右]
        int left = 0;
        int right = nums.length - 1;// 修改①

        // 3.[定区间]
        while (left <= right) {// [0,r] 修改② 双指针技巧 left→逃跑 逃跑<-right
            // 4.[取中值]
            int mid = left + (right - left) / 2;
            // 5.[裁剪与收缩]
            if (nums[mid] <= target) {  // 修改③ < 修改为了 <=
                left = mid + 1;         // [裁剪]后 [mid+1,right)
            } else {
                right = mid - 1;        // 边界[收缩]至[left,mid-1]
            }
        }

        // 2.[检越]
        if (right < 0 || left > nums.length-1) return -1;

        // 6.[返边界] 方便记忆查询哪边返回哪边
        return right;// 修改④
    }
}
