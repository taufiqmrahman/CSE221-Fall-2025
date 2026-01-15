import java.io.*;
public class taskc{
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            Long x = Long.parseLong(br.readLine());
            Long sum = (x*(x+1))/2;
            pw.println(sum);
        }
        pw.flush();
        pw.close();
    }
}