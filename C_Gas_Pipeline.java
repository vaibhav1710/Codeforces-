import java.net.CookieHandler;
import java.util.*;
import java.io.*;
public class fastTemp {

    static FastScanner fs = null;
     public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        outer:
        while (t-- > 0) {

            int n = fs.nextInt();
            long a = fs.nextLong();
            long b = fs.nextLong();
            String s = fs.next();
            long dp[][] = new long[n-1][2];

            // 1 --->
            long tm = b;
            for(int i=0;i<n-1;i++){
             if(s.charAt(i+1)=='0'){
                 if(i==0) {
                     dp[i][0] = tm + a + b;
                     dp[i][1] = tm + 2*a + 2*b;
                 }else{
                    if(s.charAt(i)=='1'){
                        dp[i][0] = 1_000_000_000_000_000l;
                        dp[i][1] = dp[i-1][1] + a + 2*b;
                    }else{
                        dp[i][0] = Math.min(dp[i-1][0] + a + b , dp[i-1][1] + 2*a + b);
                        dp[i][1] = Math.min(dp[i-1][0] + 2*a + 2*b , dp[i-1][1] + a + 2*b);
                    }
                 }
             }else{
                 if(i==0) {
                     dp[i][0] = 1_000_000_000_000_000l;
                     dp[i][1] = tm + 2*a + 2*b;
                 }else{
                     dp[i][0] = 1_000_000_000_000_000l;
                     dp[i][1] = Math.min(dp[i-1][0] + 2*a + 2*b , dp[i-1][1] + a + 2*b);
                 }
             }

            }
            long ans = Math.min(dp[dp.length-1][0] + a + b , dp[dp.length-1][1] + 2*a + b);
            out.println(ans);
        }
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