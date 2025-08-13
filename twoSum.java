class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] sol = {-1, -1};
        boolean found = false;

        int i = 0;
        while (i < n - 1 && !found) {
            int j = i + 1;
            while (j < n) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                    found = true;
                    break;          // salimos del while interno
                }
                j++;
            }
            i++;
        }
        return sol;
    }
}