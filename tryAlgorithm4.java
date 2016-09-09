import java.util.*;
import java.lang.*;

public class tryAlgorithm4 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed.
/*Project 1********************************************************
 public static void main(String[] args) {
   foo(); 
  
    }
    
public static void foo() {
   //int [] A = {27, 10, 12, 20, 4, 25, 13, 15, 22, 11, 16, 23, 14, 7, 19, 1};
   //int [] A = {27, 10, 12, 20, 25, 13, 15, 22};
   int [] A = {27, 10, 12, 20};
       printArray(A, 0, A.length-1);
       mystery(A, 0, A.length-1);
}
      
public static void mystery(int [] A, int low, int high) {
      
         for(int s=2;s<=high-low+1;s=s*2) {
            for (int i = low; i < high; i = i + s){
                int h = i + s - 1;
                int m = (i + h)/ 2;
                merge(A, i, m, h);
            }    
            printArray(A, low, high);
         }
       }
       
public static void printArray(int [] A, int low, int high) {
       
         for (int i = low; i <= high; i++) {
            System.out.print(A[i] + " ");               
         }
         System.out.println();
}

public static void merge(int [] A, int low, int mid, int high) {
      int i = low;
      int j = mid+1;
      int k = low;
      int [] B = new int [high+1];
  
      while (i <= mid && j <= high){
         if(A[i] < A[j])
           B[k++]= A[i++]; 
         else
           B[k++] = A[j++];          
      }//end while
      
     while(i <= mid)
         B[k++] = A[i++];
         
      while(j <= high)
         B[k++] = A[j++];
         
      for(int m = low; m <= high; m++)
         A[m] = B[m];     
}


end 1 ************************************************************/
//**Project 3&4********************************************************

   public static void main(String[] args) {
     //int [] u = {7, 5, 3, 6};
     //int [] v = {4, 9, 2, 8};
     int u = 4729;
     int v = 3518;
     
     System.out.println("u*v = " + prod2(u,v));
        
   }
   public static int prod2(int u, int v)  { 
      int x, y, w, z, r, p, q; 
      int n,m;
      int lenU = (int)(Math.log10(u)+1);
      int lenV = (int)(Math.log10(v)+1); 
      
      if (lenU >= lenV)
         n = lenU;
      else
         n = lenV; 
      System.out.println();   
      System.out.print("n: " + n);
         
      if(u == 0 || v == 0)
         return 0; 
      else if( n <= 2)
         return u*v;
      else{
         m = n/2;
         System.out.print(", m: " + m);
         x = u/(int)Math.pow(10,m);
         y = u%(int)Math.pow(10,m);
         w = v/(int)Math.pow(10,m);
         z = v%(int)Math.pow(10,m);
         System.out.print(", x: " + x + ", y: " + y + ", w: " + w + ", z: " + z);
         r = prod2(x+y, w+z);
         System.out.println();
         System.out.println("r: " + r);
         p = prod2(x, w);
         System.out.println();
         System.out.println("p: " + p);
         q = prod2(y, z);
         System.out.println();
         System.out.println("q: " + q);
         return p*(int)Math.pow(10,2*m)+(r-p-q)*(int)Math.pow(10,m)+q;
      }
  }

//end 3 & 4 ************************************************************/
/*Project 5********************************************************
 public static void main(String[] args) {
        
		  int [] D = { 0, 1, 5, 10, 25};
		  int n = 100;
		  int k = D.length-1; 
        
		  System.out.println("number of ways to change $" + n + " coins is " + numWaysToMakeChange(n, k, D) + " ways");
   }
   public static int numWaysToMakeChange(int n, int k, int [] D) {
		//System.out.println(n + "," +k); 
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1; 
		else if(k == 1)
			return 1;
		else
			return numWaysToMakeChange(n, k-1, D) + numWaysToMakeChange(n-D[k],k,D);       
}
end 5 ************************************************************/
/*Project 6********************************************************
public static void main(String[] args) {
        
		  int [] D = { 0, 1, 5, 10, 25, 50, 100};
		  int n = 738;
		  int k = D.length-1; 
        
		  System.out.println("number of ways to change $" + n + " coins is " + numWaysToMakeChange(n, k, D) + " ways");
   }
   public static int numWaysToMakeChange(int n, int k, int [] D) {
		int [][] A = new int [n+1][k+1]; 
		int temp = 0;  
		
		for(int i = 0; i <= n; i++)
			for(int j = 1; j <= k; j++){
				if(i == 0 || j == 1){
					A[i][j] = 1;
               System.out.println("i: " + i + " j: " + j + " value: " + A[i][j]);
            }
				else{
					temp = i - D[j];
					if(temp < 0){
						A[i][j] = A[i][j-1]; 
						temp = 0;
					}
					else 
						A[i][j] = A[i][j-1] + A[temp][j]; 
				}
      }	
           
		return A[n][k];				      
}
end 6 ************************************************************/
/*Project 7 & 8********************************************************
public static void main(String[] args) {
        int [][] P = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                      {0, 0, 4, 5, 0, 0, 8, 9, 0, 5},
                      {0, 7, 0, 0, 8, 7, 8, 3, 0, 7},
                      {0, 7, 7, 0, 7, 7, 8, 0, 7, 7},
                      {0, 7, 0, 7, 0, 7, 8, 0, 2, 7},
                      {0, 9, 9, 0, 9, 0, 9, 9, 0, 5},
                      {0, 0, 8, 5, 1, 1, 0, 9, 0, 5},
                      {0, 0, 4, 5, 1, 1, 8, 0, 1, 5},
                      {0, 7, 0, 7, 0, 7, 0, 4, 0, 7},
                      {0, 7, 7, 0, 7, 0, 8, 0, 7, 0}};
        //printPath(2, 5, P);
        printPathAll(2, 5, P);
        
}
public static void printPath(int s, int d, int [][] P) {            
    
      if (P[s][d] != 0)  {               
         int m = P[s][d];               
         printPath(s, m, P);               
         System.out.print("v_" + m +"  ");               
         printPath(m, d, P);
      } 
}         
    
public static void printPathAll(int s, int d, int [][] P) {            
    
      System.out.print("v_" + s + "  ");            
      
      if (P[s][d] != 0)  {               
         int m = P[s][d];               
         printPathAll(s, m, P);             
         System.out.print("v_" + m + "  ");               
         printPathAll(m, d, P);
      }            
      
      System.out.print("v_" + d + "  ");         
  }
 	
end 7 ************************************************************/

}//end class






















