import java.io.*;
import java.util.*;

public class task7{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[n+1][m+1];
        int[] xs = new int[k];
        int[] ys = new int[k];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xs[i] = x;
            ys[i] = y;
            check[x][y] = true;
        }

        int[] dx = {-2,-2,-1,-1,1,1,2,2};
        int[] dy = {-1,1,-2,2,-2,2,-1,1};
        boolean found = false;
        for(int i=0; i<k && !found;i++){
            int x = xs[i], y = ys[i];
            for(int d=0; d<8; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m){
                    if(check[nx][ny]){ 
                        found = true;
                        break;
                    }
                }
            }
        }
        if(found){
            pw.println("YES");
        } 
        else{
            pw.println("NO");
        }
        pw.flush();
        pw.close();
    }
}