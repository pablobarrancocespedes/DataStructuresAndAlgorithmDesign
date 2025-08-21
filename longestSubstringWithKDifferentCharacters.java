class Solution {
    public int longSubstring(String s, int k){
        if (s == null || s.length() == 0 || k == 0) return 0;
        int length = s.length();
        //Dado un string s y un número k, encuentra
        // la longitud del substring más largo que tenga
        // a lo sumo k caracteres distintos.
        int maxLen = 0;
        //HashMap + sliding window
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;

        for(int right = 0; right < length; right++){
            char c = s.charAt(right);
            charCount.put(c,charCount.getOrDefault(c,0)+1);

            // Si hay más de k caracteres distintos, reducimos desde la izquierda
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right -left +1);
        }

        return maxLen;

    }
}