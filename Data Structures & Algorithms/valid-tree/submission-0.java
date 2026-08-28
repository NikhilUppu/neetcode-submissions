class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        //graph creation
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer> set=new HashSet<>();
        Queue<int[]> qu=new ArrayDeque<>();
        qu.offer(new int[]{0,-1});
        set.add(0);
        while(!qu.isEmpty()){
            int [] rem=qu.poll();
            int node=rem[0];
            int parent=rem[1];
            for(int nbr:graph.get(node)){
                if(nbr==parent){
                    continue;
                }
                if(set.contains(nbr)){
                    return false;
                }
                set.add(nbr);
                qu.offer(new int[]{nbr,node});
            }
        }
        return set.size()==n;
    }
}
