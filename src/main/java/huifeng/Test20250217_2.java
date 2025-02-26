package huifeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test20250217_2 {
    // 合并相邻元素直到数组成为回文
    public static int[] mergeToPalindrome(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        // 使用两个指针从两端开始合并
        int left = 0, right = n - 1;

        while (left <= right) {
            if (arr[left] == arr[right]) {
                // 如果两端相等，将其加入回文结果
                result.add(arr[left]);
                left++;
                right--;
            } else {
                // 如果两端不相等，合并相邻元素
                if (arr[left] < arr[right]) {
                    // 合并左边
                    arr[left + 1] += arr[left];
                    left++;
                } else {
                    // 合并右边
                    arr[right - 1] += arr[right];
                    right--;
                }
            }
        }

        // 构建最终回文序列
        List<Integer> finalResult = new ArrayList<>(result);
        for (int i = result.size() - 2; i >= 0; i--) {
            finalResult.add(result.get(i));
        }

        return finalResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入
        String num = scanner.nextLine();
        if(Integer.parseInt(num)==0){
            System.out.println();
            return;
        }
        String salesDataStr = scanner.nextLine();
        int[] salesDataArr= Arrays.stream(salesDataStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[]  res=mergeToPalindrome(salesDataArr);
        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.print(res[res.length-1]);
    }
}
