class Solution {
    int n,m;
    int directions[][]={{-1,0},{1,0},{0,1},{0,-1}};
    List<List<Integer>> ans;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        ans=new ArrayList<>();
        boolean[][] pacifiOcean=new boolean[n][m];
        boolean[][] AtlanticOcean=new boolean[n][m];
        //Row wise dfs
        for(int i=0;i<m;i++){
            dfs(heights,0,i,heights[0][i],pacifiOcean);
            dfs(heights,n-1,i,heights[n-1][i],AtlanticOcean);
        }
        //COl wise dfs
        for(int i=0;i<n;i++){
            dfs(heights,i,0,heights[i][0],pacifiOcean);
            dfs(heights, i, m-1, heights[i][m-1], AtlanticOcean);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacifiOcean[i][j]&&AtlanticOcean[i][j]){
                    List<Integer> li=new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    ans.add(li);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] heights,int r,int c,int previous,boolean visited[][]){
        if(r<0||r>=n||c<0||c>=m||visited[r][c]||heights[r][c]<previous){
            return;
        }
        visited[r][c]=true;
        for(int[] d:directions){
            dfs(heights,r+d[0],c+d[1],heights[r][c],visited);
        }
    }

}