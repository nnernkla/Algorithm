import java.util.*;
import java.lang.*;

public class tryAlgorithm10 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 
/*Project 1 ********************************************************
 public static int countR = 0;
 public static void main(String [] args)  { 
  		int n = 4;
		printAll(n);
 } 
		   
 public static void printAll(int n)  {
   
      int [] A = new int[n+1];
      printAllRec(n, 0, A);  
		
 }
 public static void printAllRec(int n, int i, int [] A)  {
		if (i == n) {
			if(odd(n,A)){
        		for (int j = 1; j <= n; j++)
            	System.out.print(A[j] + "  ");
        	   System.out.println();
			}//end if-odd
      }//end if-i 
      else
      {
         int k;
        	for (k = 0; k <= 1; k++)  {
          		A[i+1] = k;
					printAllRec(n, i+1, A);
        	}//end for        
      }//end else
  }
 public static boolean odd(int n, int [] A) {	
 	int count = 0; 
		for(int i = 1; i <= n; i++)
			if(A[i] == 1)
				count++;
		
		if(count % 2 == 0)
			return false;	  	     
    return true;
 }
end 1 ************************************************************/
/*project 2 ********************************************************
	public static void main(String [] args)  { 
		int n = 5;
 		char [][]B = {{'0', '1', '2', '3', '4', '5'}, 
 				  		 {'1', '-', '-', 'Q', '-', '-'},
				 		 {'2', 'Q', '-', '-', '-', '-'},
				 		 {'3', '-', '-', '-', 'Q', '-'},
				 		 {'4', '-', '-', '-', '-', '-'},
				 		 {'5', '-', '-', '-', '-', 'Q'}};
						 
		System.out.println (validNQueens(n,B));
	}
	public static boolean validNQueens(int n, char [][] B){
		int []col = new int [n+1];
		int countQ;
	
		for(int i = 1; i <= n; i++){
			countQ = 0;
			for(int j = 1; j <= n; j++){
				if(B[i][j] == 'Q'){
					col[i] = j;
					countQ++;
				}//end if
			}//end j-loop
			if(countQ != 1)
					return false;	
		}//end i-loop
		
		for(int i = 1; i <= n; i++)
			for(int j = i+1; j<=n; j++)
				if(col[i] == 0 || col[i]==col[j]||col[i]+i == col[j]+j||col[i]-i == col[j]-j)
					return false;
		return true;	
	}
end problem 2 **********************************************************/

/*Project 3 ********************************************************
 public static void main(String [] args)  { 
 		int n = 5;
		int m = 3;
		int vcolor[] = {0, 22, 50, 17, 50, 22}; 
		int [][]W = {{0, 1, 2, 3, 4, 5},
						 {1, 0, 1, 1, 0, 0},
						 {2, 1, 0, 1, 0, 1},
						 {3, 1, 1, 0, 1, 1},
						 {4, 0, 0, 1, 0, 1},
						 {5, 0, 1, 1, 1, 0}};  
		System.out.println(validMColoring(n, W, m, vcolor)); 		  
   }

 public static boolean validMColoring(int n, int [][] W, int m, int [] vcolor) {
 	int [] color = new int [n+1];
	int p = 0;
	boolean repeat;
	
	for(int i = 1; i<=n; i++){
		repeat = true;
		for(int j = 1; j <= p; j++)
			if(vcolor[i] == color[j]) 
				repeat = false;
			
			if (repeat == true)
				color[++p] = vcolor[i];
				
		for(int k = 1; k <= n; k++)
			if(W[i][k] == 1 && vcolor[i] == vcolor[k])
				return false;	
	}//end for-i
	//check color array
	for(int h = 1; h <= n; h++)
		System.out.print(color[h] + " ");
	System.out.println();
	
	if(p > m)
		return false;
	
	return true;
		
 }
end 3 ************************************************************/

