class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || numRows >= s.length()){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }

        int row = 0;
        int dir = 1;

        for(int i = 0; i < s.length() ; i++){
            rows.get(row).append(s.charAt(i));

            if(row == 0){
                dir = 1;
            } else if(row == numRows-1){
                dir = -1;
            }
            row+=dir;
        }

        StringBuilder out = new StringBuilder();
        for(StringBuilder sb : rows){
            out.append(sb);
        }
        return out.toString();
    }
}
