import java.io.*;
import java.util.*;
public class taskd{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int x =Integer.parseInt(br.readLine());

        for(int i=0; i<x;i++){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean result = true;
            for(int k=0;k<arr.length-1;k++){
                if(arr[k]>arr[k+1]){
                    result = false;
                    break;
                }
            }
            if(result){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }
        pw.flush();
        pw.close();

    }
}