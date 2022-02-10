
import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {
    static FastScanner fs = null;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
           int  n = fs.nextInt();
           int l = fs.nextInt();
           int k = fs.nextInt();

          int mark[] = new int[n+1];
          for(int i=0;i<=n;i++){
              if(i!=n) {
                  mark[i] = fs.nextInt();
              }else{
                  mark[i] = l;
              }
          }
          int speedlimit[] = fs.readArray(n);
           long dp[][] = new long[n+1][k+1];
           for(int i=0;i<=n;i++){
               Arrays.fill(dp[i],Integer.MAX_VALUE);
           }
           dp[0][0] = 0;
           for (int i=1;i<=n;i++){
               dp[i][0] = dp[i-1][0] + (mark[i]-mark[i-1])*speedlimit[i-1];
           }
           long ans = dp[n][0];
           for(int i=1;i<=k;i++) {
               for (int j = 1; j <= n; j++) {
                   int h = 0;
                   while (h <= Math.min(i, j - 1)) {
                       dp[j][i] = Math.min(dp[j][i], (mark[j] - mark[j - 1 - h]) * speedlimit[j - 1 - h] + dp[j - 1 - h][i - h]);
                       h++;
                   }
                   if (j == n) {
                       ans = Math.min(ans, dp[j][i]);
                   }
               }
           }
        
           out.println(ans);
        out.close();
    }

//dp[i-3][j-2]
       //dp[i-2][j-1]
               // dp[i-1][j]
              // dp[i][j]
  

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