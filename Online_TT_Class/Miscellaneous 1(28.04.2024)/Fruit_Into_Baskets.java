import java.util.*;

class Solution {
    public int totalFruit(int[] f) {
        if(f.length <= 2) return f.length;
        int s = 0, e = 0, max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        while(e < f.length) {
            if(map.containsKey(f[e])) {
                map.put(f[e], map.get(f[e])+1);
            }
            else {
                map.put(f[e], 1);
            }
            while(map.size() > 2) {
                map.put(f[s], map.get(f[s])-1);
                if(map.get(f[s]) <= 0) map.remove(f[s]);
                s++;
            }
            max = Math.max(max, e-s+1);
            e++;
        }
        return max;
    }
}