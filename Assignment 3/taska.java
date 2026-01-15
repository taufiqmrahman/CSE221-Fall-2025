import java.io.*;
import java.util.*;

public class taska{
    public static void main(String [] args)throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);
       int size = Integer.parseInt(br.readLine());
       int arr [] = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        int[] ans = MERGE(arr);
        pw.println(count);
        for(int i = 0; i < ans.length; i++){
            pw.print(ans[i]+ " ");
        }
        pw.println();
        pw.flush();
        pw.close();
    }

    static long count = 0;
    static int[] MERGE(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = new int[mid];
        for(int i=0;i<mid;i++){
            left[i]= arr[i];
        }
        int[] right = new int[arr.length - mid];
        for(int i=mid;i<arr.length;i++){
            right[i-mid]= arr[i];
        }
        left = MERGE(left);
        right = MERGE(right);
        return merge(left, right);
    }

    static int[] merge(int[] a, int[] b){
        int n = a.length, m = b.length;
        int[] ans = new int[n + m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(a[i] <= b[j]){
                ans[k++] = a[i++];
            } 
            else {
                ans[k++] = b[j++];
                count += (n - i); 
            }
        }
        while(i < n){
            ans[k++] = a[i++];
        }
        while(j < m) {
            ans[k++] = b[j++];
        }
        return ans;
    }
}