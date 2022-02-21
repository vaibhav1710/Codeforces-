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
        String a = fs.next();
        String b = fs.next();

        int pre0[] = new int[n];
        int pre1[] = new int[n];

        if(a.charAt(0)=='1'){
            pre1[0]=1;
        }else{
            pre0[0] = 1;
        }

        for(int i=1;i<n;i++){
            if(a.charAt(i)=='1'){
                pre1[i]= pre1[i-1]+1;
                pre0[i] = pre0[i-1];
            }else{
                pre0[i] = pre0[i-1] + 1;
                pre1[i]= pre1[i-1];
            }
        }
        // boolean f = false;
        boolean flag = true;
        for(int i=n-1;i>=0;i--){
            if(a.charAt(i)==b.charAt(i)){
                continue ;
            }
            else if(a.charAt(i)!=b.charAt(i)) {
                if (pre1[i] != pre0[i]) {
                    flag = false;
                } else {
                    while (i>=0 &&  a.charAt(i) != b.charAt(i)) {
                        i--;
                    }
                }

                if ( i>=0 && pre1[i] != pre0[i]) {
                    flag = false;
                    break;
                } else {

                }
            }
        }

        if(!flag){
            out.println("NO");
        }else{
            out.println("YES");
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