import java.io.*;
import java.util.*;

public class taskb{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){   
            arr2[i] = Integer.parseInt(st3.nextToken());
        }
        int l= 0, r = m - 1;
        int min = Math.abs(arr1[0] + arr2[m-1] - k);
        int sum = 0;
        int diff = 0;
        int idx1 = 0, idx2 = m - 1;
        while (l < n && r > -1) {
            sum = arr1[l] + arr2[r];
            diff = Math.abs(sum - k);
            if (diff < min) {
                min = diff;
                idx1 = l;
                idx2 = r;
            }
            if (sum > k) {
                r--;
            } 
            else {
                l++;
            }
        }

        pw.println((idx1+1) + " " + (idx2+1));
        pw.flush();
        pw.close();
    }
}