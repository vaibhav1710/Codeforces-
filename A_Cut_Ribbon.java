import java.net.CookieHandler;
import java.util.*;
import java.io.*;
public class fastTemp {

    static FastScanner fs = null;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
           int n = fs.nextInt();
         int dp[] = new int[n+1];
         Arrays.fill(dp,-1);
         dp[0]=0;
        int a[] = fs.readArray(3);

         for(int i=1;i<=n;i++){
             for(int j=0;j<3;j++){
                 if(i - a[j]<0){
                     continue ;
                 }else{
                     if(dp[i - a[j]]==-1){
                         continue ;
                     }else{
                         dp[i] = Math.max(dp[i],dp[i- a[j]] + 1);
                     }
                 }

             }
         }
         out.println(dp[n]);
  
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