import java.io.*;
import java.util.*;
public class task1{
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
        st =new StringTokenizer(br.readLine());
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < m; i++) {
            graph[u[i]].add(new int[]{v[i], w[i]});
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u_node = current[0];
            int u_dist = current[1];
            if (u_dist > dist[u_node]){
                continue;
            } 
            for (int[] edge : graph[u_node]) {
                int v_node = edge[0];
                int weight = edge[1];
                if (dist[u_node] + weight < dist[v_node]) {
                    dist[v_node] = dist[u_node] + weight;
                    parent[v_node] = u_node;
                    pq.offer(new int[]{v_node, dist[v_node]});
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[dest]);
            ArrayList<Integer> path = new ArrayList<>();
            int current = dest;
            while (current != -1) {
                path.add(current);
                current = parent[current];
            }
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                pw.print(path.get(i));
                if (i < path.size() - 1){
                    pw.print(" ");
                }
            }
            pw.println();
        }
        
        pw.flush();
        pw.close();
    }
}