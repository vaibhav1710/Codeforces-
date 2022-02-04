

import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {

    static FastScanner fs = null;
   
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

       int t = fs.nextInt();
        while (t-- > 0) {
        int n = fs.nextInt();
     
         char [][] dp = new char[n][n];
         for(int i=0;i<n;i++){
             dp[i] = fs.next().toCharArray();
         }
         boolean f = true;

         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(dp[i][j]=='1'){
                     if(j==(n-1) || i==(n-1)){
                         continue;
                     }else{
                         if(dp[i+1][j]=='1' || dp[i][j+1]=='1'){
                             continue;
                         }else{
                             f = false;
                             break;
                         }
                     }
                 }
             }
             if(!f){
                 break;
             }
         }
         if(f){
             out.println("YES");
         }else{
             out.println("NO");
         }

        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

        public int compareTo(Pair o) {
          return this.x - o.x;
        }
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
