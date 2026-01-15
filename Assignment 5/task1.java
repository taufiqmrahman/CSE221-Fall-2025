import java.io.*;
import java.util.*;

public class task1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] head = new int[n + 1];
        for (int i = 0; i < head.length; i++){
            head[i] = -1;
        }
        int[] src = new int[2 * m];
        int[] dest = new int[2 * m];
        int edge = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dest[edge] = v;
            src[edge] = head[u];
            head[u] = edge++;

            dest[edge] = u;
            src[edge] = head[v];
            head[v] = edge++;
        }

        boolean[] vis = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        vis[1] = true;
        q.add(1);

        boolean first = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (first) {
                pw.print(cur);
                first = false;
            } 
            else {
                pw.print(" " + cur);
            }
            for (int x = head[cur]; x != -1; x = src[x]) {
                int j = dest[x];
                if (!vis[j]) {
                    vis[j] = true;
                    q.add(j);
                }
            }
        }
        pw.println();
        pw.flush();
        pw.close();
    }
}