class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>
                                    ((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.offer(new int[]{e.getValue(),e.getKey()});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll()[1];
        }
        return res; 
    }
}
