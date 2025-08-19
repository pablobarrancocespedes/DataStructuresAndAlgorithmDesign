class Solution {
    public int maxArea(int[] height) {
        //Area of a rectangle is base * height
        //Base is pointer2 - pointer1
        //Height is min(height[pointer1], height[pointer2])
        int pointer1 = 0;
        int pointer2 = height.length - 1;
        int maxArea = 0;

        while(pointer1 != pointer2){
            int b = pointer2 - pointer1;
            int h = Math.min(height[pointer1], height[pointer2]);
            int area = b * h;
            if(maxArea < area){
                maxArea = area;
            }

            if(height[pointer1] > height[pointer2]){
                pointer2--;
            } else {
                pointer1++;
            }


        }

        return maxArea;
    }
}
