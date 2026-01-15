import java.io.*;
import java.util.*;
public class task5{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] u = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[u[i]].add(new int[]{v[i], w[i]});
        }

        int[][] dist = new int[n + 1][2];
        int x = Integer.MAX_VALUE / 4;
        for (int i = 0; i <= n; i++) {
            dist[i][0] = x;
            dist[i][1] = x;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int[] edge : graph[1]) {
            int to = edge[0];
            int wt = edge[1];
            int p = wt & 1;
            if (wt < dist[to][p]) {
                dist[to][p] = wt;
                pq.offer(new int[]{wt, to, p});
            }
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int uNode = cur[1];
            int parity = cur[2];
            if (d != dist[uNode][parity]){
                continue;
            } 
            for (int[] edge : graph[uNode]) {
                int to = edge[0];
                int wt = edge[1];
                int p2 = wt & 1;
                if (p2 == parity){
                    continue;
                } 
                int nd = d + wt;
                if (nd < dist[to][p2]) {
                    dist[to][p2] = nd;
                    pq.offer(new int[]{nd, to, p2});
                }
            }
        }
        int ans = Math.min(dist[n][0], dist[n][1]);
        if (ans >= x) {
            pw.println(-1);
        } 
        else {
            pw.println(ans);
        }
        pw.flush();
        pw.close();
    }
}