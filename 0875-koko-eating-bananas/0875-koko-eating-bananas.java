class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int len = piles.length;
        int max = piles[0];
        
            
        
        for (int i = 1; i < piles.length; i++) 
        {
            if (piles[i] > max) 
            {
                max = piles[i];
            }
        }
        int lowSpeed = 1; //low here is the speed and it cant be 0
        int highSpeed = max;
        int ans = max;
        while(lowSpeed<=highSpeed)
        {
            int midSpeed = lowSpeed + (highSpeed - lowSpeed) / 2;
            // or the optimal mid formula is 
            // int hours = (piles[i] + midSpeed - 1) / midSpeed;

            // because:

            // No floating-point arithmetic.
            // Faster.
            // Avoids any precision issues.
            // Standard interview solution.
            long total = 0 ;
            for(int i = 0 ; i<piles.length ; i++)
            {
                int hours = (piles[i] + midSpeed - 1) / midSpeed;
                total+=hours;
            }
            if(total <= h)
            {
                ans = midSpeed;
                highSpeed = midSpeed - 1;
            }
            else{
                lowSpeed = midSpeed+1;
            }
        }

        return ans;
    }
}