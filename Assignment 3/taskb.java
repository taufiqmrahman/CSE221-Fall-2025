import java.io.*;
import java.util.*;

public class taskb {
    private static long count = 0; 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
            
            int size = Integer.parseInt(br.readLine());
            long[] arr = new long[size]; 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr[i] = Long.parseLong(st.nextToken()); 
            }
            MERGE(arr); 
            pw.println(count);
            pw.flush();
        }
    private static long[] MERGE(long[] arr) { 
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        long[] left = new long[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        long[] right = new long[arr.length - mid];
        for (int i = mid; i < arr.length; i++) { 
            right[i - mid] = arr[i];
        }
        left = MERGE(left);
        right = MERGE(right);
        return merge(left, right);
    }

    private static long[] merge(long[] a, long[] b) { 
        int n = a.length, m = b.length;
        long[] ans = new long[n + m];
        
        if (m > 0) {
            Long[] absB = new Long[m];
            for (int i = 0; i < m; i++) {
                absB[i] = Math.abs(b[i]);
            }
            Arrays.sort(absB);
            int r = 0;
            for (int l = 0; l < n; l++) {
                if (a[l] <= 0) continue;
                while (r < m) {
                    long v = absB[r];
                    long sq = v * v;
                    if (sq < a[l]){
                        r++;
                    } 
                    else{
                        break;
                    }
                }
                count += r;
            }
        }

        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                ans[k++] = a[i++];
            } 
            else {
                ans[k++] = b[j++];
            }
        }
        while (i < n) {
            ans[k++] = a[i++];
        }
        while (j < m) {
            ans[k++] = b[j++];
        }
        
        return ans;
    }
}