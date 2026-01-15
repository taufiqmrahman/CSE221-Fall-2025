import java.io.*;
import java.util.*;

public class task6{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken()); 
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));
        long reward = 0;
        long time = 0;
        for (int[] task : tasks) {
            time += task[0]; 
            reward += task[1] - time;             
        }
        pw.println(reward);
        pw.flush();
        pw.close();
    }
}



