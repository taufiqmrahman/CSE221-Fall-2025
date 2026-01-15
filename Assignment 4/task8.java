import java.io.*;
import java.util.*;

public class task8{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] count = new int[N+1];
        for(int i=1;i<=N;i++){
            int c = 0;
            for(int j=1;j<=N;j++){
                if(i==j){
                    continue;
                }
                if(gcd(i,j)==1){
                    c++;
                }
            }
            count[i] = c;
        }

        int[][] arr = new int[N+1][];
        for(int i=1;i<=N;i++){
            arr[i] = new int[count[i]];
        }

        for(int i=1;i<=N;i++){
            int pos = 0;
            for(int j=1;j<=N;j++){
                if(i==j){
                    continue;
                }
                if(gcd(i,j)==1){
                    arr[i][pos++] = j;
                }
            }
        }

        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if(K <= 0 || K > arr[X].length){
                pw.println(-1);
            } 
            else{
                pw.println(arr[X][K-1]);
            }
        }
        pw.flush();
        pw.close();
    }

    static int gcd(int a, int b){
        while(b!=0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}