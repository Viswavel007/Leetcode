class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxResult = new int[k];
        
        // Try all valid lengths for the first array
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (isGreater(candidate, 0, maxResult, 0)) {
                maxResult = candidate;
            }
        }
        return maxResult;
    }

    // Step 1: Use a monotonic stack logic to find the max subsequence of length len
    private int[] maxArray(int[] nums, int len) {
        int[] res = new int[len];
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > len && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < len) res[j++] = nums[i];
        }
        return res;
    }

    // Step 2: Merge two arrays to form the largest number
    private int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = isGreater(a, i, b, j) ? a[i++] : b[j++];
        }
        return res;
    }

    // Step 3: Comparison helper (crucial for tie-breaking during merge)
    private boolean isGreater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}
