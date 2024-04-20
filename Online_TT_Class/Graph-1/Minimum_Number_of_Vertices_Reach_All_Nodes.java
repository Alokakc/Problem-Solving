import java.util.*;

class Minimum_Number_of_Vertices_Reach_All_Nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDeg = new int[n];
        for(int i=0; i<edges.size(); i++) {
            inDeg[edges.get(i).get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(inDeg[i] == 0) ans.add(i);
        }
        return ans;
    }
}
