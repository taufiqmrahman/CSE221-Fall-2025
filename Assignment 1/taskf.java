import java.io.*;
import java.util.*;
public class taskf{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i< n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if((arr[j]%2==0 && arr[j+1]%2==0)||(arr[j]%2!=0 && arr[j+1]%2!=0)){
                    if(arr[j]>arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        for(int x=0;x<arr.length;x++){
            if(x==arr.length-1){
                pw.print(arr[x]);
            }
            else{
                pw.print(arr[x]+ " ");
            }
            
        }
        pw.flush();
        pw.close();
    }
}