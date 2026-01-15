import java.io.*;
import java.util.*;

public class task5 {
    static ArrayList<Integer>[] adj;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        size = new int[n + 1];
        dfs(r, -1);

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            pw.println(size[x]);
        }
        pw.flush();
        pw.close();
    }
    static int dfs(int u, int parent) {
        size[u] = 1;
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (v != parent) {
                size[u] += dfs(v, u);
            }
        }
        return size[u];
    }
}