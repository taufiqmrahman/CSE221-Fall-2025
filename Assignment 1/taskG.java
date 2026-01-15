import java.io.*;
import java.util.*;
public class taskG{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        int test = Integer.parseInt(br.readLine());

        for(int i=0;i<test;i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id[] = new int[n];
            for(int j=0;j<n;j++){
                id[j]=Integer.parseInt(st.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int marks[] = new int[n];
            for(int j=0;j<n;j++){
                marks[j]=Integer.parseInt(st2.nextToken());
            }
            
            int count = 0;
            for(int j=0; j<n-1; j++){
                int max = j;
                for(int k=j+1; k<n; k++){
                    if(marks[k] > marks[max]){
                        max = k;
                    }
                    else if(marks[k] == marks[max]){
                        if(id[k] < id[max]){
                            max = k;
                        }
                    }
                }
                if(max!= j){
                    int temp1 = marks[j];
                    marks[j] = marks[max];
                    marks[max] = temp1;
                    int temp2 = id[j];
                    id[j] = id[max];
                    id[max] = temp2;
                    count++;
                }
            }
            pw.println("Minimum swaps: " + count);
            for(int j=0; j<n; j++){
                pw.println("ID: " + id[j] + " Mark: " + marks[j]);
            }
        }
        pw.flush();
        pw.close();
    }
}