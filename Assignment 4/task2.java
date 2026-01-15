import java.io.*;
import java.util.*;
public class task2{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertice = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        Graph[] G = new Graph[vertice];
        int[] u = new int[edge];
        int[] v = new int[edge];
        int[] w = new int[edge];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<edge;i++){
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<edge;i++){
            v[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<edge;i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<edge;i++){
            int src = u[i]-1;
            int dest = v[i]-1;
            insert(src, dest, w[i], G);
        }
        print(G);
    }
    public static void insert(int src, int dest, int weight, Graph[] G){
        Graph vertex = new Graph(src,dest,weight);
        if(G[src]==null){
            G[src] = vertex;
        }
        else{
            Graph temp = G[src];
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = vertex;
        }
    }
    public static void print(Graph list[]){
        for(int i=0; i<list.length;i++){
            Graph temp = list[i];
            System.out.print((i+1)+ ": ");
            if (temp == null) {
                System.out.println();
                continue;
            }
            while(temp != null){
                System.out.print("(" + (temp.dest+1) +","+ temp.weight +")");
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static class Graph{
    int source;
    int dest;
    int weight;
    Graph next;

    Graph(int source, int dest, int weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
        this.next = null;
    }
    }
    
}
