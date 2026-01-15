import java.io.*;
import java.util.*;
public class task6{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        int[][] dist = new int[n + 1][2]; 
        int x = Integer.MAX_VALUE / 4;
        for (int i = 0; i <= n; i++) {
            dist[i][0] = x;
            dist[i][1] = x;
        }
        dist[src][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            if (d > dist[u][1]){
                continue;
            }
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int nd = d + w;
                if (nd < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = nd;
                    pq.offer(new int[]{nd, v});
                } 
                else if (nd > dist[v][0] && nd < dist[v][1]) {
                    dist[v][1] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        int ans = dist[dest][1];
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