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
            int a[] = fs.readArray(n);
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Integer> al1 = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(a[i]%2==0){
                    al1.add(a[i]);
                }else{
                    al.add(a[i]);
                }
            }
            if(check(al1) && check(al)){
                out.println("YeS");
            }else{
                out.println("nO");
            }

        }
        out.close();
    }

    public static boolean check(ArrayList<Integer> al){

        for(int i=1;i<al.size();i++){
            if(al.get(i)<al.get(i-1)){
                return false;
            }
        }

        return true;
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