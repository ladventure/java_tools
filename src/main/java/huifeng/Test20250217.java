package huifeng;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test20250217 {
    public static void main(String args[] )
    {
        // Write your code here
        // Use either of these methods for input

        Scanner scanner = new Scanner(System.in);
        // 读取输入
        String needle = scanner.nextLine();
        String haystack = scanner.nextLine();
        int count = 0;
        // 遍历 haystack 并检查子串是否等于 needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
