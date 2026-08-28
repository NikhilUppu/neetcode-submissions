class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }
    public boolean dfs(List<List<Integer>> graph,boolean visited[],int node){
     if(visited[node]){
        return true;
     }
     visited[node]=true;
     for(int nbr:graph.get(node)){
        if(!visited[nbr]){
            dfs(graph,visited,nbr);
        }  
     }
     return false;
    }
}
