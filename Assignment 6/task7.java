import java.io.*;
import java.util.*;
public class task7{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        boolean[] present = new boolean[26];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
            for(char c : words[i].toCharArray()){
                present[c-'a'] = true;
            } 
        }
        int[][] Mat = new int[26][26];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        } 
        int[] indeg = new int[26];
        boolean check = true;
        for(int i = 0; i < n - 1 && check; i++){
            String a = words[i];
            String b = words[i + 1];
            int min = Math.min(a.length(), b.length());
            int k = 0;
            while(k < min&& a.charAt(k) == b.charAt(k)){
                k++;
            } 
            if(k == min){
                if(a.length() > b.length()) {
                    check = false; 
                }
                continue;
            }
            int u = a.charAt(k) -'a';
            int v = b.charAt(k)-'a';
            if(Mat[u][v] == 0){
                Mat[u][v] = 1;
                adj.get(u).add(v);
                indeg[v]++;
            }
        }
        if(!check){
            pw.println(-1);
            pw.flush();
            return;
        }
        int Count = 0;
        for(boolean p : present){
            if(p){
                Count++;
            } 
        } 
        boolean[] used = new boolean[26];
        char[] res = new char[Count];
        int idx = 0;
        while(true){
            int pick = -1;
            for(int i = 0; i < 26; i++){
                if(present[i] && !used[i] && indeg[i] == 0){
                    pick = i;
                    break; 
                }
            }
            if(pick == -1) break;
            used[pick] = true;
            res[idx++] = (char)('a' +pick);
            for(int v : adj.get(pick)){
                indeg[v]--;
            }
        }
        if(idx != Count){
            pw.println(-1);
        } 
        else {
            pw.println(new String(res));
        }
        pw.flush();
    }
}