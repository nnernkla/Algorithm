import java.util.*;
import java.lang.*;

public class tryAlgorithm5 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed.
//*Project 4********************************************************
 public static void main(String[] args) {
   int n = 9;   
  /* int [][] W = {{0, 0, 0, 0, 0, 0},
                 {0, 0, 10, 9999, 10, 50},
                 {0, 90, 0, 30, 20, 9999},
                 {0, 9999, 9999, 0, 40, 9999},
                 {0, 9999, 9999, 20, 0, 30},
                 {0, 30, 9999, 9999, 9999, 0}};
		int [][] W = {{0, 1, 2, 3, 4, 5, 6, 7},
						  {1, 0, 4, 9999, 9999, 9999, 10, 9999},
						  {2, 3, 0, 9999, 18, 9999, 9999, 9999}, 
						  {3, 9999, 6, 0, 9999, 9999, 9999, 9999},
						  {4, 9999, 5, 15, 0, 2, 19, 5},
						  {5, 9999, 9999, 12, 1, 0, 9999, 9999},
						  {6, 9999, 9999, 9999, 9999, 9999, 0, 10},
						  {7, 9999, 9999, 9999, 8, 9999, 9999, 0}};
		int [][] W = {{0, 1, 2, 3, 4, 5, 6, 7},
						  {1, 0, 76, 90, 69, 87, 39, 10, 84, 52},
						  {2, 22, 0, 68, 47, 36, 61, 32, 38, 15}, 
						  {3, 36, 37, 0, 84, 10, 75, 46, 41, 52},
						  {4, 57, 58, 21, 0, 31, 87, 28, 62, 73},
						  {5, 60, 72, 47, 26, 0, 75, 29, 14, 21},
						  {6, 47, 31, 55, 63, 26, 0, 41, 69, 46},
						  {7, 32, 10, 53, 52, 46, 66, 0, 48, 25},
						  {8, 41, 19, 49, 28, 16, 36, 51, 0, 34},
						  {9, 53, 54, 17, 72, 27, 22, 63, 58, 0}};
		int [][] P = {{0, 1, 2, 3, 4, 5, 6, 7},
						  {1, 0, 0, 4, 0, 0, 0, 0, 0, 0},
						  {2, 0, 0, 4, 0, 0, 1, 1, 0, 0}, 
						  {3, 0, 0, 0, 2, 0, 1, 1, 0, 2},
						  {4, 3, 3, 0, 0, 3, 0, 0, 3, 3},
						  {5, 0, 0, 4, 0, 0, 0, 0, 0, 0},
						  {6, 0, 0, 0, 0, 0, 0, 0, 2, 2},
						  {7, 2, 0, 0, 0, 2, 0, 0, 2, 2},
						  {8, 2, 0, 4, 0, 0, 0, 2, 0, 2},
						  {9, 3, 3, 0, 0, 3, 0, 3, 3, 0}};*/
		int [][] W = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
						  {1, 0, 54, 45, 9999, 9999, 18, 9, 9999, 45},
						  {2, 27, 0, 9999, 18, 27, 18, 63, 9999, 27},
						  {3, 27, 27, 0, 27, 27, 18, 9999, 27, 27},
						  {4, 27, 9999, 27, 0, 27, 18, 9999, 72, 27},
						  {5, 9, 9, 9999, 9, 0, 9, 9, 9999, 45}, 
						  {6, 9999, 18, 45, 81, 81, 0, 9, 9999, 45},
						  {7, 9999, 54, 45, 81, 81, 18, 0, 81, 45},
						  {8, 27, 9999, 27, 9999, 27, 9999, 54, 0, 27}, 
						  {9, 27, 27, 9999, 27, 9999, 18, 9999, 27, 0}}; 

   int [][] D = new int[n+1][n+1];
   int [][] P = new int[n+1][n+1];
   
   Floyd(n, W, D, P); 
  
    }
    
