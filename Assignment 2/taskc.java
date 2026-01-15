import java.io.*;
import java.util.*;

public class taskc {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int arr[] = new int[len];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        boolean found = false;
        int[][] idx = new int[len][2];
        for (int i = 0; i < len; i++) {
            idx[i][0] = arr[i];
            idx[i][1] = i + 1;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < len - 2 && !found; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                long sum = (long) idx[i][0] + idx[l][0] + idx[r][0];
                if (sum == target) {
                    pw.println(idx[i][1] + " " + idx[l][1] + " " + idx[r][1]);
                    found = true;
                    break;
                } 
                else if (sum < target) {
                    l++;
                } 
                else {
                    r--;
                }
            }
        }

        if (!found){
            pw.println(-1);
        }
        pw.flush();
    }
}
