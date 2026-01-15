import java.io.*;
import java.util.*;
public class taskd{
    static final long mod = (100000000L+7L);
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a_11 = Long.parseLong(st.nextToken());
            long a_12 = Long.parseLong(st.nextToken());
            long a_21 = Long.parseLong(st.nextToken());
            long a_22 = Long.parseLong(st.nextToken());
            long x = Long.parseLong(br.readLine());
            long[][] A = {{a_11, a_12}, {a_21, a_22}};
            long[][] res = pow(A, x);
            pw.println(res[0][0] + " " + res[0][1]);
            pw.println(res[1][0] + " " + res[1][1]);
        }
        pw.flush();
        pw.close();
    }
    static long[][] mul(long[][] A, long[][] B){
        long[][] C = new long[2][2];
        long c_00 = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        long c_01 = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        long c_10 = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        long c_11 = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        C[0][0] = c_00 % mod;
        C[0][1] = c_01 % mod;
        C[1][0] = c_10 % mod;
        C[1][1] = c_11 % mod;
        return C;
    }
    static long[][] pow(long[][] A, long x){
        long[][] res = {{1,0},{0,1}};
        while(x > 0){
            if(x % 2 == 1){
                res = mul(res, A);
            }
            A = mul(A, A);
            x = x/2;
        }
        return res;
    }
}