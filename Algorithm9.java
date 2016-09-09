
/** Algorithm9
    Niphaphan Nernklang
*/
**********************************************************************************************************\

/**Project 1 Use the Backtracking technique, similar to the code in ArbyLoops,to create a method that takes
 an integer n and prints out all ?!permutations of the integers 1,2,3,...,?.  How does your "promising" method
 work?  What is the running time of your method?*/
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
 
 The running time of the algorithn is: O(n!)
********************************************************************************************************** 
/**Project 2 Use the n-queens backtracking algorithm to find the first two solutions that are printed out
 given that the queens in the first three rows may NOT be moved (you will start the algorithm in row 4)
   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 
 1 |   |   |   | Q |   |   |   |   |
 2 |   | Q |   |   |   |   |   |   |
 3 |   |   |   |   |   |   |   | Q |
 4 |   |   |   |   |   |   |   |   |
 5 |   |   |   |   |   |   |   |   |
 6 |   |   |   |   |   |   |   |   |
 7 |   |   |   |   |   |   |   |   |
 8 |   |   |   |   |   |   |   |   |*/
 
 answer: first solution is {4, 2, 8, 5, 7, 1, 3, 6}
 			second solution is {4, 2, 8, 6, 1, 3, 5, 7}
					
********************************************************************************************************** 
/**Problem 3 Trace through the backtracking 2, then 4, then 3-coloring algorithm, with colors R and B, then
R, B, G, Y, then R, B, G.  Give the first solution (if any) for the two-coloring, the 4-coloring, and the 
3-coloring.   If the graph has no valid 2, 3, or 4-colorings, just state so.  BEWARE THE CURVED EDGE BETWEEN
 v9 and v11.  Also, not the vertices are not numbered in order in a circle..*/
 
 Answer: 2-color : invalid for two colors.
 			4-color : {R, R, B, B, B, R, G, G, B, R, Y}
			3-color : invalid for three colors. 
 
**********************************************************************************************************  
/**Project 4 The code for the n-Queens problem that we wrote in class is given in the file "NQueensProblemTotal.java" 
(with two extra lines that are commented out).  In this file, change the return type of the method nqueensfrom void
to int, and alter the method nqueens so that it does not print any of the solutions, but rather returns the total
number of solutions.  Test this by uncommenting out those two lines and removing the void call to nqueens.  
For n = 5, there are 10 solutions.  For n = 7, there are 40 solutions.  Run your code and show the results for all
values of n between 8and 12.  */
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
Output: Number of solutions of n = 8 is 92
	 	  Number of solutions of n = 9 is 352
	 	  Number of solutions of n = 10 is 724
		  Number of solutions of n = 11 is 2680
		  Number of solutions of n = 12 is 14200

**********************************************************************************************************
 
/**Project 5 In the file "NQueensProblemFirst.java", a global variable callshas been added which keeps track
 of the total number of calls the the method nqueens. If you run it as is with the call to nqueens(5), you will
 see that it makes a total of 221calls (each call is printed) and it still prints each solution when found.  
 Notice also that the first solution is found after call number 16. 
 
 In this file, alter the code so that the method nqueensstops after it prints the first solution.  For example,
 when called with n = 5, nqueensshould print the numbers 1 through 16, then the first solution, and then stop.
 You may NOT usea System.exitcall to halt your program.  It must still get to the println statement in main that
 is after the call to nqueens.  To check your code for n = 4, the first solution is found after 27 calls, and 
 for n = 6 the first solution is found after 172 calls.  Run your code and show the results for all values of 
 n between 8 and 12.Just include the first solution printout and the number of calls after it.  So for example, 
 for n = 6, you would just include the output as below (and not all the numbers counting up to it):
 2  4  6  1  3  5  Done, with number of calls = 172  */
 
 public static int calls;
   public static void main(String [] args)  {
		for(int i = 8; i <= 12; i++){
			System.out.print("n = " + i + " : "); 
      	calls = 0;
     	 	nqueens(i);  
     	 	System.out.println("Done, with number of calls = " + calls);  
		}
   }

   public static void nqueens(int n)  {          
      int [] col = new int[n+1];
      nqueens_rec(n, 0, col);
   }
   
   public static boolean nqueens_rec(int n, int i, int [] col)  {
   	boolean val = false;
      calls++;      
      if (promising(i, col)) {
         if (i == n)  {
            for (int j = 1; j <= n; j++)
               System.out.print(col[j] + "  ");
            System.out.println();
				return true;
         }
         else  
            for (int k = 1; k <= n; k++) {
               col[i+1] = k;
               val = val || nqueens_rec(n, i+1, col);
            }
				return val;
      }
		return false;
   }
      
   public static boolean promising(int i, int [] col) {
      for (int k = 1; k < i; k++)
         if (col[k] == col[i] ||
             col[k] - k == col[i] - i ||
             col[k] + k == col[i] + i)
           return false;         
      return true;
   }
 
 output : n = 8 : 1  5  8  6  3  7  2  4  
 			 Done, with number of calls = 877
			 
			 n = 9 : 1  3  6  8  2  4  9  7  5 
			 Done, with number of calls = 334
			 
			 n = 10 : 1  3  6  8  10  5  9  2  4  7  
			 Done, with number of calls = 976
			 
			 n = 11 : 1  3  5  7  9  11  2  4  6  8  10  
			 Done, with number of calls = 518
			 
			 n = 12 : 1  3  5  8  10  12  6  11  2  7  9  4  
			 Done, with number of calls = 3067

