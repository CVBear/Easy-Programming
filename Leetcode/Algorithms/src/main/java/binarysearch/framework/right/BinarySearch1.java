package binarysearch.framework.right;

/**
 * @Classname BinarySearch1[开区间版)
 * @Description [查询右边界]写法1
 * 利用[统一东部]的思想
 * [裁剪]解的部分获得解的下一个位置,-1则为[最右解]
 * @Compiler CVBear
 * @Date 2020/7/29 9:10
 */
class BinarySearch1 {

    /**
     * 开区间版[l,r)
     *
     * @param nums
     * @param target
     * @return
     */
    public int indexOfRight(int[] nums, int target) {
        // 1.[定左右]
        int left = 0;
        int right = nums.length;

        // 2.[检越]
        if (target > nums[right - 1] || target < nums[left]) return -1;

        // 3.[定区间]
        while (left < right) {// [0,r)双指针可以在[0,n]移动
            // 4.[取中值]
            int mid = left + (right - left) / 2;
            // 5.[裁剪与收缩]
            if (nums[mid] <= target) {// 修改① < 修改为了 <=
                left = mid + 1;// [裁剪]后 [mid+1,right)
            } else {
                right = mid;// 边界[收缩]至[left,mid)实际移动范围[l,mid]
            }
        }

        // 6.[返边界] 方便记忆查询哪边返回哪边
        return right - 1;// 修改②
    }
}
