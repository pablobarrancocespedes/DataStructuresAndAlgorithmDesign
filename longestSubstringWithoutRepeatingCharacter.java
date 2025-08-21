class Solution {    
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0;
        int best = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(last.containsKey(c) && last.get(c) >= left){
                left = last.get(c) + 1;
            }
            last.put(c,right);
            best = Math.max(best,right-left+1);
        }
        return best;
    }
}
