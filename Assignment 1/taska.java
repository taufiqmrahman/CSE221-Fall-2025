import java.io.*;
 
public class taska{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        
        for(int i =0; i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x%2==0){
                pw.println(x +" is an Even number.");
            }
            else{
                pw.println(x +" is an Odd number.");
            }
        }
        pw.flush();
        pw.close();
    }
}