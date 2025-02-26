package leetcode;

import java.util.Arrays;

public class SingleNumber_136_只出现一次的数字 {
    /**
     * 思路：给定的所有数字都出现两次，只有一个数字出现一次，要求找出这个数字。
     * 思路：通过异或运算实现，异或运算的性质：
     * 1. 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 2. 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 3. 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * @param nums
     * @return
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
    }
}
