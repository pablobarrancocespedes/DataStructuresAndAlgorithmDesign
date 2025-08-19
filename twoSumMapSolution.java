import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(nums[i])){
                // Return the result as an array
                return new int[]{ map.get(nums[i]), i};
            } else {
                map.put(key,i);
            }

        }

        return nums;
    }
}
