
//Editorial had an DP implementation but I have used BFS

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
        int k = fs.nextInt();

        int id[] = fs.readArray(k);
        int tmp[] = fs.readArray(k);

        PriorityQueue<Pair> p = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            p.add(new Pair(tmp[i],id[i]-1));
        }
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<k;i++){
            ans[id[i]-1] = tmp[i];
        }

        while(p.size()!=0){

            Pair r = p.remove();
            if(r.y+1<n) {
                if (ans[r.y + 1] > r.x + 1) {
                    ans[r.y + 1] = r.x + 1;
                    p.add(new Pair(r.x + 1, r.y + 1));
                }
            }
                if(r.y-1>=0){
                    if (ans[r.y - 1] > r.x + 1) {
                        ans[r.y - 1] = r.x + 1;
                        p.add(new Pair(r.x + 1, r.y - 1));
                    }
                }
            }

        for(int v:ans){
            out.print(v+" ");
        }
        out.println();
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
