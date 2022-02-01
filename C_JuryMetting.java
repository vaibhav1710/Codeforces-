import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class fastTemp {
  
    static FastScanner fs = null;
    static  ArrayList<Long> graph[] ;
    // static  int count=0;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        //sieveOfEratosthenes(1000000);
       // fact();
       int m = 998244353;
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int a[] = fs.readArray(n);
            HashMap<Integer,Integer> h = new HashMap<>();
            for(int i=0;i<n;i++){
                h.put(a[i],h.getOrDefault(a[i],0)+1);
            }
            sort(a);
           
            int count=0;
            if(!h.containsKey(a[n-1]-1) && h.get(a[n-1])==1){
                out.println(0);
            }else if(h.get(a[n-1])>1){
                long ans= 1;
                for (int i = 1; i <= n; i++) {
                    ans = (ans * i) % m;
                }
                out.println(ans);
            }else{
                boolean f = true;
                long j = 0;
                if (!h.containsKey(a[n - 1] - 1)) {
                    out.println(0);
                } else {
                    j = h.get(a[n - 1] - 1);
                    long ans = 1;
                    long sub = 1;
                    for (int i = 1; i <= n; i++) {
                        ans = (ans * i) % m;
                        if (i != (j + 1)) {
                            sub = (sub * i) % m;
                        }
                    }
                    out.println((ans-sub + m)%m);
                }
            }



            int w=1;
         }
        out.close();


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
