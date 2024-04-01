import java.util.*;

public class counting2ATcoder {
  public static int helper(int[] st, int key) {
    int s = 0, e = st.length-1, ans = st.length;
    while(s <= e) {
      int mid = (s+e)>>1;
      if(st[mid] == key) return mid;
      else if(st[mid] > key) {
        ans = mid;
        e = mid-1;
      } else {
        s = mid+1;
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int q = input.nextInt();
    int[] st = new int[n];
    for(int i=0; i<n; i++) {
      st[i] = input.nextInt();
    }
    Arrays.sort(st);
    while(q-->0) {
      System.out.println(st.length-helper(st, input.nextInt()));
    }
    input.close();
  }
}