import java.io.*;
import java.util.*;

public class taskg{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());
        int arr[] = new int[size];
        StringTokenizer st2= new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for(int j=0;j<queries;j++){
            StringTokenizer st3= new StringTokenizer(br.readLine());
            int count =0;
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());
            int start = lower_bound(arr, x);
            int end = upper_bound(arr, y);
            count = end - start;
            pw.println(count);

        }
        pw.flush();
        pw.close();
        
    }
    public static int lower_bound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        int result = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                result = mid;
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return result;
    }
    public static int upper_bound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        int result = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                result = mid;
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return result;
    }
}
