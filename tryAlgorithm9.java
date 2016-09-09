import java.util.*;
import java.lang.*;

public class tryAlgorithm9 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 
/*Project 1 ********************************************************
 public static void main(String [] args)  { 
  		int n = 3;
		printAll(n);
 } 
		   
 public static void printAll(int n)  {
   
      int [] A = new int[n+1];
      printAllRec(n, 0, A);  
		
 }
 public static void printAllRec(int n, int i, int [] A)  {
 
 	if(promising(i, A)){
		if (i == n) {
         for (int j = 1; j <= n; j++)
            System.out.print(A[j] + "  ");
         System.out.println();
      }  
      else
      {
         int k;
        	for (k = 1; k <= n; k++)  {
          		A[i+1] = k;
					printAllRec(n, i+1, A);
         }//end for        
      }//end else
	}//end promising
  }
 public static boolean promising(int i, int [] A) {	
			for(int j = 1; j < i; j++)
			   if(A[i]== A[j]) 
					return false; 	     
    return true;
 }
end 1 ************************************************************/
/*check project 3 ********************************************************
	public static boolean check;
	public static void main(String [] args)  { 
		int n = 11;
		int m = 4;
 		int [][]W = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
 				  		 {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
				 		 {2, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
				 		 {3, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
				 		 {4, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
				 		 {5, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
				 		 {6, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
				  		 {7, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
				  		 {8, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0},
				  		 {9, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
				 		 {10,0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
				 		 {11,1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}};
		mColor(n,m,W);
	}
	public static void mColor(int n, int m, int [][]W){
		int []vcolor = new int[n+1];
		mColorRec(n, 0, m, W, vcolor);		
	}
	public static void mColorRec(int n, int i, int m, int[][]W, int[] vcolor){
		if(promising(i, W, vcolor)){
			if(i == n){
				for(int j = 1; j<=n; j++)
					System.out.print(vcolor[j] + ", ");
				System.out.println();
				check = true;
			}
			else{
				for(int k = 1; k <= m; k++)
				{
					if(check == false){
						vcolor[i+1] = k;
						mColorRec(n,i+1,m,W,vcolor);
					}
				}//end for
			}//end else
		}//end if
	}
	public static boolean promising(int i, int[][]W, int[]vcolor){
		for(int b = 1; b < i; b++)
			if(W[i][b] == 1 && (vcolor[i] == vcolor[b]))
				return false;
		return true;
	}
end check problem 3 **********************************************************/

/*Project 4 ********************************************************
 public static void main(String [] args)  {  
		for (int i = 5; i <=12; i++){
      int numSolutions = nqueens(i);
      System.out.println("Number of solutions of n = " + i + " is " + numSolutions);
		}    
   }

   public static int nqueens(int n)  {
      
      int [] col = new int[n+1];
      return nqueens_rec(n, 0, col);
   }
   
   public static int nqueens_rec(int n, int i, int [] col)  {
   	int count = 0; 
      if (promising(i, col)) {
         if (i == n)  {
			  return 1;  
         }
         else  
            for (int k = 1; k <= n; k++) {
               col[i+1] = k;
               count = count + nqueens_rec(n, i+1, col);
            }
      }
		return count;
   }
     
   public static boolean promising(int i, int [] col) {
      for (int k = 1; k < i; k++)
         if (col[k] == col[i] ||
             col[k] - k == col[i] - i ||
             col[k] + k == col[i] + i)
           return false;
           
      return true;
   }
end 4 ************************************************************/
/*Project 5 ********************************************************
   public static int calls;
	public static boolean found; 

   public static void main(String [] args)  {
		for(int i = 4; i <= 12; i++){
			System.out.print("n = " + i + " : "); 
      	calls = 0;
			found = false; 
     	 	nqueens(i);  
     	 	System.out.println("Done, with number of calls = " + calls);  
		}
   }

   public static void nqueens(int n)  {
           
      int [] col = new int[n+1];
      nqueens_rec(n, 0, col);
   }
   
   public static void nqueens_rec(int n, int i, int [] col)  {
   
      calls++;      
      if (promising(i, col)) {
         if (i == n)  {
            for (int j = 1; j <= n; j++)
               System.out.print(col[j] + "  ");
            System.out.println();
				found = true;
         }
         else  
            for (int k = 1; k <= n; k++) {
               col[i+1] = k;
					if( found != true)
               	nqueens_rec(n, i+1, col);
            }
      }
   }
      
   public static boolean promising(int i, int [] col) {
      for (int k = 1; k < i; k++)
         if (col[k] == col[i] ||
             col[k] - k == col[i] - i ||
             col[k] + k == col[i] + i)
           return false;         
      return true;
   }
end 5 ************************************************************/
/*Project 6 ********************************************************
	public static void main(String [] args)  {  
		int n = 6;
		int [][]W = {{0, 1, 2, 3, 4, 5, 6},
						 {1, 0, 1, 1, 1, 0, 0},
						 {2, 1, 0, 1, 1, 1, 0},
						 {3, 1, 1, 0, 1, 0, 0},
						 {4, 1, 1, 1, 0, 0, 1},
						 {5, 0, 1, 0, 0, 0, 0},
						 {6, 0, 0, 0, 1, 0, 0}};
		System.out.println(has4clique(n,W));
	}
	public static boolean has4clique(int n, int [][]W){
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				for(int k = 1; k <= n; k++)
					for(int m = 1; m <= n; m++)
						if(W[i][j] == 1 && W[i][k] == 1 && W[i][m] == 1)
							if(W[j][k] == 1 && W[j][m] == 1 && W[k][m] == 1)
								return true;
		return false; 
	}
end 6 ************************************************************/
//*Project 7 ********************************************************
	public static boolean check;
	public static void main(String [] args)  {
		int n = 6;
		int k = 4;
		int [][]W = {{0, 1, 2, 3, 4, 5, 6},
						 {1, 0, 1, 1, 0, 0, 0},
						 {2, 1, 0, 1, 1, 1, 0},
						 {3, 1, 1, 0, 1, 0, 0},
						 {4, 0, 1, 1, 0, 0, 1},
						 {5, 0, 1, 0, 0, 0, 0},
						 {6, 0, 0, 0, 1, 0, 0}};
		//System.out.println(hasKclique(k,n,W));
		hasKclique(k,n,W);
		System.out.println(check);
	}
	public static void hasKclique(int k, int n, int [][]W)  {
   
      int [] A = new int[k+1];
      hasKcliqueRec(k, 0, n, A, W);  
   }
	public static void hasKcliqueRec(int k, int i, int n, int [] A, int[][] W)  {
   if(promising(i, A, W)){
      if (i == k) {
			 check = true;
      }
      else
      {
         int m;
         for (m = 1; m <= n; m++)  {     
           	 A[i+1] = m;
				 if(check == false)
           	 	hasKcliqueRec(k, i+1, n,  A, W);
         }//end for
            
      }//end else
		}//prom
  }
   public static boolean promising(int i, int [] A, int [][]W) {	
		int v;
		int u;
		for(int j = 1; j < i; j++)
			for(int m = j+1; m <= i; m++){
				v = A[j];
				u = A[m];
				if(W[v][u] != 1)
            	return false;   
			}      
      return true;
   }
