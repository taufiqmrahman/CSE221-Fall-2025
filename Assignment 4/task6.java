import java.io.*;
import java.util.*;

public class task6{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int[][] moves = new int[8][2];
        int count = 0;
        for(int k=0;k<8;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                moves[count][0] = nx;
                moves[count][1] = ny;
                count++;
            }
        }
        pw.println(count);
        for(int i=0;i<count;i++){
            pw.println(moves[i][0] + " " + moves[i][1]);
        }
        pw.flush();
        pw.close();
    }
}