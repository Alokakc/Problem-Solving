public class kth_element_in_sortedMatrix {
    public static int smallElementF2(int[] mat, int n, int Element) {
        int s = 0, e = n-1, ans = n;
        while(s<=e) {
            int mid = (s+e)>>1;
            if(mat[mid] > Element) {
                ans = mid;
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        return ans;
    }
    public static int smallElementF1(int[][] mat, int n, int Element) {
        int s = 0, e = n-1, ans = n;
        while(s <= e) {
            int mid = (s+e)>>1;
            if(mat[mid][0] > Element) {
                ans = mid;
                e = mid-1;
            }
            else s = mid+1;
        }
        int res = 0;
        for(int i=0; i<ans; i++) {
            res += smallElementF2(mat[i], n, Element);
        }
        return res;
    }
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        int s = mat[0][0], e = mat[n-1][n-1];
        while(s<=e) {
            int mid = (s+e)>>1;
            int smallerElement = smallElementF1(mat, n, mid);
            if(smallerElement <= k-1) s = mid+1;
            else e = mid-1;
        }
        return s;
    }
}
