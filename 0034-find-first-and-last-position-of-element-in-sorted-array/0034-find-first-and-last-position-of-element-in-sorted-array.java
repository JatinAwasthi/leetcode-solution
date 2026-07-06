class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        if (first == nums.length || nums[first] != target)
            return new int[]{-1, -1};

    return new int[]{first, upper - 1};
    }
    private int lowerBound(int[] arr , int x)
    {
        int lower = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= x)
            {
                lower = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return lower;
    }

    private int upperBound(int[] arr, int x)
    {
        int higher = arr.length;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x)
            {
                higher = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return higher;
    }
}