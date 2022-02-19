import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {

    static FastScanner fs = null;

    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
           int n = fs.nextInt();
         long up [] = new long[n];
         long dw[] = new long[n];
         
         for(int i=0;i<n;i++){
             up[i] = fs.nextLong();
         }
        for(int i=0;i<n;i++){
            dw[i] = fs.nextLong();
        }
         long dp[][] = new long[2][n];
         dp[0][0] = up[0];
         dp[1][0] = dw[0];

         long dm = dp[1][0];
         long um = dp[0][0];

         for(int i=1;i<n;i++){
             dp[0][i] = up[i] + dm;
             dp[1][i] = dw[i] + um;
             dm = Math.max(dm,dp[1][i]);
             um = Math.max(um,dp[0][i]);
         }

         out.println(Math.max(dm,um));
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

long[] readlongArray(int n){
long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}