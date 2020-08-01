package framework.basic;

/**
 * @Classname BinarySearch2
 * @Description 基本框架2
 * @Compiler CVBear
 * @Date 2020/7/28 23:16
 */
public class BinarySearch2 {

    public int indexOf(int[] a, int target) {
        // 1.[定左右]
        int left = 0;
        int right = a.length;// 修改①

        // 2.[定区间]
        while (left < right) {// [l,r)
            // 3.[取中值]
            int mid = left + (right-left)/2;
            // 4.[进退三则]
            if (target > a[left]) left = mid + 1;  // [大中则进] [mid+1,r)
            else if (target < a[mid]) right = mid; // [小中取中] [l,mid) 修改②
            else return mid;					   // [等中则返] [mid]且l+1=r & mid=l
        }

        // 5.[返回边界]
        return -1;
    }
}
