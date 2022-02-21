import javax.print.attribute.IntegerSyntax;
import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {

    static FastScanner fs = null;
    static  ArrayList<Long> graph[] ;
    public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        outer:
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            long a[] = fs.readlongArray(n);

            int rem[] = new int[m];
            for(int i=0;i<n;i++){
                rem[(int)(a[i]%m)]++;
            }
            long count=0l;
            if(rem[0]>0){
                count++;
            }

            int i=1;
            int j = m-1;
            while(i<j) {
                if (rem[i] > 0 || rem[j] > 0) {
                    int y = Math.abs(rem[i] - rem[j]);
                    count += 1 + Math.max(0, y - 1);
                }
                i++;
                j--;
            }
            if(m%2==0){
                if(rem[m/2]>0){
                    count += 1;
                }
            }
            out.println(count);


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