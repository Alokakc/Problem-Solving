import java.util.*;
class Pair<T, U> {
    public final T first;
    public final U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int[][] direction = {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] vis = new boolean[A+1][B+1];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>(); 
        q.add(new Pair<>(new Pair<>(C, D), 0));
        vis[C][D] = true;
        while(!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> p = q.remove();
            int i = p.first.first;
            int j = p.first.second;
            int step = p.second;
            if(i==E && j==F) return step;
            for(int k=0; k<8; k++) {
                int r = i + direction[k][0];
                int c = j + direction[k][1];
                if(r>0 && r<=A && c>0 && c<=B && !vis[r][c]) {
                    vis[r][c] = true;
                    q.add(new Pair<>(new Pair<>(r, c), step+1));
                }
            }
        }
        return -1;
    }
}

