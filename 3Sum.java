class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Avoid duplicates --> sort the arrayy
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){
            //Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //Two pointer to manage j and k
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicate nums[right]
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }

        }

        return res;

    }
}
