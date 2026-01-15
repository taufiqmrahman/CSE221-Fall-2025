import java.io.*;
import java.util.*;

public class task4{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] deg = new int[n];
        st = new StringTokenizer(br.readLine());
        int[] u = new int[m];
        for(int i=0;i<m;i++){
            u[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int v = Integer.parseInt(st.nextToken()) - 1;
            int a = u[i];
            deg[a]++;
            deg[v]++;
        }

        int odd = 0;
        for(int i=0;i<n;i++){
            if((deg[i] & 1) == 1){
                odd++;
            }     
        }

        if(odd == 0 || odd == 2){
            pw.println("YES");
        } 
        else{
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }
}