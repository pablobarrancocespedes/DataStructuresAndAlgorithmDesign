class Solution {
    public int paresSum(int[] nums) {
        Map<Integer,Integer> parityCount = new HashMap<>();
        parityCount.put(0,-1);
        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum+=num;

            int parity = sum%2;

            count+=parityCount.getOrDefault(parity,0);

            parityCount.put(parity, count + 1);
        }

        return count;
    }
}