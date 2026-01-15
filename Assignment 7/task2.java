import java.io.*;
import java.util.*;
public class task2{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int alice = Integer.parseInt(st.nextToken());
        int bob = Integer.parseInt(st.nextToken());
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
        }
        int[] distAlice = dijkstra(graph, n, alice);
        int[] distBob = dijkstra(graph, n, bob);
        int minTime = Integer.MAX_VALUE;
        int meetNode = -1;
        for (int i = 1; i <= n; i++) {
            if (distAlice[i] != Integer.MAX_VALUE && distBob[i] != Integer.MAX_VALUE) {
                int meetingTime = Math.max(distAlice[i], distBob[i]);
                if (meetingTime < minTime) {
                    minTime = meetingTime;
                    meetNode = i;
                } 
                else if (meetingTime == minTime && i < meetNode) {
                    meetNode = i;
                }
            }
        }
        if (meetNode == -1) {
            pw.println(-1);
        } 
        else {
            pw.println(minTime + " " + meetNode);
        }
        
        pw.flush();
        pw.close();
    }
    
    static int[] dijkstra(ArrayList<int[]>[] graph, int n, int src) {
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u_node = current[0];
            int u_dist = current[1];
            if (u_dist > dist[u_node]) {
                continue;
            }
            for (int[] edge : graph[u_node]) {
                int v_node = edge[0];
                int weight = edge[1];
                if (dist[u_node] + weight < dist[v_node]) {
                    dist[v_node] = dist[u_node] + weight;
                    pq.offer(new int[]{v_node, dist[v_node]});
                }
            }
        }
        return dist;
    }
}