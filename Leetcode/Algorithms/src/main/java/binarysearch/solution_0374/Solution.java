package solution_0374;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // 1.[定左右]
        int l = 1;
        int r = n;

        // 2.[定区间]
        while (l <= r) {

            // 3.[取中值]
            int mid = l + (r - l)/2;

            // 4.[进退三则]
            if (guess(mid) > 0) {
                l = mid + 1; // 大中则进
            } else if (guess(mid) < 0) {
                r = mid - 1; // 小中则退
            } else {
                return mid; // 等中则返
            }
        }

        // 5.[无功而返]
        return -1;
    }
}

//解决报错无用
class GuessGame {
    int guess(int num) {
        return 0;
    }
}