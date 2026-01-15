import java.io.*;
import java.util.*;

public class task7{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int r = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char[][] grid = new char[r][];
        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] vis = new boolean[r][h];
        int maxD = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < h; j++) {
                if (!vis[i][j] && grid[i][j] != '#') {
                    int diamonds = bfs(i, j, grid, vis);
                    maxD = Math.max(maxD, diamonds);
                }
            }
        }
        pw.println(maxD);
        pw.flush();
        pw.close();
    }

    static int bfs(int sr, int sc, char[][] grid, boolean[][] vis) {
        int r = grid.length;
        int h = grid[0].length;
        int diamonds = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            if (grid[row][col] == 'D'){
                diamonds++;
            }

            for (int k = 0; k < 4; k++) {
                int new_r = row + dir[k][0];
                int new_c = col + dir[k][1];

                if (new_r >= 0 && new_r < r && new_c >= 0 && new_c < h &&
                    !vis[new_r][new_c] && grid[new_r][new_c] != '#') {
                    vis[new_r][new_c] = true;
                    q.add(new int[]{new_r, new_c});
                }
            }
        }
        return diamonds;
    }
}