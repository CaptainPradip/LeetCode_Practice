class Solution {
    public double myPow(double x, int n) {
      long N = n;  // Use long to avoid overflow when negating the minimum integer value
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        // Iterate while there are still bits to process in N
        while (N > 0) {
            if (N % 2 == 1) {  // If N is odd, multiply the current result by currentProduct
                result *= currentProduct;
            }
            currentProduct *= currentProduct;  // Square the current product
            N /= 2;  // Divide N by 2 (right shift in binary)
        }

        return result;
    }

    private double getPower(double x, int n) {

        if (n == 0) {
            return 1.00;
        }
        double half = getPower(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}