class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);

                if (set.contains(third)) {

                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);

                    ans.add(temp);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}
