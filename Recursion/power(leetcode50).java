class Solution {
    public double myPow(double x, int n) {
         if(n == 0){
            return 1.0;
         }
    
        double halfAns =  myPow(x, n/2);
        
        if(n % 2 == 0){
            System.out.println((halfAns * halfAns));
            
            return halfAns * halfAns;
        }
        else if( n < 0){
            System.out.println((1.0/x)*(halfAns * halfAns));
            System.out.println(halfAns * halfAns+" "+ 1.0/x);
             return (1.0/x)*(halfAns * halfAns);
        }
        
        else {
            return halfAns * halfAns * x;
        }
        
    }
}

