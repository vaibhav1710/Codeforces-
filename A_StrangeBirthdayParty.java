

import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {
    static FastScanner fs = null;
    static  ArrayList<Long> graph[] ;
    static int mod = 998244353;
    
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
           int m = fs.nextInt();
           ArrayList<Integer> al = new ArrayList<>();
           for(int i=0;i<n;i++){
               al.add(fs.nextInt());
           }
           int c[] = fs.readArray(m);
           Collections.sort(al,Collections.reverseOrder());
           int j=0;

           long dp[] = new long[n];
           if(c[0]<c[al.get(0)-1]){
               dp[0] = c[0];
               j=1;
           }else{
               dp[0] = c[al.get(0)-1];
               j=0;
           }
           for(int i=1;i<n;i++){
               if(j<m && c[j]<c[al.get(i)-1]){
                   dp[i] = dp[i-1]+c[j];
                   j++;
               }else{
                   dp[i] = dp[i-1] + c[al.get(i)-1];
               }
           }

           out.println(dp[n-1]);
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
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
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
