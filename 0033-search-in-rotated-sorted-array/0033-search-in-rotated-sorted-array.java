class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len -1;
        while (low<= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }


            if(nums[low] <= nums[mid])
            {
                //left half is sorted- search left
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }
                else{ //right half is sorted - search right
                    low = mid+1;
                }
            }


            else //if(nums[mid+1] <= nums[high])  -- cant use this due to java telling mid+1 is unsafe and could result in out of bound
            {
                //right half is sorted- search right
                if(target > nums[mid] && target <= nums[high]){
                low = mid+1;
                }
                else{ //left half is sorted - search left
                    high = mid-1;
                }
            }
            
            
        }
        return -1;
    }
}