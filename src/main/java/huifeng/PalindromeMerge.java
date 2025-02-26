package huifeng;
import java.util.*;
import java.util.*;
import java.util.*;

public class PalindromeMerge {

    // 合并相邻元素直到数组成为回文
    public static int[] mergeToPalindrome(int[] arr) {
        int n = arr.length;

        // dp[i][j]表示将i到j合并成回文的最优结果
        int[][] dp = new int[n][n];
        // 初始化：dp[i][i] = arr[i]，每个元素本身是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        // 动态规划计算所有子数组的最优合并
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + arr[i] + arr[j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + arr[i], dp[i][j - 1] + arr[j]);
                }
            }
        }

        // 使用dp结果回溯构建回文序列
        List<Integer> result = new ArrayList<>();
        int left = 0, right = n - 1;

        // 回溯构建回文
        while (left <= right) {
            if (arr[left] == arr[right]) {
                result.add(arr[left]);
                left++;
                right--;
            } else if (dp[left + 1][right] + arr[left] < dp[left][right - 1] + arr[right]) {
                result.add(arr[left]);
                left++;
            } else {
                result.add(arr[right]);
                right--;
            }
        }

        // 构建最终的回文序列
        List<Integer> finalResult = new ArrayList<>(result);
        for (int i = result.size() - 2; i >= 0; i--) {
            finalResult.add(result.get(i));
        }

        return finalResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // 示例输入
        int[] arr = {33, 21, 82, 50, 70, 36, 20, 26, 54};
        int[] result = mergeToPalindrome(arr);
        System.out.println("Resulting Palindrome: " + Arrays.toString(result));
    }
}
