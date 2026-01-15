    import java.io.*;
    import java.util.*;
    public class task5{
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            List<Integer>[] g = (List<Integer>[]) new ArrayList[n + 1];
            for(int i = 1; i <= n; i++){
                g[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g[u].add(v);
                g[v].add(u);
            }
            st = new StringTokenizer(br.readLine());
            int[] sources = new int[s];
            for(int i = 0; i < s; i++){
                sources[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] dest = new int[q];
            for(int i = 0; i < q; i++){
                dest[i] = Integer.parseInt(st.nextToken());
            }

            int[] dist = new int[n + 1];
            for(int i = 0; i <= n; i++){
                dist[i] = -1;
            }

            ArrayDeque<Integer> bfs = new ArrayDeque<>();
            for(int src : sources){
                if(dist[src] == -1){
                    dist[src] = 0;
                    bfs.add(src);
                }
            }
            while(!bfs.isEmpty()){
                int u = bfs.poll();
                int du = dist[u];
                for(int v : g[u]){
                    if(dist[v] == -1){
                        dist[v] = du + 1;
                        bfs.add(v);
                    }
                }
            }
            for(int i = 0; i < q; i++){
                int ans = dist[dest[i]];
                pw.print(ans);
                pw.print(" ");
            }
            pw.println();
            pw.flush();
            pw.close();
        }
    }