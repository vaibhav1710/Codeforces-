import java.util.*;
import java.io.*;

public class fastTempE {

    static FastScanner fs = null;
    
    public static void main(String[] args) {


        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
            int n = fs.nextInt();
            int a[] = fs.readArray(n);
           ArrayList<Pair> al = new ArrayList<>() ;
           
        HashMap<Integer, Integer> hashMap = new HashMap<>();
          for(int i=0;i<n;i++) {
        	 hashMap.put(a[i], hashMap.getOrDefault(a[i], 0)+1);
          }
          int val8=0;
          int val6=0;
          int val4=0;
          int val2=0;
          
          for(int v:hashMap.keySet()) {
        	  int x = hashMap.get(v);
        	  if(x>=8) {
        		  val8++;
        		  val6++;
        		  val4++;
        		  val2++;
        	  }else if(x>=6 && x<8) {
        		  val2++;
        		  val6++;
        		  val4++;
        	  }else if(x>=4 && x<6) {
        		  val4++;
        		  val2++;
        	  }else if(x>=2 && x<4) {
        		  val2++;
        	  }
          }
           
         int q = fs.nextInt();
         while(q-->0) {
        	 String s = fs.next();
        	 if(s.charAt(0)=='+') {
        		 int y = Integer.parseInt(fs.next());
        		 int x=0;
                   if(hashMap.containsKey(y)) {  		
        		     x  = hashMap.get(y);
                   }else {
                	   hashMap.put(y, 1);
                   }
        		     x += 1;
        		hashMap.put(y,x);
        		 if(x==8) {
        			 val8++;       			
        		 }else if(x==6) {
        			 val6++;	
        		 }else if(x==4) {
        			 val4++;        		
        		 }else if(x==2) {
        			 val2++;
        		 }
        		 
        		 
        		 if(val8>=1) {
        			 out.println("YES");
        		 }else if(val6>=1 &&  val2>=2) {
        			 out.println("YES");
        		 }else if(val4>=2) {
        			 out.println("YES");
        		 }else if(val4>=1 && val2>=3) {
        			 out.println("YES"); 
        		 }else {
        			 out.println("NO");
        		 }
        		 
        	 } else {
        		 int y = Integer.parseInt( fs.next());
            		
        		 int x=0;
                 if(hashMap.containsKey(y)) {  		
      		        x  = hashMap.get(y);
                 }
        		 if(x==8) {
        			 val8--;
        			 
        		 }else if(x==6) {
        			 val6--;
        			
        		 }else if(x==4) {
        			 
        			 val4--;
        		 }else if(x==2) {
        			 val2--;
        		 }
        		 
        		 x -= 1;
        	      		hashMap.put(y,x);
        		 
        		 if(val8>=1) {
        			 out.println("YES");
        		 }else if(val6>=1 && val2>=2) {
        			 out.println("YES");
        		 }else if(val4>=2) {
        			 out.println("YES");
        		 }else if(val4>=1 && val2>=3) {
        			 out.println("YES");
         		 }else {
        			 out.println("NO");
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