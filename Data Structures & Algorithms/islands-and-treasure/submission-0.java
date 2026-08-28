class Solution {
    int INF=2147483647;
    int directions[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] rem=q.poll();
            int row=rem[0];
            int col=rem[1];
            for(int d[]:directions){
                int newRow=d[0]+row;
                int newCol=d[1]+col;
                if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&grid[newRow][newCol]==INF){
                    grid[newRow][newCol]=grid[row][col]+1;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }
    }
}
