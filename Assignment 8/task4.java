import java.io.*;
import java.util.*;

public class task4{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> selected = new ArrayList<>();
        int last = -1;
        for (int[] interval : intervals) {
            if (interval[0] > last) {
                selected.add(interval);
                last = interval[1];
            }
        }
        pw.println(selected.size());
        for (int[] task : selected) {
            pw.println(task[0] + " " + task[1]);
        }
        pw.flush();
        pw.close();
    }
}



