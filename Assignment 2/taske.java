import java.io.*;
import java.util.*;
public class taske{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ) {
            a[i++] = Integer.parseInt(st2.nextToken());
        }
        int left = 0;
        int sum = 0;
        int best = 0;
        for (int right = 0; right < n; right++) {
            sum += a[right];
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            best = Math.max(best, right - left + 1);
        }

        pw.println(best);
        pw.flush();
        pw.close();
    }
}