class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // 1) espacios
        while (i < n && s.charAt(i) == ' ') i++;

        // 2) signo
        int sign = 1;
        if (i < n) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (c == '-') sign = -1;
                i++;
            }
        }

        // 3) (opcional) ceros a la izquierda
        boolean hasDigits = false;
        while (i < n && s.charAt(i) == '0') { hasDigits = true; i++; }

        // 4) dígitos + control de overflow
        int res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            hasDigits = true;

            if (res > Integer.MAX_VALUE / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (res == Integer.MAX_VALUE / 10) {
                if (sign == 1 && d > 7) return Integer.MAX_VALUE;  // 2147483647
                if (sign == -1 && d >= 8) return Integer.MIN_VALUE; // 2147483648 ⇒ clamp a MIN
            }

            res = res * 10 + d;
            i++;
        }

        if (!hasDigits) return 0;
        return (sign == 1) ? res : -res;
    }
}
