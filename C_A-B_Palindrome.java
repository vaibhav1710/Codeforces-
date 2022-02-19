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
            int z = fs.nextInt();
            int o = fs.nextInt();

            String s = fs.next();
            char c[] = s.toCharArray();
            int i=0;
            int j = c.length-1;
            boolean f = true;

            for(int l=0;l<s.length();l++){
                if(s.charAt(l)=='1'){
                    o--;
                }else if(s.charAt(l)=='0'){
                    z--;
                }
            }

            while(i<j){

                if(s.charAt(i)!='?' && s.charAt(j)!='?'){
                    if(s.charAt(i)!=s.charAt(j)){
                        f = false;
                    }
                }else if(s.charAt(i)!='?' && s.charAt(j)=='?'){
                     if(s.charAt(i)=='1'){
                         c[j] = c[i];
                         o--;
                     }else{
                         c[j] = c[i];
                         z--;
                     }
                }else if(s.charAt(i)=='?' && s.charAt(j)!='?'){
                    if(s.charAt(j)=='1'){
                        c[i] = c[j];
                        o--;
                    }else{
                        c[i] = c[j];
                        z--;
                    }
                }else{

                }

                i++;
                j--;
            }

            i = 0;
            j = c.length-1;
            while(i<j){
                if(s.charAt(i)=='?' && s.charAt(j)=='?'){

                    if(o>=2){
                        c[i]='1';
                        c[j] = '1';
                        o -= 2;
                    }else if(z>=2){
                        c[i]='0';
                        c[j] = '0';
                        z -= 2;
                    }else{
                        f  = false;
                    }
                }
                i++;
                j--;
            }

            if(s.length()%2==1){
                if(s.charAt(s.length()/2)=='?'){
                    if(o>=1){
                        c[s.length()/2] = '1';
                        o--;
                    }else if(z>=1){
                        c[s.length()/2] = '0';
                        z--;
                    }else{
                        f = false;
                    }
                }else{
                    c[s.length()/2] = s.charAt(s.length()/2);
                }
            }

            if(f && z==0 && o==0){
                for(char v:c){
                    out.print(v+"");
                }
                out.println();
            }else{
                out.println("-1");
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