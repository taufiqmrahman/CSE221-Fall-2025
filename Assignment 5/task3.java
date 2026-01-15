import java.io.*;
import java.util.*;

public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); 
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        if (m > 0) {
            int[] u = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <m; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            int[] v = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<m; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                adj[u[i]].add(v[i]);
                adj[v[i]].add(u[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (adj[i].size() > 0) {
                int[] temp = new int[adj[i].size()];
                for (int j = 0; j < adj[i].size(); j++) {
                    temp[j] = adj[i].get(j);
                }
                Arrays.sort(temp);
                adj[i].clear();
                for (int j = 0; j < temp.length; j++) {
                    adj[i].add(temp[j]);
                }
            }
        }
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
            parent[i] = -1;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                int neighbor = adj[curr].get(i);
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    parent[neighbor] = curr;
                    q.add(neighbor);
                }
            }
        }

        if (dist[d] == -1) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[d]);
            ArrayList<Integer> path = new ArrayList<>();
            int node = d;
            while (node != -1) {
                path.add(node);
                node = parent[node];
            }
            for (int i = 0; i < path.size() / 2; i++) {
                int temp = path.get(i);
                path.set(i, path.get(path.size() - 1 - i));
                path.set(path.size() - 1 - i, temp);
            }
            for (int i = 0; i < path.size(); i++) {
                if (i > 0){
                    pw.print(" ");
                } 
                pw.print(path.get(i));
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}