class Solution {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length;
        int[] ngorc= new int[n];
        Arrays.fill(ngorc,-1);
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<2*n; i++){
            
            while(st.size()!=0 && A[st.peek()] < A[i % n]){
                ngorc[st.pop()] = A[i % n];
            }
            st.push(i % n);
        }
        return ngorc;
}
}