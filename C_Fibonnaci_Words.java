

import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {

    static FastScanner fs = null;
   
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

    
            String s = fs.next();
            if(s.length()<=2){
                out.println("YES");
            }else{
                boolean f = true;
                int a[] = new int[s.length()];
                a[0] = s.charAt(0)-'A' + 1;
                a[1] = s.charAt(1)-'A' + 1;
                for(int i=2;i<s.length();i++){
                    int x = a[i-1]+a[i-2];
                    // A --> 28,1,28+27
                    x = x%26;
                    if(x==0){
                        x = 26;
                    }else if(x==1){
                      f = false;
                      break;
                    }
                    int y = s.charAt(i)-'A'+1;
                    if((x-1)==y){
                        a[i] = s.charAt(i)-'A'+1;
                    }else{
                        f = false;
                        break;
                    }
                }
                if(!f){
                    out.println("NO");
                }else{
                    out.println("YES");
                }
            }

 //       }
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
