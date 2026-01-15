import java.io.*;
import java.util.*;

public class task5{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] diff = new int[n]; 

        if(m > 0){
            int[] u = new int[m];
            int[] v = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                u[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                v[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for(int i=0;i<m;i++){
                int a = u[i];
                int b = v[i];
                if(a>=0 && a<n){
                    diff[a] -= 1;
                }  
                if(b>=0 && b<n) {
                    diff[b] += 1;
                } 
            }
        }

        for(int i=0;i<n;i++){
            if(i>0){
                pw.print(" ");
            }
            pw.print(diff[i]);
        }
        pw.println();
        pw.flush();
        pw.close();
    }
}