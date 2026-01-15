import java.io.*;
import java.util.*;

public class taskf {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        BST(arr, 0, size - 1);
        pw.flush();
        pw.close();
    }

    public static void BST(long[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        pw.print(arr[mid] + " ");
        BST(arr, low, mid - 1);
        BST(arr, mid + 1, high);
    }
}