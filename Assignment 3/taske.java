import java.io.*;
import java.util.*;

public class taske {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int test = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long ans = solve(a, n, m);
            pw.println(ans);
        }
        pw.flush();
        pw.close();
        br.close();
    }
    static long power(long a, long b, long m) {
        long ans = 1;
        while(b>=1){
            if(b%2!=0){
                ans = (ans*a)%m;
                b--;
            } 
            else {
                a = (a*a)%m;
                b = b/2;
            }
        }
        return ans;
    }
    static long solve(long a, long n, long m) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return a % m;
        }

        long k = n / 2;
        long x = solve(a, k, m);
        long y = power(a, k, m);
        long result = 0;

        if (n % 2 == 0) {
            result = (x * (1 + y)) % m;
        }
        else {
            long x1 = (x * (1 + y)) % m; 
            long x2 = (y * y) % m; 
            x2 = (x2 * a) % m;
            result = (x1 + x2) % m;
        }
        if (result < 0) {
            result += m;
        }
        return result;
    }

    
}