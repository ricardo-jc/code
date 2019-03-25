package fortyLectures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean solution(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenth = new HashMap<>();
        parenth.put(')', '(');parenth.put(']', '[');parenth.put('}', '{');
        for(Character c : input.toCharArray()){
            if(parenth.containsKey(c)) {
                if(!stack.empty() && stack.peek() == parenth.get(c)) stack.pop();
                else return false;
            }
            else stack.push(c);
        }
        return stack.empty();
    }
}
