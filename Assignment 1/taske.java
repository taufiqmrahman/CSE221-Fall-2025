import java.io.*;
import java.util.*;
public class taske{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        String [] moves = new String [n*n];
        int count =0;

        for(int x=0;x<n;x++){
            for (int i = 0;i<n-2;i++){
                if(arr[i]>arr[i+2]){
                int temp = arr[i];
                arr[i] = arr[i+2];
                arr[i+2] = temp;
                moves[count] = (i+1) + " " + (i+3);
                count++;
            }
        }
        }
        Boolean check = true;
        for(int k=0;k<n-1;k++){
            if(arr[k]>arr[k+1]){
                check = false;
                break;
            }
        }
        if(check){
            pw.println("YES");
            pw.println(count);
            for(int i=0;i<count;i++){
                pw.println(moves[i]);
            }
        } 
        else {
            pw.println("NO");
        }
        pw.flush();
        pw.close();
    }
}