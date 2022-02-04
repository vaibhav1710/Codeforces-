

import java.net.CookieHandler;
import java.util.*;
import java.io.*;
//import static com.sun.tools.javac.jvm.ByteCodes.swap;
// ?)(?
public class fastTemp {
    static FastScanner fs = null;
    public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            String tt = fs.next();
           int i = s.length()-1;
           int x =tt.length()-1;

           while(i>=0 && x>=0){
               if(s.charAt(i)==tt.charAt(x)){
                   i--;
                   x--;
               }else{
                   i -= 2;
               }
           }
           if(x==-1){
               out.println("Yes");
           }else{
               out.println("No");
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
