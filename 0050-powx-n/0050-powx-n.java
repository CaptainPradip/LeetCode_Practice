class Solution {
    public double myPow(double x, int n) {
        int  N = n;
        if(n<0){
            x= 1/x;
            N=-N;
        }
        return getPower(x,N);
    }

    private double getPower(double x,int n){

        if(n==0){
          return 1.00; 
        }
        double half = getPower(x,n/2);
        if(n%2==0){
            return half * half;
        } else{
          return half * half * x;
        }
    }
}