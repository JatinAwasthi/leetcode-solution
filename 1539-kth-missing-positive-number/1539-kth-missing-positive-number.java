class Solution 
{
    public int findKthPositive(int[] arr, int k) 
    {
     
        int right = arr.length-1;
        int left = 0;
        while(left<=right)
        {
            //calculate mid
            int mid = left +  (right - left)/2;
            // if the the number of missing element is less than k that means for ex if we have 1 2 3 5 7 and we want k=2 we know that 1...5 has only 1 missing so we skip
            int missing = arr[mid] - (mid+1);
            if (missing < k)
            {
            left = mid+1;
            }
            else{
                right = mid-1;
            }
            
        }
        return left+k;  
       
    }
}