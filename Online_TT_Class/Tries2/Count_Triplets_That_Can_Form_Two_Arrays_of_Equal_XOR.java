import java.util.*;

class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int xor = 0, ans = 0;
        map.put(xor, new ArrayList<>());
        map.get(xor).add(-1);
        for(int i=0; i<arr.length; i++) {
            xor ^= arr[i];
            if(map.containsKey(xor)) {
                for(Integer x: map.get(xor)) {
                    ans += (i-x)-1;
                }
            }
            else map.put(xor, new ArrayList<>());
            map.get(xor).add(i);
        }
        return ans;
    }
}