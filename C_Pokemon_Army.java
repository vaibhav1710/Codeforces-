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
          int q = fs.nextInt();
          long a[] = new long[n];
          for(int i=0;i<n;i++){
              a[i] = fs.nextLong();
          }
          long odp[] = new long[n];
          long edp[] = new long[n];
          odp[0] = a[0];
          edp[0] = Long.MIN_VALUE;

          long odpm = odp[0];
          long edpm = Long.MIN_VALUE;

          for(int i=1;i<n;i++){
              odp[i] = Math.max(a[i],edpm + a[i]);
              edp[i] = odpm - a[i];
              odpm = Math.max(odpm , odp[i]);
              edpm = Math.max(edpm , edp[i]);
          }

          out.println(Math.max(odpm,edpm));
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