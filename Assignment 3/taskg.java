import java.io.*;
import java.util.*;
 
public class taskg {
    static int preIdx = 0;
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] inOrder = new long[size];
        for (int i = 0; i < size; i++) {
            inOrder[i] = Long.parseLong(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        long[] preOrder = new long[size];
        for (int i = 0; i < size; i++) {
            preOrder[i] = Long.parseLong(st.nextToken());
        }
        postOrder(inOrder, preOrder, 0, size - 1);
        pw.flush();
        pw.close();
    }
 
    static void postOrder(long[] inOrder, long[] preOrder, int start_i, int end_i) {
        if (start_i > end_i) {
            return;
        }
        long val = preOrder[preIdx++];
        int root = -1;
        for (int i = start_i; i <= end_i; i++) {
            if (inOrder[i] == val) {
                root = i;
                break;
            }
        }
        postOrder(inOrder, preOrder, start_i, root - 1);
        postOrder(inOrder, preOrder, root + 1, end_i);
        pw.print(val + " ");
    }
}