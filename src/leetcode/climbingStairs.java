package leetcode;

/**
 * @author dylan.ll
 * @date 2020/6/13 16:01
 */
public class climbingStairs {
    int[] res = new int[10000000];

    public int climbStairs(int n) {

        res[1] = 1;

        res[2] = 2;

        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(new climbingStairs().climbStairs(3));
    }
}
