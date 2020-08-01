package solution_0069;

/**
 * @Classname Solution1
 * @Description [写法1]: 修改自基本框架
 * @Strategy Decrease and Conquer
 * @Algorithm BinarySearch
 * @Url https://leetcode-cn.com/problems/sqrtx/
 * @Compiler CVBear
 * @Date 2020/7/28 9:24
 */
public class Solution1 {

    /**
     * l: left r: right
     * @param x 目标值
     * @return 返回x的平方根
     */
    public int mySqrt(int x) {
        // 1.[定左右],范围: [0,x]
        long l = 0;
        long r = x;

        // 2.[定区间]
        while (l <= r) {// [lo,hi]
            // 3.[取中值] 使用整型避免溢出
            long mid = l + (r - l)/2;
            long midVal = mid * mid;
            // 4.[进退三则]
            if (x > midVal) l = mid + 1; 	   //[大中则进] 下一轮查询区间 [mid+1,r]①
            else if (x < midVal)  r = mid - 1; //[小中则退] 下一轮查询区间 [l,mid-1]②
            else return (int)mid;			   //[等中则返] 获取值的区间 [mid]③
        }

        // 5.[返边界]
        return (int)(l-1);// r
    }
}
