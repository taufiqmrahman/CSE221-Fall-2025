import java.io.*;
import java.util.*;

public class taskf {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] freq = new int[n + 1]; 
        int left = 0; 
        int max = 0; 
        int Count = 0; 
        for (int right = 0; right < n; right++) {
            int x = a[right];
            if (freq[x] == 0) {
                Count++;
            }
            freq[x]++;
            while (Count > k) {
                int y = a[left];
                freq[y]--;
                if (freq[y] == 0) {
                    Count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        pw.println(max);
        pw.flush();
        pw.close();
    }
}