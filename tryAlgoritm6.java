import java.util.*;
import java.lang.*;

public class tryAlgoritm6 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed.
/*Project 4********************************************************
 public static void main(String[] args) {
   int n = 10; 
	for(int i = 1; i <=n; i++)  
		System.out.println("n = " + i +" has " + numOrder(i)+ " multiple ways");
} 
public static int numOrder(int n) {
	int [] A = new int [n+1]; 
	int sum = 0; 
	
	for (int i = 1; i <= n; i++){
		if(i == 1 || i == 2)
			sum = 1; 
		else{ 
			for(int j = 1; j <= i-1; j++)
				sum += A[j]*A[i-j];			
		}//end else
		A[i] = sum; 
		sum = 0;			
	}//end first for-loop
	
return A[n]; 
}

end 1 ************************************************************/
//**Project 8********************************************************

public static void main(String[] args) {
        int n = 10; 
        int [][] P = new int [n+1][n+1]; 
		  int [][] M = new int [n+1][n+1]; 
		 // int []d = {10, 4, 5, 20, 2, 50};
		  //int []d = {5, 10, 6, 4, 5, 8};
		  int [] d = {100, 50, 200, 300, 150, 90, 130, 600, 400, 80, 220};    
        System.out.println("n = " + n +" has " + minmult(n, d, M, P)+ " multiple ways");
		  System.out.println("M : ");
		  printArray(n, M);
		  System.out.println("\nP : ");
		  printArray(n, P);
		  System.out.println("\nOptimal order : ");
		  printOrder(1, n, P);
		 
}
public static int minmult(int n, int [] d, int [][] M, int [][] P) {   
	int i, j, k, diag; 
	int min = 0;
	int p = -1;
	int temp;
	
	for( i = 1; i <= n; i++)
		for( j = 1; j <= n; j++){
			M[i][j] = 0; 
			P[i][j] = 0; 
		} 
		
	for( diag = 1; diag <= n-1; diag++){
		for( i = 1; i <= n-diag; i++){
			j = i + diag; 
			for(k = i; k <= j-1; k++){
				temp = M[i][k] + M[k+1][j] + d[i-1]*d[k]*d[j]; 
				if(k == i){
					min = temp;
					p = k;
				}
				else{
					if(temp < min){
						min = temp;
						p = k;
					}
				}//end else
			}//end for-k
			M[i][j] = min;
			P[i][j] = p; 
		}//end for-i
	}//end for-diag	 
	return M[1][n];        
     
} 
public static void printOrder(int s, int d, int [][] P){
	
	if(s == d)
		System.out.print("A" + s);
	else{
		int m = P[s][d];
		System.out.print("(");
		printOrder(s,m,P);
		printOrder(m+1,d,P);
		System.out.print(")");
	}	
}
public static void printArray(int n, int [][] A) {
       
         for (int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++) 
           		 System.out.print(A[i][j] + " "); 
				System.out.println();
			}                       
} 
       
//end 8 ************************************************************/

/**Project 8_v2********************************************************

public static int minmult(int n, int [] d, int [][] M, int [][] P) {   
	int i, j, k, diag; 
	int min = 0;
	int p = -1;
	int temp;
	
	for( i = 1; i <= n; i++)
		for( j = 1; j <= n; j++){
			M[i][j] = 0; 
			P[i][j] = 0; 
		} 
		
	for( diag = 1; diag <= n-1; diag++){
		for( i = 1; i <= n-diag; i++){
			j = i + diag; 
			for(k = i; k <= j-1; k++){
				temp = M[i][k] + M[k+1][j] + d[i-1]*d[k]*d[j]; 
				if(k == i){
					min = temp;
					p = k;
				}
				else{
					if(temp < min){
						min = temp;
						p = k;
					}
				}//end else
			}//end for-k
			M[i][j] = min;
			P[i][j] = p; 
		}//end for-i
	}//end for-diag	
	
	System.out.println("M : ");
	printArray(n, M);
	System.out.println("\nP : ");
	printArray(n, P);
	System.out.print("\nOptimal order : ");
	printOrder(1, n, P); 
	System.out.println();
	
	return M[1][n];        
     
} 
public static void printOrder(int s, int d, int [][] P){
	
	if(s == d)
		System.out.print("A" + s);
	else{
		int m = P[s][d];
		System.out.print("(");
		printOrder(s,m,P);
		printOrder(m+1,d,P);
		System.out.print(")");
	}	
}
public static void printArray(int n, int [][] A) {
   for (int i = 1; i <= n; i++){
		for(int j = 1; j <= n; j++) 
      	System.out.print(A[i][j] + " "); 
		System.out.println();
	}                       
} 
public static void main(String[] args) {
        int n = 10; 
        int [][] P = new int [n+1][n+1]; 
		  int [][] M = new int [n+1][n+1]; 
		  int [] d = {100, 50, 200, 300, 150, 90, 130, 600, 400, 80, 220};
		      
        System.out.println("n = " + n +" has " + minmult(n, d, M, P)+ " multiple ways");		 
}

       
end 8 ************************************************************/

/*Project 7********************************************************
public static void main(String[] args) {

        int [][] P = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
		  					 {0, 0, 1, 2, 1, 4, 4, 4, 4}, 
                      {0, 0, 0, 2, 2, 4, 2, 3, 2}, 
                      {0, 0, 0, 0, 3, 4, 4, 4, 4},
                      {0, 0, 0, 0, 0, 4, 4, 5, 4}, 
                      {0, 0, 0, 0, 0, 0, 5, 6, 7},
                      {0, 0, 0, 0, 0, 0, 0, 6, 6},
							 {0, 0, 0, 0, 0, 0, 0, 0, 7},
							 {0, 0, 0, 0, 0, 0, 0, 0, 0}};  
			int n = 8;    
        System.out.println ("Order: ");
		  printOrder(2, 7, P);
}
public static void printOrder(int s, int d, int [][] P){
	
	if(s == d)
		System.out.print("A" + s);
	else{
		int m = P[s][d];
		System.out.print("(");
		printOrder(s,m,P);
		printOrder(m+1,d,P);
		System.out.print(")");
	}	
}         
end 7 ************************************************************/

}//end class























