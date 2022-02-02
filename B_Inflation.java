

import java.net.CookieHandler;
import java.util.*;
import java.io.*;
//import static com.sun.tools.javac.jvm.ByteCodes.swap;
// ?)(?
public class fastTemp {
    static class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    };
    static FastScanner fs = null;
    static  ArrayList<Long> graph[] ;
    static int mod = 998244353;
    
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
       int n = fs.nextInt();
       int k = fs.nextInt();
       int a[] = fs.readArray(n);

       double ans = a[0];
       double count=0;
       for(int i=1;i<n;i++){
        if (a[i]*100l <= k*ans){
            ans += a[i];
            continue;
        }else{

            double req = Math.ceil(((a[i]*100l))/1.0/k) ;
            count += req - ans;
            ans = req;
            ans+=a[i];
        }
       }
  out.println((long)count);
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
