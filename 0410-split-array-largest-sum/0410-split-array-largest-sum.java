class Solution {
    public int splitArray(int[] nums, int k) 
    {
        if (k > nums.length)
            return -1;
        int highest = nums[0];
        int sum = nums[0];
        for (int i = 0 ; i<nums.length ; i++)
        {
            highest = Math.max(highest,nums[i]);
            sum += nums[i];
        }

        int low = highest ; // minimum possible answer
        int high = sum ;    // max possible answer
        int ans = highest;
        while (low <= high)
        {
            int mid = low + (high-low)/2;
            if (canAllocate(nums, k, mid)) 
            {
                ans = mid;
                high = mid - 1;      // Try a smaller maximum
            } 
            
            else 
            {
                low = mid + 1;       // Need a larger maximum
            }

        }

        return ans;
        
    }

    private static boolean canAllocate(int[] nums , int maxArrayCount , int maxSum)
    {
        int arrayCount  = 1;
        int addition = 0;


        for(int i = 0 ; i<nums.length ; i++)
        {
            if(addition + nums[i] <= maxSum){
                addition += nums[i];
            }
            else{
                arrayCount++;
                addition = nums[i];

                if ( arrayCount > maxArrayCount )
                    return false;
            }
        }
        return true;
    }
}