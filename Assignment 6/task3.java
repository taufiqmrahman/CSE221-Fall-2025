import java.io.*;
import java.util.*;
public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;
        if (x1 == x2 && y1 == y2) {
            pw.println(0);
            pw.flush();
            return;
        }
        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
        int total = N * N;
        int[] dist = new int[total];
        for (int i = 0; i < total; i++){
            dist[i] = -1;
        } 
        int[] q = new int[total];
        int head = 0, tail = 0;
        int start = x1 * N + y1;
        int tgt = x2 * N + y2;
        q[tail++] = start;
        dist[start] = 0;

        while (head < tail) {
            int id = q[head++];
            int cx = id / N;
            int cy = id % N;
            int nd = dist[id] + 1;
            for (int k = 0; k < 8; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                } 
                int pos = nx * N + ny;
                if (dist[pos] != -1){
                    continue;
                } 
                dist[pos] = nd;
                if (pos == tgt) {
                    pw.println(nd);
                    pw.flush();
                    return;
                }
                q[tail++] = pos;
            }
        }

        pw.println(-1);
        pw.flush();
    }
}
