import java.io.*;
import java.util.*;

public class task3 {
    static ArrayList<ArrayList<int[]>> graph;
    static int[] pt;
    static int[] size;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{u, v, w});
        }
        graph = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        pt = new int[n + 1];
        size = new int[n + 1];
        for(int i = 1; i <= n; i++){
            pt[i] = i;
            size[i] = 1;
        }
        ArrayList<int[]> unused = new ArrayList<>();
        long weight=0;
        int count=0;
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(find(u) != find(v)){
                union(u, v);
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
                weight += w;
                count++;
            } 
            else {
                unused.add(edge);
            }
        }
        if(count != n - 1){
            pw.println("-1");
            pw.flush();
            pw.close();
            return;
        }
        long min = Long.MAX_VALUE;
        for(int i = 0; i < unused.size(); i++){
            int[] edge = unused.get(i);
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int[] maxEdges = maxEdge(u, v, n);
            int max1 = maxEdges[0];
            int max2 = maxEdges[1];
            long increase = Long.MAX_VALUE;
            if(w > max1){
                increase = w - max1;
            } 
            else if(w == max1){
                if(max2 != -1){
                    increase = w - max2;
                }
            }
            if(increase != Long.MAX_VALUE && increase > 0){
                min = Math.min(min, increase);
            }
        }
        if(min == Long.MAX_VALUE){
            pw.println("-1");
        } 
        else {
            pw.println(weight + min);
        }
        pw.flush();
        pw.close();
    }
    public static void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if(root1 != root2){
            if(size[root1] < size[root2]){
                int temp = root1;
                root1 = root2;
                root2 = temp;
            }

            pt[root2] = root1;
            size[root1] += size[root2];
        }
    }
    
    public static int find(int i) {
        if(pt[i] == i){
            return i;
        }
        pt[i] = find(pt[i]);
        return pt[i];
    }
    public static int[] maxEdge(int start, int end, int n) {
        int[] node = new int[n + 1];
        int[] weight= new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        node[start] = -1;
        boolean found = false;
        while(!q.isEmpty()){
            int u = q.poll();
            if(u == end){
                found = true;
                break;
            }
            for(int i = 0; i < graph.get(u).size(); i++){
                int[] edge = graph.get(u).get(i);
                int v = edge[0];
                int w = edge[1];
                if(!visited[v]){
                    visited[v] = true;
                    node[v] = u;
                    weight[v] = w;
                    q.offer(v);
                }
            }
        }
        if(!found){
            return new int[]{-1, -1};
        } 
        int max1 = -1;
        int max2 = -1;
        int curr = end;
        while(curr != start){
            int w = weight[curr];
            if(max2 < w){
                if(max1 < w){
                    max2 = max1;
                    max1 = w;
                } 
                else {
                    max2 = w;
                }
            }
            curr = node[curr];
        } 
        return new int[]{max1, max2};
    }
}