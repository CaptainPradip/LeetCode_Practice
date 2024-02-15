class Solution {
    public int numOfWays(int n) {
        final int MOD = (int) 1e9 + 7; // Define the modulo value for avoiding integer overflow
      
        // Initial counts of color combinations for a single row, f0 for one pattern type, f1 for the other pattern type
        long countPatternTypeA = 6, countPatternTypeB = 6;
      
        // Iterate through the grid rows, starting from the second row
        for (int i = 0; i < n - 1; ++i) {
            // Calculate the new count for pattern type A using the previous counts
            long newCountPatternTypeA = (3 * countPatternTypeA + 2 * countPatternTypeB) % MOD;
            // Calculate the new count for pattern type B using the previous counts
            long newCountPatternTypeB = (2 * countPatternTypeA + 2 * countPatternTypeB) % MOD;
          
            // Update the counts for the next iteration
            countPatternTypeA = newCountPatternTypeA;
            countPatternTypeB = newCountPatternTypeB;
        }
      
        // Return the total count (sum of both pattern types), ensuring the result is modulo-ed
        return (int) (countPatternTypeA + countPatternTypeB) % MOD;
    }
}