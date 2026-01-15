import java.io.*;
import java.util.*;
public class task2{
    public static void main(String [] args)throws Exception{
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        } 
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[n + 1];
        for(int i = 0; i <= n; i++){
            color[i] = -1;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int ans = 0;
        boolean check = true;
        for(int s = 1; s <= n; s++){
            if(color[s] != -1){
                continue;
            } 
            int c1 = 0, c2 = 0;
            color[s] = 0; c1++;
            q.add(s);
            
            while(!q.isEmpty() && check){
                int u = q.poll();
                for(int v : adj.get(u)){
                    if(color[v] == -1){
                        color[v] = 1 - color[u];
                        if(color[v] == 0){
                            c1++;
                        } 
                        else {
                            c2++;
                        }
                        q.add(v);
                    } 
                    else if(color[v] == color[u]){
                        check = false; 
                        break;
                    }
                }
            }
            ans += Math.max(c1, c2);
        }
        
        if(!check){
            pw.println(0);
        } 
        else{
            pw.println(ans);
        } 
        pw.flush();
        pw.close();
    }
}