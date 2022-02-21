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
           int k = fs.nextInt();

           if(n%2==0){
               if(n%4==0){
                   int x = n/2;
                   out.println(x+" "+(x/2)+" "+(x/2));
               }else{
                out.println("2 "+(n-2)/2 +" "+(n-2)/2);
               }
           }else{
               out.println("1 "+(n-1)/2 +" "+(n-1)/2);
           }
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