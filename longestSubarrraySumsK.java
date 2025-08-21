class Solution {
    public int longestSubarray(int[] nums, int k){
        //TODO: sacar la longitud más larga del subarray que sume k
        //O(n2)
        int maxLen = 0;
        for(int left = 0; left < nums.length; left++){
            int sum = 0;
            int len = 0;
            for(int right = left; right < nums.length; right++){
                sum += nums[right];
                if(sum == k) {
                    len = right - left + 1;
                }
            }
            if(len > maxLen){
                maxLen = len;
            }
        }

        return maxLen;

    }

    /*
    La solución O(n²) funciona pero no es eficiente para inputs grandes.
Podemos mejorar a O(n) usando prefix sums + HashMap:
almacenamos el primer índice donde vimos cada prefix sum,
 y cuando encontramos prefixSum - k,
significa que existe un subarray con suma k. Así mantenemos el subarray más largo
     */

    public int longestSubarray2(int[] nums, int k) {
        int maxLen = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,-1);
        int sum = 0;
        int maxLen = 0;

        for(int left = 0; left < nums.length; left++){
            sum+=nums[left];
            if(prefixCount.containsKey(sum-k)){
                int prevIndex = prefixCount.get(sum-k);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
            prefixCount.putIfAbsent(sum,left);
        }

        return maxLen;
    }
}