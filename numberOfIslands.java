class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;

        int n = grid[0].length;

        int islands = 0;
        for(int r = 0; r < m ; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    islands++;
                    bfs(grid,r,c,m,n);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int sr, int sc, int m, int n){
        ArrayDeque<int []> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        grid[sr][sc] = '0';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dirs){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';   // marcar visitado
                    q.offer(new int[]{nr, nc});
                }
            }
            
        }

    }
}