/*Project 4 ********************************************************
   public static void main(String [] args)  {
		int n = 7;
		int [] w = {0, 7, 13, 16, 28, 41, 80, 152};
		int W = 137;	
		sumOfSubsets(n, w, W);
   }
	public static void sumOfSubsets(int n, int [] w, int W) {
		int total = 0; 
		int [] include = new int[n+1];
		
		for(int i = 1; i<=n; i++)
			total += w[i]; 
			
		sumOfSubsetsRec(0, 0, total, W, w,include);
	}
	public static void sumOfSubsetsRec(int i, int weight, int amtLeft, int W, int []w, int[]include){
		if(promising(i, weight, amtLeft, W, w,include)){
			if(weight == W){
				for(int j = 1; j <= i; j++)
					if(include[j] == 1)
						System.out.print(w[j] + " ");
					System.out.println();
			}//end if weight
			else{
				include[i+1] = 0;
				sumOfSubsetsRec(i+1, weight, amtLeft-w[i+1], W, w, include);
				include[i+1] = 1;
				sumOfSubsetsRec(i+1, weight+w[i+1], amtLeft-w[i+1], W, w, include);
				
			}//end else
		}//end promising
	}
public static boolean promising(int i, int weight, int amtLeft, int W, int[] w, int[]include){

		return((weight + amtLeft >= W)&&(weight == W || weight + w[i+1] <= W));
}
end 4 ************************************************************/
/*Project try 4 in class ********************************************************
	public static int n = 4; 
	public static int [] include = new int [5];
	public static int [] w = {0, 3, 4, 5, 6};
	public static int W = 13;
   public static void main(String [] args)  {
		int total = 0;
		for(int i = 1; i<=n; i++)
			total += w[i];
		sumOfSubsets(0, 0, total);
   }
	public static void sumOfSubsets(int i, int weight, int amtLeft) {
		if(promising(i, weight, amtLeft)){
			if(weight == W){
				for(int j = 1; j <= i; j++)
					if(include[j] == 1)
						System.out.print(w[j] + " ");
					System.out.println();
			}//end if weight
			else{
				include[i+1] = 0;
				sumOfSubsets(i+1, weight, amtLeft-w[i+1]);
				include[i+1] = 1;
				sumOfSubsets(i+1, weight+w[i+1], amtLeft-w[i+1]);			
			}//end else
		}//end promising
		
	}

	public static boolean promising(int i, int weight, int amtLeft){
	
		return((weight + amtLeft >= W)&&(weight == W || weight + w[i+1] <= W));
}
end try 4 in class ************************************************************/


/*Project 5 ********************************************************
	public static void main(String [] args)  {  
		int n = 4;
		int [][]A = {{0, 1, 2, 3, 4},
						 {1, 2, 6, 7, 9},
						 {2, 5, 10, 15, 18},
						 {3, 6, 13, 17, 20},
						 {4, 7, 16, 22, 27}};
	
		System.out.println(someRowIsSumOfTwoOthers(n, A));
	}
	public static boolean someRowIsSumOfTwoOthers(int n, int [][] A){
		boolean check; 
		for(int c = 1; c <= n; c++)
			for(int i = 1; i <= n; i++)
				for(int j = i+1; j <= n; j++){
					check = true;
					for(int k = 1; k <= n; k++)
						if(A[i][k]+A[j][k] != A[c][k])
							check = false;
					if(check == true){
						System.out.println("row " + i + " + row " + j + " : compare to row " + c);
						return true;
					}
				}//end for-j		
		return false; 
	}
end 5 ************************************************************/
/*Project 6 ********************************************************
	public static void main(String [] args)  {
		int n = 7;
		int W = 22;
		int [] w = {0, 7, 13, 16, 28, 41, 80, 152};
		int []solution = new int[n+1];
		
		System.out.println(sumOfSubsets(n,w,W,solution));		
	}
	public static boolean sumOfSubsets(int n, int [] w, int W, int[] solution) {	
		int rem;
		int sum= 0;
		int total = 0;
		int carry = 0;
		int []temp = new int [n+1];
		
		temp[n] = 1; 
	
		for(int i = 1; i <= n; i++)
			total += w[i];
			
		while (sum < total){
			sum = 0;
			//rem = solution[index]+ 1;
			for(int k = n; k >= 0; k--){
				rem = solution[k]+ temp[k]+carry;
				if(rem >= 2){
					rem = 0;
					carry = 1;
				}
				else
					carry = 0;			
				solution[k] = rem;
				//rem = solution[index]+carry;
			}//end for k
			
			for(int j = 1; j <= n; j++)
				if(solution[j] == 1)
					sum += w[j];
			
			if(sum == W){
				for(int y = 1; y<=n; y++)
					if(solution[y] == 1)
					 System.out.print(w[y] + " ");
					System.out.println();
				return true;
			}
		}//end while
			
	return false;
	}
end 6 ************************************************************/
/*Project 6_ver2 ********************************************************
	public static void main(String [] args)  {
		int n = 7;
		int W = 1000;
		int [] w = {0, 7, 13, 16, 28, 41, 80, 152};
		int []solution = new int[n+1];
		
		System.out.println(sumOfSubsets(n,w,W,solution));		
	}
	public static boolean sumOfSubsets(int n, int [] w, int W, int[] solution) {	
		int rem;
		int index;
		int sum= 0;
		int total = 0;
		int carry = 0;
	
		for(int i = 1; i <= n; i++)
			total += w[i];
			
		while (sum < total){
			sum = 0;
			index = n;
			rem = solution[index]+ 1;
			for(int k = 1; k <= n; k++){
				if(rem >= 2){
					rem = 0;
					carry = 1;
				}
				else
					carry = 0;			
				solution[index--] = rem;
				rem = solution[index]+carry;
			}//end for k
			
			for(int y = 1; y<=n; y++)
					 System.out.print(solution[y] + " ");
					System.out.println();
			
			for(int j = 1; j <= n; j++)
				if(solution[j] == 1)
					sum += w[j];
			
			if(sum == W){
				for(int y = 1; y<=n; y++)
					if(solution[y] == 1)
					 System.out.print(w[y] + " ");
					System.out.println();
				return true;
			}
		}//end while
			
	return false;
	}
end 6 ver2************************************************************/
/*Project 7********************************************************
 public static void main(String [] args)  { 
  		int n = 3;
		int[] w = {0, 1, 2, 3};
		printAllAchievableGoalsW(n,w);
 	} 
		   
 public static void printAllAchievableGoalsW(int n, int []w)  {
   
      int [] A = new int[n+1];
      printAllRec(n, 0, A, w);  
		
 }
 public static void printAllRec(int n, int i, int [] A, int []w)  {
 
		if (i == n) {
			int W = 0;
         for (int j = 1; j <= n; j++){
				System.out.print(A[j] + " ");
				if(A[j] == 1)
           		W += w[j];
			}
         System.out.println(" W = " + W);
      }  
      else
      {
         int k;
        	for (k = 0; k <= 1; k++)  {
          		A[i+1] = k;
					printAllRec(n, i+1, A, w);
         }//end for        
      }//end else
  }
	
end 7 ************************************************************/
/*Project 8******************************************************** 
 public static int index;
 public static void main(String [] args)  { 
 		index = 0; 
  		int n = 3;
		int[] w = {0, 1, 2, 3};
		printAll(n,w);
		System.out.println("index = " + index );
 	} 
		   
 public static void printAll(int n, int[] w)  {
   
      int [] A = new int[n+1];
		int [] storeW = new int [n+1];
     	printAllRec(n, 0, A, w, storeW);  
		
 }
 public static void printAllRec(int n, int i, int [] A, int []w, int [] storeW)  {
 
		if (i == n) {
			int W = 0;
			for(int j = 1; j <= n; j++)
				if(A[j] == 1)
           		W += w[j];
				
			if(promising(n, W, storeW))
				System.out.println(W + " ");
      } //end if 
      else
      {
         int k;
        	for (k = 0; k <= 1; k++)  {
          		A[i+1] = k;
					printAllRec(n, i+1, A, w, storeW);
         }//end for        
      }//end else
  }
  public static boolean promising(int n, int W, int [] storeW) {	
			for(int i = 1; i <= n; i++)
				if(storeW[i] == W)
					return false;
				else
					storeW[++index] = W;			   	     
    return true;
 }

end 8 ************************************************************/

