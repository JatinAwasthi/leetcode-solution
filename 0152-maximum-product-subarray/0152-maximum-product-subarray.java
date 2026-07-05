class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        
        int len = nums.length;
        for (int start = 0 ; start < len ; start++)
        {
            int current = 1;
            for (int end = start ; end < len ; end++)
            {
                
                current = current * nums[end];
                if(current > max)
                {
                    max = current;
                }

            }
        }
        return max;
    
    }
}