class Solution {
    public int maxDistance(int[] position, int totalBalls) {
        Arrays.sort(position);
        int maxForce = position[position.length-1] - position[0];
        int minForce = 1;
        int highestForce = maxForce;
        int ans = 0 ;
        while(minForce <= highestForce)
        {
            int requiredMidForce = minForce + (highestForce - minForce)/2;
            if (canWePlace(position , requiredMidForce , totalBalls) == true)
            {
                ans = requiredMidForce;
                minForce = requiredMidForce + 1;

            }
            else
            {
                highestForce = requiredMidForce-1;
            }
        }
        return ans;
    }

    private boolean canWePlace(int[] position , int requiredMidForce , int totalBalls)
    {
        int ballPlaced = 1;
        int lastBallPos = position[0];

        for (int i = 1 ; i < position.length ; i++)
        {
            if(position[i] - lastBallPos >= requiredMidForce)
            {
                ballPlaced++;
                lastBallPos = position[i];
            }
        }
        if(ballPlaced >= totalBalls)
        {
            return true;
        }
        else return false ;        
    }
}