//*Project 9********************************************************
   public static void main(String [] args)  {
		int n = 4;
		int W = 30;
		int [] w = {0, 7, 21, 58, 60}; 
		//int [] w = {0, 1, 3, 4, 5, 6}; 
		sumOfSubsets(n, w, W);
   }
	public static void sumOfSubsets(int n, int [] w, int W) {
		int total = 0; 
		int [] include = new int[n+1];
		for(int i = 1; i<=n; i++)
			total += w[i]; 
			
		sumOfSubsetsRec(n,0, 0, total, W, w,include);
	}
	public static void sumOfSubsetsRec(int n, int i, int weight, int amtLeft, int W, int []w, int[]include) {
		if(promising(i, weight, amtLeft, W, w,include)){
			if(weight == W){
				for(int j = 1; j <= i; j++){
					if(include[j] == 1)
						System.out.print(w[j] + " ");
					if(include[j] == -1)
						System.out.print("-" + w[j] + " ");
				}
					System.out.println();
			}//end if weight
			else if(i < n){
				include[i+1] = -1;
				sumOfSubsetsRec(n,i+1, weight-w[i+1], amtLeft-w[i+1], W, w, include);
				include[i+1] = 0;
				sumOfSubsetsRec(n,i+1, weight, amtLeft-w[i+1], W, w, include);
				include[i+1] = 1;
				sumOfSubsetsRec(n,i+1, weight+w[i+1], amtLeft-w[i+1], W, w, include);			
			}//end else
		}//end promising
		
	}

	public static boolean promising(int i, int weight, int amtLeft, int W, int[] w, int[]include){
	
	//return true;
		return((weight + amtLeft >= W));
		//return((weight + amtLeft >= W)&&(weight == W || weight + w[i+1] <= W));
}

//end 9 ************************************************************/



}//end class






















