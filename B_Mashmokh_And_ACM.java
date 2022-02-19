import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {

    static FastScanner fs = null;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
           int n = fs.nextInt();
           int k = fs.nextInt();
           int m = 1_000_000_007;
           long dp[][] = new long[k+1][n+1];

           for(int i=1;i<=n;i++){
               dp[1][i] = 1;
           }
           for(int i=2;i<=k;i++){
               for(int j=1;j<=n;j++){
                   for(int l = j;l<=n;l+=j){
                       dp[i][l] += dp[i-1][j];
                       if(dp[i][l]>m){
                           dp[i][l] -= m;
                       }
                   }

               }
           }

           long sum = 0;
           for(int i=1;i<=n;i++){
               sum =  (sum + dp[k][i])%m;
           }
           out.println(sum);
    
        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}