class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        
        long count = 0;
        // Iterate through each place value (1, 10, 100, ...)
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            
            // Full sets of 'divider' contribute 'i' ones to this position
            count += (n / divider) * i;
            
            // Handle the remaining partial set
            long remainder = n % divider;
            count += Math.min(Math.max(remainder - i + 1, 0), i);
        }
        
        return (int) count;
    }
}
