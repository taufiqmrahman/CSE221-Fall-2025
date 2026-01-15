import java.io.*;
import java.util.*;

public class task2 {
    static int[] arr;
    static ArrayList<Integer>[] adj;
    static PrintWriter pw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        if (m > 0) {
            int[] u = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            int[] v = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) { 
                v[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                adj[u[i]].add(v[i]);
                adj[v[i]].add(u[i]);
            }
        }

        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = 0;
        }
        dfs(1);
        pw.println();
        pw.flush();
        pw.close();
    }

    static void dfs(int u) {
        arr[u] = 1;
        pw.print(u);
        pw.print(" ");     
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (arr[v] == 0) {
                dfs(v);
            }
        }
    }
}