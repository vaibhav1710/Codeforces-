import java.util.*;
import java.io.*;

public class fastTempE {

    static FastScanner fs = null;
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
            int n = fs.nextInt();
           int a[] = new int[n];
            HashMap<Integer,Integer > b = new HashMap<>(); 
            
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        HashMap<Integer,Integer > leftMap = new HashMap<>(); 
         
        for(int i=0;i<n;i++) {
        	a[i] = fs.nextInt();
        }
        for(int i=0;i<n;i++) {
        	b.put(fs.nextInt(), i);
        }
        
        for(int i=0;i<n;i++) {
        	int x = a[i];
        	int j = b.get(x);
        	
        	if(i<j) {
        		rightMap.put(j-i, rightMap.getOrDefault(j-i, 0)+1);
        		int dis = i-0;
        		dis += n - j;
        		leftMap.put(dis,leftMap.getOrDefault(dis,0 )+1);
        	}else if(j<i) {
        		leftMap.put(i-j, leftMap.getOrDefault(i-j,0)+1);
        		int dis = n-1-i;
        		dis += j+1;
        		rightMap.put(dis,rightMap.getOrDefault(dis,0 )+1);
        	}else {
        		leftMap.put(0,leftMap.getOrDefault(0, 0)+1);
        		rightMap.put(0,rightMap.getOrDefault(0, 0)+1);
        	}
        	
        }
        
        int maxleft=0;
        int maxright=0;
        for(int v:rightMap.keySet()) {
        	maxright = Math.max(maxright, rightMap.get(v));
        }
        for(int v:leftMap.keySet()) {
        	maxleft = Math.max(maxleft, leftMap.get(v));
        }
        		
        out.println(Math.max(maxleft, maxright));
    	   

      
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

        long[] readlongArray(int n){
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}