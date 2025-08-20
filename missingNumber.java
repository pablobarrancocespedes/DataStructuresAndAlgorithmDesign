class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //Suma esperada del array
        int expectedSum = n * (n+1) /2;
        int sum = 0;

        for(int i : nums){
            sum+=i;
        }

        return expectedSum-sum;

    }
}
