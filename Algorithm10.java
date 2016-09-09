
/** Algorithm 10
    Niphaphan Nernklang
*/
**********************************************************************************************************\

/**Project 1 Write them method odd below which takes an array of integers and returns true if the number of
1's in the arrayis odd (and false otherwise).*/
boolean odd(int n, int [] A) {
	int count = 0; 
		for(int i = 1; i <= n; i++)
			if(A[i] == 1)
				count++;
		
		if(count % 2 == 0)
			return false;	  	     
    return true;
}
  
********************************************************************************************************** 
/**Project 2 Write the method validNQueens that takes a two dimensional character array Bwith n rows and n 
columns, indexed 1 to n.  The character 'Q' in cell i, j means there is a Queen in that location.  Your 
method should return true if no queen can capture any other queen vertically, horizontally, or diagonally.  
What is the running time?*/

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

Its running time is 2(n^2) or it is in O(n^2)
					
********************************************************************************************************** 
/**Project 3 Write the method valid MColoring that takes the adjacency matrix W of an undirected graph on n 
vertices as well as an integer array vcolor that assigns a color (an integer) to each vertex. Also, it takes 
an integer m.  The integers used as colors in vcolor do not have to be 1 through m.  For example, if m = 3, 
the three colors in vcolor could be 27, 55, and 984. However, if there are more than m distinct integers in 
vcolor, then it is not a valid m-coloring. */
 
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
	
	if(p > m)
		return false;
	
	return true;		
 }
**********************************************************************************************************  
/**Project 4 Rewrite the backtracking sumOfSubsets without any global variables.  Write any auxiliary methods 
that you call.  You may assume array w is in sorted order already.*/

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

**********************************************************************************************************
 
/**Project 5 Write an algorithm that takes an n by n two-dimensional array A of integers, and return true if 
some row in A is equal to the sum of two other rows in A.What is the running time of your algorithm? */

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

The running time is O(n^4)

**********************************************************************************************************
/**Project 6 Write a brute-force approach Sum of Subsets algorithm without recursion.  You may call auxiliary 
methods, but none may use recursion.  If there is a solution, it returns true and the array solution should 
come back with one of the possible solutions (1 in cell i if and only if w[i] is in a solution subset).  
If there is no solution, the algorithm returns false. */     

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
			for(int k = n; k >= 0; k--){
				rem = solution[k]+ temp[k]+carry;
				if(rem >= 2){
					rem = 0;
					carry = 1;
				}
				else
					carry = 0;			
				solution[k] = rem;
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
	
**********************************************************************************************************
/****Project 7 Write an algorithm that takes a set of n positive integers in array w, which is already sorted 
in increasing order, and prints out every integer W such that there is some subset of the integers in w whose 
sum is W.*/

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
**********************************************************************************************************
/**Project 8 What is the largest number of possible solutions that your method in Problem 7 could print out?  
What is the fewest?  Answer both of those questions if we were to allow multisets, i.e., integers may appear 
more than once in w. */
Assume all sets have size n = 4,

For distinct element set:
     -  Largest #W = 2^n : sample w = { 1, 2, 4 ,8} which has #W = 16 
     -  Smallest #W = [n(n+1)/2]+1 : sample w = {1,2,3,4} which has #W = 11
For multiset:
     -  Largest #W = 2^n : sample w = { 1, 2, 4, 8} which has #W = 16 (it doesn't have to have repeat elements) 
     -  Smallest #W = n+1 : sample w = {1,1,1,1} which has #W = 5
 
**********************************************************************************************************  
/**Project 9 Suppose we extend the Sum of Subsets problem so that subtraction is allowed?  For example, if 
our original set is w = {7, 13, 16, 28, 41, 80, 152} and the goal is W = 156then one solution could be
7 + 28 + 41 + 80 = 156, but another solution could be  7 +13 –16 + 152 = 156.Write an algorithm to print out 
all possible solutions for this version of Sum of Subsets, where subtraction is allowed.*/
 
public static void sumOfSubsets(int n, int [] w, int W) {
		int total = 0; 
		int [] include = new int[n+1];
		for(int i = 1; i<=n; i++)
			total += w[i]; 
			
		sumOfSubsetsRec(0, 0, total, W, w,include);
	}
	public static void sumOfSubsetsRec(int i, int weight, int amtLeft, int W, int []w, int[]include) {
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
			else{
				include[i+1] = -1;
				sumOfSubsetsRec(i+1, weight-w[i+1], amtLeft-w[i+1], W, w, include);
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
**********************************************************************************************************
	
























































































