import java.io.*;
import java.util.*;
public class task2{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        Union uf = new Union(n);
        long count = 0;
        int used = 0;
        for (int[] edge : edges) {
            if (uf.unionF(edge[0], edge[1])) {
                count += edge[2];
                used++;
                if (used ==(n - 1)) {
                    break;
                }
            }
        }
        pw.println(count);
        pw.flush();
        pw.close();
    }
}
class Union{
    int[] parent;
    int[] rank;
    public Union(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean unionF(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } 
        else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } 
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}


