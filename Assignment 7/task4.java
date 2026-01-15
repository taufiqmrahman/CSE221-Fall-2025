    import java.io.*;
    import java.util.*;
    public class task4{
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int[] weight = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
            }
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[src] = weight[src];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            pq.offer(new int[]{src, dist[src]});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0];
                int d = cur[1];
                if (visited[u]){
                    continue;
                } 
                visited[u] = true;
                if (u == dest){
                    break;
                }
                for (int v : graph[u]) {
                    if (visited[v]){
                        continue;
                    } 
                    int nd = d + weight[v];
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        pq.offer(new int[]{v, nd});
                    }
                }
            }
        if (dist[dest] == Integer.MAX_VALUE) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[dest]);
        }
        pw.flush();
        pw.close();
    }
}