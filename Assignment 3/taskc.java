import java.io.*;
import java.util.*;

public class taskc{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = 107;
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
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
        pw.println(ans);
        pw.flush();
        pw.close();

    }
}