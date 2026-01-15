import java.io.*;
import java.util.regex.*;

public class taskh{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        Pattern pt = Pattern.compile("^(\\w+) will departure for (\\w+) at (\\d+):(\\d+)$");
        int x = Integer.parseInt(br.readLine());
        String [] arr = new String [x];
        
        for(int i=0;i<x;i++){
            arr[i] = br.readLine();
        }
        
        for(int i=0; i<x-1; i++){
            for(int j=0; j<x-1-i; j++){
                Matcher matcher1 = pt.matcher(arr[j]);
                Matcher matcher2 = pt.matcher(arr[j+1]);
                
                if(matcher1.find() && matcher2.find()){
                    String name1 = matcher1.group(1);
                    String name2 = matcher2.group(1);
                    int hour1 = Integer.parseInt(matcher1.group(3));
                    int min1 = Integer.parseInt(matcher1.group(4));
                    int hour2 = Integer.parseInt(matcher2.group(3));
                    int min2 = Integer.parseInt(matcher2.group(4));
                    int lexi = name1.compareTo(name2);

                    if(lexi > 0){
                        String temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                    else if(lexi == 0){
                        int time1 = hour1 * 60 + min1;
                        int time2 = hour2 * 60 + min2;
                        if(time1 < time2){
                            String temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                        }
                    }
                }
            }
        }
        
        for(int k=0; k<x; k++){
            pw.println(arr[k]);
        }
        pw.flush();
        pw.close();


    }
}