import java.io.*;
import java.util.*;
public class task1{
    public static void insert(int src, int dest, int weight, int[][]graph){
        graph[src-1][dest-1] = weight;
    }
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertice = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[][] graph = new int[vertice][vertice];
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            insert(u, v, w, graph);
        }
        for(int i=0;i<vertice;i++){
            for(int j=0;j<vertice;j++){
                pw.print(graph[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();

    }
}