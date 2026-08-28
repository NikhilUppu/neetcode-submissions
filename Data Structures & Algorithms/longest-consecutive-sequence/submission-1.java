class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer>set=new HashSet<>();
       int max=0;
       int count=0;
       for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
       }
       for(int i=0;i<nums.length;i++){
        int current=nums[i];
        count=1;
        if(!set.contains(current-1)){
            while(set.contains(current+1)){
                count++;
                current++;
            }
            max=Math.max(max,count);
        }
       }
       return max; 
    }
}
