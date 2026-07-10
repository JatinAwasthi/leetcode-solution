class Solution {
    public int aggressiveCows(int[] stall, int totalCows) {
        Arrays.sort(stall);
        int maxDis = stall[stall.length - 1] - stall[0];
        int minDis = 1;
        int highestDis = maxDis;
        while (minDis <= highestDis) {
            int mid = minDis + (highestDis - minDis) / 2;
            if (canWePlace(stall, mid, totalCows)) {
                minDis = mid + 1;
            } else {
                highestDis = mid - 1;
            }
        }
        return highestDis;
    }

    private boolean canWePlace(int[] stall, int minDis, int totalCows) {
        int cowPlaced = 1;
        int lastCowPos = stall[0];
        for (int i = 1; i < stall.length; i++) {
            if (stall[i] - lastCowPos >= minDis) {
                cowPlaced++;
                lastCowPos = stall[i];
            }
        }
        return cowPlaced >= totalCows;
    }
}