import java.io.*;
import java.util.*;
public class taskh{
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int n = (k - 1) / (x - 1);
            int ans = k + n;
            pw.println(ans);
        }
        pw.flush();
        pw.close();

    }
}