public static void Floyd(int n, int [][]W, int [][]D, int[][] P) {
   int i, j, k;
   int temp;  
   
   for(i = 1; i <= n; i++)
      for(j = 1; j <= n; j++){
         D[i][j] = W[i][j];
         P[i][j] = 0;
      }
 
   System.out.println("D0 : ");
   printArray(n, D);
   System.out.println("P0 : ");
   printArray(n, P);
   
   for(k = 1; k <= n; k++){
      for( i = 1; i<=n; i++)
         for(j = 1; j<=n; j++){
            temp = D[i][k]+D[k][j]; 
            if(temp < D[i][j]){
               D[i][j] = temp;
               P[i][j] = k; 
            }
         }
    System.out.println("D" + k + ": ");
    printArray(n, D);
    System.out.println("P" + k + ": ");
    printArray(n, P);
  }
}

public static void printArray(int n, int[][]A) {
       
         for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
               System.out.print(A[i][j] + " ");               
            }
            System.out.println();
            System.out.println("-------------");
         }
}

//end 1 ************************************************************/
/**Project 5 & 6********************************************************

public static void main(String[] args) {
        int [][] P = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                      {1, 0, 7, 7, 0, 7, 7, 0, 0, 7},
                      {2, 0, 0, 7, 0, 7, 9, 0, 1, 0},
                      {3, 9, 0, 0, 0, 7, 0, 2, 9, 6},
                      {4, 9, 8, 8, 0, 8, 8, 8, 0, 8},
                      {5, 9, 3, 0, 0, 0, 3, 3, 9, 6},
                      {6, 9, 9, 9, 0, 9, 0, 9, 9, 0},
                      {7, 9, 5, 5, 0, 0, 5, 0, 9, 6},
                      {8, 9, 7, 7, 0, 7, 7, 0, 0, 7},
                      {9, 0, 7, 7, 0, 7, 0, 1, 1, 0}};
        printPath(6, 3, P); 
       
        int [][] P = {{0, 1, 2, 3, 4, 5}, 
                      {1, 0, 0, 4, 0, 4}, 
                      {2, 5, 0, 0, 0, 4},
                      {3, 5, 5, 0, 0, 4},
                      {4, 5, 5, 0, 0, 0},
                      {5, 0, 1, 4, 1, 0}};      
        printPath(3, 2, P);
}
public static void printPath(int s, int d, int [][] P) {            
    
      if (P[s][d] != 0)  {               
         int m = P[s][d];               
         printPath(s, m, P);               
         System.out.print("v_" + m +"  ");               
         printPath(m, d, P);
      } 
}         
end 5&6 ************************************************************/
/*Project 7********************************************************
public static void main(String[] args) {
       
        int [][] W = {{0, 0, 0, 0, 0, 0},
                      {0, 0, 10, 9999, 10, 50},
                      {0, 90, 0, 30, 20, 9999},
                      {0, 9999, 9999, 0, 40, 9999},
                      {0, 9999, 9999, 20, 0, 30},
                      {0, 30, 9999, 9999, 9999, 0}};

        int [][] P = {{0, 1, 2, 3, 4, 5}, 
                      {1, 0, 0, 4, 0, 4}, 
                      {2, 5, 0, 0, 0, 4},
                      {3, 5, 5, 0, 0, 4}, 
                      {4, 5, 5, 0, 0, 0},
                      {5, 0, 1, 4, 1, 0}};      
        System.out.println ("mini weight = " + minCostRec(3, 2, P, W));
}
public static int minCostRec(int s, int d, int [][] P, int [][] W){ 
		int x, y;           
      int m = P[s][d]; 
      if (m == 0)
			return W[s][d];
		else{
	       x = minCostRec(s, m, P, W);
			 System.out.print("v_" + m +"  ");
			 y = minCostRec(m, d, P, W);
			 return x+y;       
      } 
      
      
}         
end 7 ************************************************************/
/*Project 9********************************************************
public static void main(String[] args) {
        
		  int [][] W = {{0, 0, 0, 0, 0, 0},
                      {0, 0, 10, -1, 10, -1},
                      {0, 90, 0, 30, 20, -1},
                      {0, -1, -1, 0, 40, -1},
                      {0, -1, -1, 20, 0, -1},
                      {0, -1, -1, -1, -1, 0}};
		  int n = 5; 
        
		  System.out.println("isolated vertex is: " + isolatedVertex(n, W));
   }
public static int isolatedVertex(int n, int [][] W) {
	boolean check = true; 
	int answer;
	for(int i = 1; i <= n; i++){
		for(int j =1; j <= n; j++){
			if((W[i][j] != -1 || W[j][i] != -1)&&(i != j))
				check = false;
		}//end inner for-loop
		if(check == true)
			return i;
		else
			check = true; 
	}//end outer for-loop
		return  -1;		       
}
end 9 ************************************************************/
/*Project 10 ********************************************************
public static void main(String[] args) {
        int [][] W = {{0, 0, 0, 0, 0, 0},
                 		 {0, 0, 10, 9999, 10, 50},
                		 {0, 90, 0, 30, 20, 9999},
                		 {0, 9999, 9999, 0, 9999, 9999},
                		 {0, 9999, 9999, 20, 0, 30},
                		 {0, 30, 9999, 9999, 9999, 0}};
        int n = 5; 
        
		  System.out.println("Existing some path from every vertex to every evrtex is:  " + allReachableFromEverywhere(n, W));
        
}
public static boolean allReachableFromEverywhere(int n, int [][] W){ 
	 	  int [][] D = new int[n+1][n+1];
  		  int [][] P = new int[n+1][n+1];
		  boolean check = true;
		  
		  Floyd(n, W, D, P);
		  
		  for(int i = 1; i <= n; i++)
		  		for(int j = 1; j <= n; j++)
					if(D[i][j] == 9999)
						return false;
			
		return true;												
}         

public static void Floyd(int n, int [][]W, int [][]D, int[][] P) {
   int i, j, k;
   int temp;  
   
   for(i = 1; i <= n; i++)
      for(j = 1; j <= n; j++){
         D[i][j] = W[i][j];
         P[i][j] = 0;
      }
	System.out.println("D0 : ");
   printArray(n, D);
   
   for(k = 1; k <= n; k++){
      for( i = 1; i<=n; i++)
         for(j = 1; j<=n; j++){
            temp = D[i][k]+D[k][j]; 
            if(temp < D[i][j]){
               D[i][j] = temp;
               P[i][j] = k; 
            }
         }
	 System.out.println("D" + k + ": ");
    printArray(n, D);
  }
}
public static void printArray(int n, int[][]A) {
       
         for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
               System.out.print(A[i][j] + " ");               
            }
            System.out.println();
            System.out.println("-------------");
         }
}


 	
end 7 ************************************************************/
/*Project 11 ********************************************************
 public static void main(String[] args) {
   int n = 9;   
	
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

   int [][] D = new int[n+1][n+1];
   int [][] W = new int[n+1][n+1];
   
   revFloyd(n, W, D, P); 
  
    }

public static void revFloyd(int n, int [][]W, int [][]D, int[][] P) {
   int i, j, k;
   int temp;  
   
   for(i = 1; i <= n; i++)
      for(j = 1; j <= n; j++){
			if(i == j)
				W[i][j] = 0;
			else
         	W[i][j] = 9999; 
      }
 
   System.out.println("W0 : ");
   printArray(n, W);
   System.out.println("P9 : ");
   printArray(n, P);
   
   for(k = 9; k >= 1; k--){
      for( i = 1; i<=n; i++)
         for(j = 1; j<=n; j++){
				if(P[i][j] == k)
					W[i][j] = 9*(10-k); 
         }
    System.out.println("D" + k + ": ");
    printArray(n, W);
    System.out.println("P" + k + ": ");
    printArray(n, P);
  }
}
public static void printArray(int n, int[][]A) {
       
         for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
               System.out.print(A[i][j] + " ");               
            }
            System.out.println();
            System.out.println("-------------");
         }
}

End 11**************************************************************************/
}//end class

























