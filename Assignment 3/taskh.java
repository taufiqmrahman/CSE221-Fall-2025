import java.io.*;
import java.util.*;

public class taskh {
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
        long[] postOrder = new long[size];
        for (int i = 0; i < size; i++) {
            postOrder[i] = Long.parseLong(st.nextToken());
        }
        preOrder(inOrder, postOrder, 0, size - 1, 0, size - 1);
        pw.flush();
        pw.close();
    }

    static void preOrder(long[] inOrder, long[] postOrder, int left_i, int right_i, int left_p, int right_p) {
        if (left_i > right_i) {
            return;
        }
        long val = postOrder[right_p];
        int root = -1;
        for (int i = left_i; i <= right_i; i++) {
            if (inOrder[i] == val) {
                root = i;
                break;
            }
        }
        pw.print(val+" ");
        int size = root - left_i;
        preOrder(inOrder, postOrder, left_i, root - 1, left_p, left_p + size - 1);
        preOrder(inOrder, postOrder, root + 1, right_i, left_p + size, right_p - 1);
    }
}