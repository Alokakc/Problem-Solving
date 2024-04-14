import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class TrieNode {
    TrieNode[] children;
    Map<Integer, PriorityQueue<Integer>> map;
    TrieNode() {
        children = new TrieNode[26];
        map = new TreeMap<>();
    }
}
public class Longest_Common_Suffix_Queries {

    public void mapInsert(TrieNode currRoot, int n, int index) {
        Map<Integer, PriorityQueue<Integer>> mm = currRoot.map;
        if(!mm.containsKey(n)) mm.put(n, new PriorityQueue<Integer>());
        PriorityQueue<Integer> qm = mm.get(n);
        qm.add(index);
    }

    public void insert(TrieNode root, String s, int index) {
        TrieNode currRoot = root;
        int n = s.length();
        mapInsert(currRoot, n, index);
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if(currRoot.children[c-'a'] == null) currRoot.children[c-'a'] = new TrieNode();
            currRoot = currRoot.children[c-'a'];
            mapInsert(currRoot, n, index);
        }
    }

    public int search(TrieNode root, String s) {
        TrieNode currRoot = root;
        int n = s.length();
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if(currRoot.children[c-'a'] == null) {
                Map<Integer, PriorityQueue<Integer>> m = currRoot.map;
                for(Map.Entry<Integer, PriorityQueue<Integer>> mp: m.entrySet()) {
                    PriorityQueue<Integer> q = mp.getValue();
                    return q.peek(); 
                }
            }
            currRoot = currRoot.children[c-'a'];
        }
        Map<Integer, PriorityQueue<Integer>> m = currRoot.map;
        for(Map.Entry<Integer, PriorityQueue<Integer>> mp: m.entrySet()) {
            PriorityQueue<Integer> q = mp.getValue();
            return q.peek();
        }
        return 0;
    }

    public int[] stringIndices(String[] wC, String[] wQ) {
        TrieNode root = new TrieNode();
        int[] ans = new int[wQ.length];
        for(int i=0; i<wC.length; i++) {
            insert(root, wC[i], i);
        }
        for(int i=0; i<wQ.length; i++) {
            ans[i] = search(root, wQ[i]);
        }
        return ans;
    }
}