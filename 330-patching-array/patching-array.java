class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // Current number in array can extend our reachable range
                miss += nums[i];
                i++;
            } else {
                // We must patch 'miss' itself to greedily extend the range the most
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }
}
