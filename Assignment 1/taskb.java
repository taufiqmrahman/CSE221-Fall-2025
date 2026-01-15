import java.io.*;
import java.util.regex.*;

public class taskb {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int x = Integer.parseInt(br.readLine());
        Pattern pt = Pattern.compile("^calculate (\\d+) (\\W) (\\d+)$");
        
        for(int i=0; i<x;i++){
            Matcher matcher = pt.matcher(br.readLine());
            if(matcher.find()==true){
                double n1 = Double.parseDouble(matcher.group(1));
                double n2 = Double.parseDouble(matcher.group(3));
                String op = matcher.group(2);
                double ans =0;

                if(op.equals("+")){
                    ans = n1+n2;
                }
                else if(op.equals("-")){
                    ans = n1-n2;
                }
                else if(op.equals("*")){
                    ans = n1*n2;
                }
                else if(op.equals("/")){
                   ans = n1/n2;
                }
                pw.println(ans);

            }
        }
        pw.flush();
        pw.close();
    }
}