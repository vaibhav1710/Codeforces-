import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {
    static FastScanner fs = null;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
           int n = fs.nextInt();
           HashMap<String , Integer> h = new HashMap<>();
           for(int i=0;i<n;i++){
               int c = fs.nextInt();
               char c1[] = fs.next().toCharArray();
              if(c1.length>1) {
                  Arrays.sort(c1);
              }
              String s  = new String(c1);
              if(h.containsKey(s)){
                  int x = h.get(s);
                  x = Math.min(x,c);
                  h.put(s,x);
              }else{
                  h.put(s,c);
              }

           }

           long ans = Integer.MAX_VALUE;
           if(h.containsKey("A") && h.containsKey("B") && h.containsKey("C")){
               ans = h.get("A");
               ans += h.get("B");
               ans += h.get("C");
           }
           if(h.containsKey("ABC")) {
               ans = Math.min(ans, h.get("ABC"));
           }
           if(h.containsKey("A") && h.containsKey("BC")){
               ans = Math.min(ans,h.get("A")+h.get("BC"));
           }
        if(h.containsKey("B") && h.containsKey("AC")){
            ans = Math.min(ans,h.get("B")+h.get("AC"));
        }
        if(h.containsKey("C") && h.containsKey("AB")){
            ans = Math.min(ans,h.get("C")+h.get("AB"));
        }
        if(h.containsKey("AB") && h.containsKey("BC")){
            ans = Math.min(ans,h.get("AB")+h.get("BC"));
        }
        if(h.containsKey("AC") && h.containsKey("BC")){
            ans = Math.min(ans,h.get("AC")+h.get("BC"));
        }if(h.containsKey("AB") && h.containsKey("AC")){
            ans = Math.min(ans,h.get("AB")+h.get("AC"));
        }
 if(ans == Integer.MAX_VALUE){
     out.println("-1");
 }else {
     out.println(ans);
 }

        out.close();
    }


    static class Pair1 {
        String s;
        int x;
        int y;

        Pair1(String s, int x, int y) {
            this.s = s;
            this.x = x;
            this.y = y;

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