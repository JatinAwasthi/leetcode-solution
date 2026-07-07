class Solution 
{
    public int singleNonDuplicate(int[] nums) 
    {
        int low = 0;
        int high = nums.length-1;
        while (low < high) //the reason why we dont use <= is because we want that when high and low are equal return either high or low for ex at a point high = low =4 that means only a single element is left return that . But the moment we use less that or equal since 4==4 the looop will run one more time now image there were only 5 element that is index was at 4 and now u did if nums[mid]==nums[mid+1] i.e nums[5] which doesnt even exist so out of bound error
        {
            int mid = low + (high-low)/2;
            if(mid%2 == 1)
            {
                mid = mid-1;
            }
            if(nums[mid]==nums[mid+1])
            {
                low = mid+2;
            }
            else
            {
                high = mid;
            }
        }
        return nums[low];
    }
}