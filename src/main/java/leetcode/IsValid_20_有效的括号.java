package leetcode;

import java.util.Stack;

public class IsValid_20_有效的括号 {
//    栈操作即可
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character tmp=s.charAt(i);
            if(tmp.equals('(')||tmp.equals('[')||tmp.equals('{')){
                stack.push(tmp);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character top=stack.peek();
                if(tmp.equals(')') && top.equals('(') || tmp.equals('}') && top.equals('{') || tmp.equals(']') && top.equals('[')){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
