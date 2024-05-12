import java.util.Map;
import java.util.HashMap;

class Solution {

    //RECURSION

    // public int solve(int n) {
    //     if(n==0) return 0;
    //     int operation1 = Integer.MAX_VALUE;
    //     if(n%2 == 0) operation1 = solve(n/2);
    //     int operation2= Integer.MAX_VALUE;
    //     if(n%3 == 0) operation2 = solve(n/3);
    //     int operation3 = Integer.MAX_VALUE;
    //     if(n%2!=0 || n%3!=0) operation3 = solve(n-1);
    //     return Math.min(operation1, Math.min(operation2, operation3)) + 1;
    // }
    // public int minDays(int n) {
    //     return solve(n);
    // }

    //MEMOIZATION
    
    Map<Integer, Integer> dp;
    public int solve(int n) {
        if(n<=0) return 0;
        if(dp.containsKey(n)) return dp.get(n);
        int operation = Integer.MAX_VALUE;
        if(n%2 == 0) operation = Math.min(operation, solve(n/2));
        if(n%3 == 0) operation = Math.min(operation, solve(n/3));
        if(n%2!=0 || n%3!=0) operation = Math.min(operation, solve(n-1));
        operation += 1;
        dp.put(n, operation);
        return operation;
    }
    public int minDays(int n) {
        dp = new HashMap<>();
        return solve(n);
    }
}