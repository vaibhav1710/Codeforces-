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
          int dp[][] = new int[n][5];
          for(int i=0;i<n;i++){
              for(int j=0;j<5;j++){
                  dp[i][j] = fs.nextInt();
              }
          }

          if(n==1){
              out.println(1);
          }else{
              int cw = 0;
              boolean f = false;
              int ow=0;
              int cp=0;
              for(int i=1;i<n;i++){
                  ow=0;
                  cp=0;
                  for(int j=0;j<5;j++){
                      if(dp[cw][j]<dp[i][j]){
                          ow++;
                      }else if(dp[cw][j]>dp[i][j]){
                          cp++;
                      }else{
                          continue;
                      }
                  }
                  if(cp>=3){
                      cw = i;
                  }else{
                      continue;
                  }
              }


              for(int i=0;i<n;i++){
                  if(i!=cw) {
                       cp=0;
                      ow=0;
                      for (int j = 0; j < 5; j++) {
                       if(dp[cw][j]<dp[i][j]){
                           ow++;
                       }else if(dp[cw][j]>dp[i][j]){
                           cp++;
                       }
                      }
                      if(ow>cp){
                          continue;
                      }else{
                          f = true;
                          break;
                      }
                  }else{
                      continue;
                  }
              }


              if(f){
                  out.println(-1);
              }else{
                  out.println(cw+1);
              }


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
