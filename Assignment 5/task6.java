import java.io.*;
import java.util.*;

public class task6{
    static boolean check = false;
    static int[] color;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out); 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !check) {
                dfs(i);
            }
        }

        if (check) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }

    static void dfs(int u) {
        color[u] = 1; 
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (color[v] == 1) {
                check = true;
                return;
            }
            if (color[v] == 0) {
                dfs(v);
            }
        }
        color[u] = 2; 
    }
}