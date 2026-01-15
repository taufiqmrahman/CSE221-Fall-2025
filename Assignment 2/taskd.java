import java.io.*;
import java.util.*;
public class taskd{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int [] arr2 = new int[m];
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st2.nextToken());
        }
        int [] result = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr[i] <= arr2[j]) {
                result[k++] = arr[i++];
            } 
            else {
                result[k++] = arr2[j++];
            }
        }
        while (i < n){
            result[k++] = arr[i++];
        } 

        while (j < m){
            result[k++] = arr2[j++];
        }

        for (int p = 0; p < result.length; p++) {
            pw.print(result[p]+" ");
        }
        pw.flush();
        pw.close();
    }
}