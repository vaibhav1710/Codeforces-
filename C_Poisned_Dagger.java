
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
        while (t-- > 0) {

            int n = fs.nextInt();
            long h = fs.nextLong();
            int tt [] = fs.readArray(n);

            long l = 1;
            long r = (long)1e18;
            long ans=0l;
            while(l<=r){
                long mid = l + (r-l+1)/2;
                long dm = 0l;
                for(int i=0;i<n-1;i++){
                    dm += Math.min(tt[i+1]-tt[i],mid);
                }
                dm += mid;
                if(dm>=h){
                    ans = mid;
                    r  = mid-1;
                }else{
                    l = mid+1;
                }
            }
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