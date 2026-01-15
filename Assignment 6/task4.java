import java.io.*;
import java.util.*;
public class task4 {
    static List<Integer>[] g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer>[] tmp = (List<Integer>[]) new ArrayList[n + 1];
        g = tmp;
        for (int i = 1; i <= n; i++){
            g[i] = new ArrayList<>();
        } 
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }
        int[] a = bfs(1, n);    
        int[] b = bfs(a[0], n); 

        pw.println(b[1]);
        pw.println(a[0] + " " + b[0]);
        pw.flush();
        pw.close();
    }
    public static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);
        int BNode = start, BDist = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            int du = dist[u];
            if (du > BDist) { 
                BDist = du; 
                BNode = u;
            }
            for (int v : g[u]) {
                if (dist[v] == -1) {
                    dist[v] = du + 1;
                    q.add(v);
                }
            }
        }
        return new int[]{BNode, BDist};
    }
}

