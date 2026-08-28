class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            boolean visited[]=new boolean[n+1];
            if(dfs(u,-1,graph,visited)){
                return edges[i];
            }
        }
        return new int[0];
    }
    public boolean dfs(int node,int parent,List<List<Integer>> graph,boolean visited[]){
        if(visited[node]){
            return true;
        }
        visited[node]=true;
        for(int nbr:graph.get(node)){
            if(nbr==parent){
                continue;
            }
            if(dfs(nbr,node,graph,visited)){
                return true;
            }
        }
        return false;
    }
}
