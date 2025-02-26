package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 思路：通过滑动窗口实现，通过两个堆栈记录窗口括号情况，如果遇到右括号，判断栈顶是否是左括号，如果是，出栈并且计算一轮合法子串的长度更新max，否则入栈。
 * 然后通过一个堆栈记录栈元素的index，用来记录窗口的起始位置和计算合法子串的长度。
 * <p>
 * *  1. 遍历字符串，遇到左括号，入栈，记录index
 * *  2. 遇到右括号，判断栈顶是否是左括号，如果是，出栈，计算合法子串长度，更新max，否则入栈，记录index
 * *  3. 遍历结束，返回max
 * *
 * *  时间复杂度：O(n)
 * *  空间复杂度：O(n)
 *
 * @author dylan.ll
 * @date 2020/11/1 16:40
 */
public class LongestValidParentheses_32_最长有效括号 {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || stack.isEmpty() || stack.peek() == ')') {
                stack.push(s.charAt(i));
                indexStack.push(i);
            } else {
                stack.pop();
                indexStack.pop();
                int stackTopIndex = indexStack.isEmpty() ? -1 : indexStack.peek();
                if (i - stackTopIndex > max) {
                    max = i - stackTopIndex;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));

        System.out.println(longestValidParentheses(""));

    }
}
