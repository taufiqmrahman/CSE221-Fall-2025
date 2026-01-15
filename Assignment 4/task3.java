import java.io.*;
import java.util.*;

public class task3{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0;j<k;j++){
                int dest = Integer.parseInt(st.nextToken());
                matrix[i][dest] = 1;
            }
        }
        PrintWriter pw = new PrintWriter(System.out);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pw.print(matrix[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}