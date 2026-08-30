class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            if(nums[mid]<nums[right]){
                right=mid;
            }
            min=Math.min(nums[mid],min);
        }
        return nums[left];
    }
}
