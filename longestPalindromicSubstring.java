class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int bestStart = 0;
        int bestLen = 1;

        int len = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            len = Math.max(len1,len2);
            if (len > bestLen) {
                bestLen = len;
                // Fórmula para recuperar el inicio usando i y len:
                bestStart = i - (len - 1) / 2;    // funciona para impar y par
    }
        }
        return s.substring(bestStart,bestStart+bestLen);
    }

    private int expand(String s, int left, int right){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--; 
            right++;
        }
        return right-left-1;
    }
}
