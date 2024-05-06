class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct1=Integer.MIN_VALUE, maxproduct2=Integer.MIN_VALUE;;
        int mul1=1, mul2=1;
        for(int i=0; i<nums.length; i++){
            mul1*=nums[i];
            maxproduct1 = Math.max(maxproduct1, mul1);
            if(mul1==0) mul1=1;
            mul2*=nums[nums.length-1-i];
            maxproduct2 = Math.max(maxproduct2, mul2);
            if(mul2==0) mul2=1;
        }
        
        return Math.max(maxproduct1, maxproduct2);
    }
}