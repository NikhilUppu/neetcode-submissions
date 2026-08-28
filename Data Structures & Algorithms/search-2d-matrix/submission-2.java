class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length-1;
        int ans_row=-1;
        for(int i=0;i<n;i++){
            if(matrix[i][m]>=target){
                ans_row=i;
                break;
            }
        }
        if(ans_row==-1) return false;
        for(int i=0;i<=m;i++){
            if(matrix[ans_row][i]==target){
                return true;
            }
        }
        return false;
    }
}
