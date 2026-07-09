class Solution {

    public int shipWithinDays(int[] weights, int days) {

        // Find:
        // 1. Maximum package weight (minimum possible ship capacity)
        // 2. Total weight of all packages (maximum possible ship capacity)

        int maximumPackageWeight = 0;
        int totalWeight = 0;

        for (int weight : weights) {
            maximumPackageWeight = Math.max(maximumPackageWeight, weight);
            totalWeight += weight;
        }

        // Binary Search Range

        int lowestCapacity = maximumPackageWeight; // Ship cannot be smaller than the heaviest package
        int highestCapacity = totalWeight;         // Ship can carry everything in one day
        int answer = totalWeight;

        while (lowestCapacity <= highestCapacity) {

            // Capacity we are currently testing
            int currentCapacity = lowestCapacity +
                    (highestCapacity - lowestCapacity) / 2;

            // Assume we start on Day 1
            int daysNeeded = 1;

            // Current load on today's ship
            int currentLoad = 0;

            // Simulate shipping all packages
            for (int weight : weights) {

                // If the current package fits in today's remaining capacity
                if (currentLoad + weight <= currentCapacity) {

                    // Add it to today's shipment
                    currentLoad += weight;
                }

                // Otherwise start a new day
                else {

                    // Increase the day count
                    daysNeeded++;

                    // This package becomes the first package
                    // loaded on the new day
                    currentLoad = weight;
                }
            }

            // If we can ship everything within the given days,
            // this capacity works.
            if (daysNeeded <= days) {

                // Save this as a possible answer
                answer = currentCapacity;

                // Try to find an even smaller valid capacity
                highestCapacity = currentCapacity - 1;
            }

            // Capacity is too small
            else {

                // Increase the ship capacity
                lowestCapacity = currentCapacity + 1;
            }
        }

        return answer;
    }
}