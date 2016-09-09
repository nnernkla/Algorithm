
/** Algorithm4
    Niphaphan Nernklang
*/
**********************************************************************************************************

/**Problem 1 What is the output of a call to foo( )? (Use the definition of merge(A, low, mid, high) from

 class—it the book, it is merge2). Don't just run this—you will have to do something like this on the next
 
 quiz, so you need to practice it.
 
      void foo() {int [] A = {27, 10, 12, 20, 25, 13, 15, 22};
         printArray(A, 0, 7);
         mystery(A, 0, 7);
      }
      
      void mystery(int [] A, int low, int high) {
      
         for(ints=2;s<=high-low+1;s=s*2) {
            for (int i = low; i < high; i = i + s){
                int h = i + s - 1;
                int m = (i + h)/ 2;
                merge(A, i, m, h);
            }    
            printArray(A, low, high);
         }
       }
       
       void printArray(int [] A, int low, int high) {
       
         for (int i = low; i <= high; i++) {
            SOP(A[i] + " ");               
         }
         SOPln(); 
       }
      */
  Output =  27 10 12 20 25 13 15 22 
            10 27 12 20 13 25 15 22 
            10 12 20 27 13 15 22 25 
            10 12 13 15 20 22 25 27 
  
**********************************************************************************************************
 
/**Problem 2 Suppose array A in the above Problem has size n, which is a power of 2. What is the running time

 in terms of n (use theta notation) of : mystery(A, 0, n - 1)?*/
 
 Tn = log n * n/2 * 2. So, it is in Theta-O (n log n) 

**********************************************************************************************************
/**Project 3 Let LargeInt u = 4729 and let LargeInt u = 3518. Using the divide and conquer algorithm prod2

(Algorithm 2.10, Section 2.6, page 81), what are the values of each of these variables (after initialized):

n,m,x,y,w,z,r,p,q? what is the return value = p x 10^2m + (r-p-q) x 10^m + q? */
- n = 4
- m = 2
- x = 47
- y = 29
- w = 35
- z = 18
- r = 4028
- p = 1645 
- q = 522

- the return value u*v = 16636622
**********************************************************************************************************
/**Project 4 How many LargeInt multiplications of size n/2 are done using the "trivial" way? How many are

done using this "smarter" divide and conquer algorithm?*/ 
 
- normal way: T(n) = 4T(n/2) + Cn. So, its multiplications is 4. 
- smarter way: T(n) = 3T(n/2) + Cn. So, its multiplications is 3.         
**********************************************************************************************************
/**Project 5 Use divide and conquer (recursion) to write the method numWaysToMakeChange

      where n is the number of cents you have total, k is the number of types of coins you have, and D is
      
      an array with the denominations of the coins in ascending order. Use the fact that you can either use
      
      no coins of the highest denomination, or you can use at least one coin of the highest denomination. 
      
      What are your base cases?
      
         Test your algorithm on the following:
      
         1. How many ways are there to make change for 100 cents ($1) using quarters, dimes, nickels andpennies?
         
         (D = {0, 1, 5, 10, 25}, n = 100, k = 4).
         
         2. How many ways are there to make change for 738 cents ($7.38) using dollar coins, half-dollar coins,
         
         quarters, dimes, nickels, and pennies? (D = {0, 1, 5, 10, 25, 50, 100}, n = 738, k = 6).*/
 
int numWaysToMakeChange(int n, int k, int [] D) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 0; 
		else if(k == 1)
			return 1;
		else{
			return numWaysToMakeChange(n, k-1, D) + numWaysToMakeChange(n-D[k],k,D);  
		}     
}
So, from the program above, base cases are:
	- return 0 if n < 0
	- return 1 if n == 0
	- return 1 if k == 1
	
the ouput for two example are: 
	1. 242 ways
	2. 524688 ways
**********************************************************************************************************  

/**Project 6 Without using recursion, using the "Dynamic Programming" approach, write the function numWaysToMakeChange
 
 so that it runs in time theta-O(nk).You will need to declare a local 2-d array in your function.
*/
int numWaysToMakeChange(int n, int k, int [] D) {
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

This program is able to run and it returns the same answer as a problem 5. 
**********************************************************************************************************  
/**Project 7 You are given two-dimensional array P as follows:
      
      P |v1|v2|v3|v4|v5|v6|v7|v8|v9|
      v1| 0| 4| 5| 0| 0| 8| 9| 0| 5|
      v2| 7| 0| 0| 8| 7| 8| 3| 0| 7|
      v3| 7| 7| 0| 7| 7| 8| 0| 7| 7|
      v4| 7| 0| 7| 0| 7| 8| 0| 2| 7|
      v5| 9| 9| 0| 9| 0| 9| 9| 0| 5|
      v6| 0| 8| 5| 1| 1| 0| 9| 0| 5|
      v7| 0| 4| 5| 1| 1| 8| 0| 1| 5|
      v8| 7| 0| 7| 0| 7| 0| 4| 0| 7|
      v9| 7| 7| 0| 7| 0| 8| 0| 7| 0|
      
    void printPath(int s, int d, int [][] P) {            
    
      if (P[s][d] != 0)  {               
         int m = P[s][d];              
         printPath(s, m, P);               
         SOP("v_" + m +"  ");               
         printPath(m, d, P);
      } 
    }         
    
    void printPathAll(int s, int d, int [][] P) {            
    
      SOP("v_" + s + "  ");            
      
      if (P[s][d] != 0)  {               
         int m = P[s][d];               
         printPathAll(s, m, P);               
         SOP("v_" + m + "  ");               
         printPathAll(m, d, P);
      }            
      
      SOP("v_" + d + "  ");         
  }
  
  Trace through and show the output for the call printPath(2, 5, P).
*/
   - the answer of printPath(2, 5, P) =  v_3  v_7  v_1
**********************************************************************************************************  
/**Project 8 Trace through and show the output for the call printPathAll(2, 5, P) .
*/
   - the answer of printPathAll(2, 5, P) = 
     v_2  v_2  v_2  v_3  v_3  v_3  v_7  v_7  v_7  v_7  v_7  v_1  v_1  v_1  v_5  v_5  v_5
**********************************************************************************************************  

 
	















































































