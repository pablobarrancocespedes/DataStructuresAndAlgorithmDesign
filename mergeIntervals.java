class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return new int[0][];
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart <= currEnd){
                currEnd = Math.max(currEnd,nextEnd);
            } else {
                merged.add(new int[]{currStart, currEnd});

                currStart = nextStart;
                currEnd = nextEnd;
            }
        }
        merged.add(new int[]{currStart,currEnd});

        return merged.toArray(new int[merged.size()][]);
    }
}
