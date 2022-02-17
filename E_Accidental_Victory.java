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
            long a[] = new long[n];
            long b[] = new long[n];
            for(int i=0;i<n;i++){
                a[i] = fs.nextLong();
                b[i] = a[i];
            }
            sort(a);

            long l = 0;
            long r = n-1;
            long ans = -1;
            while(l<=r){
                long mid = l + (r-l+1)/2;
                if(check(mid,a,b)){
                    ans = mid;
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            long tt = a[(int)ans];
            int ph=0;
          
            for(int i=0;i<n;i++){
                if(b[i]>=a[(int)ans]){
                    ph++;
                }
            }
            out.println(ph);
            for(int i=0;i<n;i++){
                if(b[i]>=a[(int)ans]){
                    out.print((i+1)+" ");
                }
            }
            out.println();

        }
        out.close();
    }

    public static boolean check(long i,long [] a,long b[]){

        long t = a[(int)i];
        for(int j=0;j<a.length;j++){
            if(j==i){
                continue;
            }else if(t>=a[j]){
                t += a[j];
            }else{
                return false;
            }

        }

        return true;
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
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