**********************************************************************************************************
/**Project 6 A Four-Clique in a graph is a set of four vertices such that every pair within this set of four
is adjacent.  Write a boolean method that takes the number of vertices n and a 0-1 adjacency matrix W and 
determines if the graph has a four-clique or not. */     
	public static boolean has4clique(int n, int [][]W){
		for(int i = 1; i <= n; i++)
			for(int j = i+1; j <= n; j++)
				for(int k = j+1; k <= n; k++)
					for(int m = k+1; m <= n; m++)
						if(W[i][j] == 1 && W[i][k] == 1 && W[i][m] == 1)
							if(W[j][k] == 1 && W[j][m] == 1 && W[k][m] == 1)
								return true;
		return false; 
	}
**********************************************************************************************************
/****Project 7 Generalize the method in the previous problem so that it takes a parameter k and determines 
if the graph has a k-clique or not.  A k-clique is simply a set of k vertices in the graph such that there 
is an edge between every pair of vertices within those k vertices..*/

	public static boolean hasKclique(int k, int n, int [][]W)  {  
     int [] A = new int[k+1];
     return hasKcliqueRec(k, 0, n, A, W);  
	}
	
	public static boolean hasKcliqueRec(int k, int i, int n, int [] A, int[][] W)  {
		boolean val = false;
   	if(promising(i, A, W)){
      	if (i == k) 
				return true;
     	 	else{
         	int m;
        	   for (m = 1; m <= n; m++)  {     
           	 	A[i+1] = m;
           	 	val = val || hasKcliqueRec(k, i+1, n,  A, W);
         }//end for
         return val;   
      }//end else
		}//prom
		return false;
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
		      
**********************************************************************************************************
/**Project 8 Write a greedy-coloring algorithm that tries to color the vertices of a graph with as few colors
as possible as follows: Start with color 1.  Go through vertices 1 through n, coloring each one Color 1 (Red) 
as unless it conflicts with a previously colored red vertex.  If all the vertices are colored, stop.  
Otherwise, now use Color 2 (Blue).  Go through vertices 1 through ncoloring each uncolored vertex Color 2 (Blue) 
unless it conflicts with a previously colored blue vertex.  If all the vertices are colored, stop.  Else, now go 
to Color 3.  Keep increasing the color number until all the vertices are colored.  Write this injava—it returns 
the minimum number of colors it found that it needed.What is its running time?  Find a counter-example graph to 
show this is not always correct.*/
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
		return color; 
	}
	
	-The running time of this algorithm is O(n^3)
	-The counter example is W = {{0, 1, 1, 0, 0},
										  {1, 0, 1, 0, 1},
										  {1, 1, 0, 1, 1},
										  {0, 0, 1, 0, 1},
										  {0, 1, 1, 1, 0}}
	 From this graph, greedy way will use 4 colors but optimal way will use only 3 colors.
	 
**********************************************************************************************************  
/**Project 9 Determine if the following graph has a valid 2-coloring, but DO NOT USE THE BACKTRACKING METHOD.
Try to figure out a more efficient way.  Hint:  If you have only 2 colors and a vertex is colored Red, 
then all the ones it connects to must be Blue.  If the graph has a 2-coloring, give it below.  There aretwo arrays
 in case you mess up.(This question was on an undergraduate algorithms final exam, so no whining!)*/
 
 Answer: This graph is valid for 2-coloring 
 			The result is : R, B, B, B, R, B, B, R, R, B, B, R, B, B, R, R, B, R, R, R, B, R, R, B, R
********************************************************************************************************** 
/**Project 10 Now that you have figured out how to 2-color quickly, write the non-recursive, O(n^2)running
time algorithm to find if a graph has a valid 2-coloring.  If it does, return true and assign vcolor the
coloring, otherwise, just return false.(vcolor is indexed from 1 to n, like W).*/
public static boolean fastTwoColoring(int n, int [][] W, int[] vcolor){
	int count = 0; 
	int v = 1;
	int color;
	boolean [] check = new boolean [n+1]; 
	
	vcolor[v] = 1; //assign 1 = red, 2 = blue, and 0 = no color yet
	check[v] = true;
	count++; 
	
	while(count < n){
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
	}//end first while-loop
	return true;
}
**********************************************************************************************************  

 
	
























































































