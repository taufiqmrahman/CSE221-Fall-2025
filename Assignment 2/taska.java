import java.io.*;
import java.util.*;

public class taska{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int arr [] = new int[x];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<x;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int l = 0;
        int r = arr.length - 1;
        boolean found = false;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                pw.println((l + 1) + " " + (r + 1));
                found = true;
                break;
            } 
            else if (sum < target) {
                l++;
            } 
            else {
                r--;
            }
        }
        if (!found) {
            pw.println(-1);
        }
        pw.flush();
        pw.close();
    }
}