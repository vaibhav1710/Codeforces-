

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
          int a[] = fs.readArray(n);
          PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
          HashMap<Integer,Integer> h = new HashMap<>();
          int id=-1;
          for(int i=0;i<n;i++){
              h.put(a[i],h.getOrDefault(a[i],0)+1);
              if(h.get(a[i]) > ((n)/2)){
                  id = i;
              }
          }
         if(id==-1 && (n&1)==0){
             out.println(0);
         }else if(id==-1){
             out.println(1);
         }
         else{
             if((n&1)==0){
                int x = h.get(a[id]);
                if(x > n/2){
                    x -= (n-x);
                    out.println(x);
                }else{
                    out.println(0);
                }
             }else{
                int x = h.get(a[id]);
                if(x > n/2){
                    out.println(x - (n-x));
                }else{
                    out.println(1);
                }
             }
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
