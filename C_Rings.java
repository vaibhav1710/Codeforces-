

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
    // static  int count=0;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        //sieveOfEratosthenes(1000000);
       // fact();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
          String s = fs.next();
          char c [] = s.toCharArray();
          int len = 0;
          if(n%2==0){
              len = s.length()/2;
          }else{
              len = s.length()/2 + 1;
          }
          Pair pre[] = new Pair[n];

          if(s.charAt(0)=='1') pre[0] = new Pair(1,0);
          else pre[0] = new Pair(0,1);

          for(int i=1;i<n;i++){
              if(s.charAt(i)=='1'){
                  pre[i] = new Pair(pre[i-1].x+1,pre[i-1].y);
              }else{
                  pre[i] = new Pair(pre[i-1].x,pre[i-1].y+1);
              }
          }

            boolean f = false;
              for(int i=0;i<n;i++){
                  if(s.charAt(i)=='0'){
                      f = true;
                      if(i >= n/2){
                          out.println(1+" "+(i+1)+" "+(1)+" "+(i));
                          break;
                      }else{
                          out.println((i+1)+" "+(n)+" "+(i+2)+" "+(n));
                          break;
                      }
                  }
              }

              if(!f){
                  out.println(1+" "+(n-1)+" "+2+ " "+(n));
              }




            int w=1;
         }
        out.close();
    }



public static boolean ispal(String s){

        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
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
   