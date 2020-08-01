package framework.basic;

/**
 * @Classname BinarySearch1
 * @Description 基本框架1
 * @Compiler CVBear
 * @Date 2020/7/28 23:16
 */
public class BinarySearch1 {

    public  int indexOf(int[] a, int target) {
        // 1.[定左右]
        int left = 0;
        int right = a.length -1;

        // 2.[定区间]
        while (left <= right) {// [left,right]
            // 3.[取中值]
            int mid = left + (right-left)/2;
            // 4.[进退三则]
            if (target > a[mid]) left = mid + 1;  	   // [大中则进] [mid+1,right]
            else if (target < a[mid]) right = mid - 1; // [小中则退] [left,mid-1]
            else return mid;					       // [等中则返] [mid]且l=r=mid 解区间
        }

        // 5.[无功而返]
        return -1;
    }
}
