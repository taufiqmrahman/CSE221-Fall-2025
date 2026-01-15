import java.io.*;
import java.util.*;
public class task1{
    public static void main(String [] args)throws Exception{
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        int[] in_D = new int[n + 1];
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            in_D[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(in_D[i] == 0){
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int course = queue.poll();
            result.add(course);
            List<Integer> dp = adj.get(course);
            for(int i = 0; i < dp.size(); i++){
                int dependent = dp.get(i);
                in_D[dependent]--;
                if(in_D[dependent] == 0){
                    queue.add(dependent);
                }
            }
        }
        if(result.size()!= n){
            pw.println(-1);
        } 
        else {
            for(int i = 0; i < n; i++){
                if(i > 0){
                    pw.print(" ");
                } 
                pw.print(result.get(i));
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}