import java.io.*;
import java.util.*;
 
public class task5{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Task[] tasks = new Task[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                tasks[j] = new Task(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(tasks, Comparator.comparingInt(e -> e.y));
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int finished = 0;
            int used = 0;
            for (Task m : tasks) {
                Integer best = map.lowerKey(m.x);
                if (best != null) {
                    finished++;
                    int count = map.get(best);
                    if (count == 1) {
                        map.remove(best);
                    } 
                    else {
                        map.put(best, count - 1);
                    }
                    map.put(m.y, map.getOrDefault(m.y, 0) + 1);
                } 
                else if (used< M) {
                    finished++;
                    used++;
                    map.put(m.y, map.getOrDefault(m.y, 0) + 1);
                }
               
            }
            sb.append(finished).append("\n");
        }
        System.out.print(sb);
    }
    static class Task {
        int x, y;
        Task(int x, int y) { 
            this.x = x; 
            this.y = y; 
        }
    }
}