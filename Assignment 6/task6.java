import java.io.*;
import java.util.*;
public class task6{
    private static boolean[] ERA(int n){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int p = 2; p * p <= n; p++){
            if(prime[p]){
                for(int x = p * p; x <= n; x += p) prime[x] = false;
            }
        }
        return prime;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int MAX = 5000;
        boolean[] isPrime = ERA(MAX);
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= MAX; i++){
            if(isPrime[i]){
                primes.add(i);
            } 
        } 
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(s == t){
                pw.println(0);
                continue;
            }
            if(s > t){
                pw.println(-1);
                continue;
            }
            int ans = bfs(s, t, primes, isPrime);
            pw.println(ans);
        }
        pw.flush();
        pw.close();
    }
    public static int bfs(int s, int t, List<Integer> primes, boolean[] isPrime){
        int[] dist = new int[t + 1];
        for(int i = 0; i <= t; i++){
            dist[i] = -1;
        } 
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[s] = 0;
        q.add(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            int d = dist[cur];
            for(int pf : primeFactors(cur, primes, isPrime)){
                int nxt = cur + pf;
                if(nxt > t) {
                    continue;
                }
                if(dist[nxt] == -1){
                    dist[nxt] = d + 1;
                    if(nxt == t){
                        return dist[nxt];
                    } 
                    q.add(nxt);
                }
            }
        }
        return -1;
    }

    private static List<Integer> primeFactors(int n, List<Integer> primes, boolean[] isPrime){
        List<Integer> factors = new ArrayList<>();
        int temp = n;
        for(int p : primes){
            if(p * p > temp){
                break;  
            } 
            if(temp % p == 0){
                factors.add(p);
                while(temp % p == 0){
                    temp /= p;
                } 
            }
        }
        if(temp > 1 && temp != n){
            factors.add(temp);
        } 
        return factors;
    }
}