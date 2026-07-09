class Solution 
{
    public int smallestDivisor(int[] nums, int threshold) 
    { 
        int sum = 0;
        int len  = nums.length;
        int maxDivisor = nums[0];
        for (int num : nums) {
            maxDivisor = Math.max(maxDivisor, num);
        }

        int minDivisor = 1;
        int ans = maxDivisor;
        while(minDivisor <= maxDivisor)
        {
            int midDivisor = minDivisor + (maxDivisor - minDivisor)/2;

            int divisorSum = 0;
            for(int j = 0 ; j<len ; j++)
            {
                int temp = (nums[j]+midDivisor-1)/midDivisor;
                divisorSum += temp ;
            }
            if(divisorSum <= threshold)
            {
                ans = midDivisor;
                maxDivisor = midDivisor -1;
            }
            else{
                minDivisor = midDivisor+1;
            }
        }
        return ans;
    }
}