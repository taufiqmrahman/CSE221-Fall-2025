import java.io.*;
import java.util.*;
public class task3{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        int[] danger = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            danger[i] = Integer.MAX_VALUE;
        }
        danger[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int curD = cur[1];
            if (visited[u]){
                continue;
            } 
            visited[u] = true;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int pathD = Math.max(curD, w);
                if (pathD < danger[v]) {
                    danger[v] = pathD;
                    pq.offer(new int[]{v, danger[v]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (danger[i] == Integer.MAX_VALUE) {
                pw.print(-1);
            } 
            else {
                pw.print(danger[i]);
            }
            if (i < n){
                pw.print(" ");
            } 
        }
        pw.println();
        pw.flush();
        pw.close();
    }
}