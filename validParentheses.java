import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                st.push(c); // open
            } else {
                if (st.isEmpty() || st.pop() != map.get(c)) return false;
            }
        }
        return st.isEmpty();
    }
}