//end 7 ************************************************************/

/*Project 8********************************************************
	public static void main(String [] args)  { 
		int n = 11;
 		int [][]W = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
 				  		 {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
				 		 {2, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
				 		 {3, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
				 		 {4, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0},
				 		 {5, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
				 		 {6, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
				  		 {7, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
				  		 {8, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0},
				  		 {9, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
				 		 {10,0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
				 		 {11,1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}};
			//int [][] W= {{0, 1, 2, 3, 4, 5},
			//				{1, 0, 1, 1, 0, 1},
			//				{2, 1, 0, 1, 1, 0},
			//				{3, 1, 1, 0, 0, 0},
			//				{4, 0, 1, 0, 0, 1},
			//				{5, 1, 0, 0, 1, 0}};
		System.out.println(greedyColoring(n, W));
		
	}
	public static int greedyColoring(int n, int [][]W){
		int []vcolor = new int[n+1];
		int color = 0; 
		int count = 0;
		boolean check;
		
		while(count < n){
			color++;
			for(int i = 1; i <= n; i++){
				check = true;
				if(vcolor[i] == 0){
					for(int j = 1; j<= n; j++)
						if(W[i][j] == 1 && vcolor[j] == color)
							check = false;	
					if(check == true){
						vcolor[i] = color;
						count++;
					}//end if	
				}//end if
			}//end for-i
			
		}//end while
		for(int i = 1; i <= n; i++)
			System.out.print(vcolor[i] + " ");
		System.out.println();
			
		return color; 
	}
	
end 8 ************************************************************/

/*Project 10********************************************************
 public static void main(String[] args) {
   int n = 25;
	int []vcolor = new int [n+1];
	int [][]W = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
					 {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
					 {2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
					 {3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
					 {4, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0},
					 {5, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					 {6, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
					 {7, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
					 {8, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					 {9, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
					 {10,1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
					 {11,0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
					 {12,0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					 {13,0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
					 {14,1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
					 {15,0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
					 {16,0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
					 {17,0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0},
					 {18,0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					 {19,0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, 
					 {20,0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
					 {21,0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
					 {22,0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
					 {23,0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					 {24,1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
					 {25,0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}};
  
  	System.out.println(fastTwoColoring(n, W, vcolor));
	for(int i = 1; i <= n; i++){
		if(vcolor[i] == 1)
			System.out.print("red, ");
		else
			System.out.print("blue, ");
	}
}
    
public static boolean fastTwoColoring(int n, int [][] W, int[] vcolor){
	int count = 0; 
	int v = 1;
	int color;
	boolean [] check = new boolean [n+1]; 
	
	vcolor[v] = 1; //assign 1 = red, 2 = blue, and 0 = no color yet
	check[v] = true;
	count++; 
	
	while(count != n){
		if(vcolor[v] == 1)
			color = 2;
		else
			color = 1;
			
		for(int i = 1; i <= n; i++){
			if(W[v][i] == 1){
				if(vcolor[i] != 0 && vcolor[i] != color)
					return false;
				
				if(vcolor[i] == 0){
					vcolor[i] = color;
					count++;
				}
			}//end outer if
		}//end for
		check[v] = true;
		
		int j = 1;
		while(vcolor[j] == 0 || check[j] == true)
			j++;
		v = j;
	
		//int min = n+1;
		//for(int j = 1; j <=n ; j++)
			//if(j < min && (vcolor[j] != 0 && check[j] != true))
					//min = j;
			//v = min;	
		
	}
	return true;
}

end 10 ************************************************************/



}//end class






















