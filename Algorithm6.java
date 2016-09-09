
/** Algorithm6
    Niphaphan Nernklang
*/
**********************************************************************************************************\

/**Project 1 List all possible orders in which to multiply five matrices A x B x C x D x E.  Use the tree 
method to help you do this.*/
Answer: There are 14 possible orders for multiplying 5 matrices A, B, C, D, E that are:
1. A x(((B x C)x D)x E)
2. A x((B x(C x D))x E)
3. A x(B x((C x D)x E))
4. A x(B x(C x(D x E)))
5. A x((B x C)x(D x E))

6. (A x B)x((C x D)x E)
7. (A x B)x(C x(D x E))

8. ((A x B)x C)x(D x E)
9. (A x(B x C))x(D x E)

10. ((A x B)x C)x D)x E
11. ((A x(B x C))x D)x E
12. (A x((B x C)x D))x E
13. (A x(B x(C x D)))x E
14. ((A x B)x(C x D))x E
 
********************************************************************************************************** 
/**Project 2 Suppose you are given the final P matrix as follows
	   P | 1| 2| 3| 4| 5| 6| 7| 8|
       1| 0| 1| 2| 1| 4| 4| 4| 4| 
       2| 0| 0| 2| 2| 4| 2| 3| 2| 
       3| 0| 0| 0| 3| 4| 4| 4| 4| 
       4| 0| 0| 0| 0| 4| 4| 5| 4| 
       5| 0| 0| 0| 0| 0| 5| 6| 7| 
       6| 0| 0| 0| 0| 0| 0| 6| 6| 
       7| 0| 0| 0| 0| 0| 0| 0| 7| 
       8| 0| 0| 0| 0| 0| 0| 0| 0| 
		
		a)  What is the optimal order in which to multiply matrices A1 through A8?
		b)  What is the optimal order in which to multiply matrices A2 through A7?       
*/
Answer: 
a)  ((A1 x(A2 x(A3 x A4)))x(((A5 x A6)x A7)x A8))
b)  ((A2 x A3)x((A4 x A5)x(A6 x A7)))
 
********************************************************************************************************** 
/**Project 3 How many different orders are there to multiply 6 matrices?  7 matrices?.*/
Answer:
- 6 matrice = 42 different orders.
- 7 matrice = 132 different orders.
 
**********************************************************************************************************  
/**Project 4 Use dynamic programming (no recursion) to write the method numOrders, which takes an argument
 n and returns the number of ways to multiply n matrices.  Show the output when called with inputs 
1, 2, 3, ..., 10.*/

int numOrders(int n){
	int [] A = new int [n+1]; 
	int sum = 0; 
	
	for (int i = 1; i <= n; i++){
		if(i == 1 || i == 2)
			sum = 1; 
		else{ 
			for(int j = 1; j <= i-1; j++)
				sum += A[j]*A[i-j];			
		}
		A[i] = sum; 
		sum = 0;			
	}	
return A[n]; 
}

output: n = 1 has 1 multiple ways
        n = 2 has 1 multiple ways
		  n = 3 has 2 multiple ways
		  n = 4 has 5 multiple ways
		  n = 5 has 14 multiple ways
		  n = 6 has 42 multiple ways
		  n = 7 has 132 multiple ways
		  n = 8 has 429 multiple ways
		  n = 9 has 1430 multiple ways
		  n = 10 has 4862 multiple ways

**********************************************************************************************************
 
/**Project 5 Finish computing the optimal way to multiply matrices A1 through A5, where their dimensions 
are as follows.  You have only left to compute M[1][5].  Also, what is P[1][5]?

		A1: 6 x 5. A2:  5 x 4.A3:   4 x 6.A4:   6 x 5.A5:  5 x 8.
		 P|  1|  2|  3|  4|  5| 
       1|  0|120|264|360|  ?|  
       2|  0|  0|120|220|420|  
       3|  0|  0|  0|120|280| 
       4|  0|  0|  0|  0|240|  
       5|  0|  0|  0|  0|  0| */

answer: - M[1][5] = 592
		  - P[1][5] = 2

**********************************************************************************************************
/**Project 6 a) Trace through the chained matrix multiplication algorithm (minmult) for the product 
A1 x A2 x A3 xA4 x A5, where the dimensions of the matrices are as follows:
		A1:  5 x 10
		A2:  10 x 6
		A3:  6 x 4  
		A4:  4 x 5
		A5:  5 x 8
	
		b)    Find the optimal order and cost (number of elementary multiplications) to multiplyA1 through A5.
				(A1 x A2 x A3 x A4 x A5)
		c)    Find the optimal order and cost to multiplyA2 through A5.
*/
Answer : 
a) M:  0   300 420 520 720 
		 0   0   240 420 720 
		 0   0   0   120 352 
		 0   0   0   0   160 
		 0   0   0   0   0

	P: P : 0 1 2 3 4 
			 0 0 2 2 3 
			 0 0 0 3 3 
			 0 0 0 0 4 
			 0 0 0 0 0

b) - Optimal order : ((((A1 x A2)x A3)x A4)x A5)
	- Optimal cost  : 720

c) - Optimal order A2 to A5 : ((A2 x A3)x(A4 x A5))
	- Optimal cost A2 to A5 : 720

**********************************************************************************************************
/**Project 7 a) Trace through the chained matrix multiplication algorithm (minmult) for the product 
A1 x A2 x A3 x A4 x A5, where the dimensions of the matrices are as follows:
		A1:  10 x 4
		A2:  4 x 5
		A3:  5 x 20
		A4:  20 x 2
		A5:  2 x 50.
		
b)    Find the optimal order and cost to multiplyA1 through A5.*/
answer:
a) M:  0   200 1200 320 1320 
	    0   0   400  240 640 
	    0   0   0    200 700 
	    0   0   0    0   2000 
	    0   0   0    0   0 
		 
   P: 0 1 1 1 4 
		0 0 2 2 4
		0 0 0 3 4
		0 0 0 0 4 
		0 0 0 0 0 
		
b) - Optimal order : ((A1 x(A2 x(A3 x A4)))x A5)
	- Optimal cost  : 1320 
      
**********************************************************************************************************
/**Project Implement minmultand orderin Java.  Test your program on examples of size 3 that 
you can verify by hand, and the example in Section 3.4 of the book tomake sure your program is working.  
Then run your program to determine the minimum number of elementary multiplications and the optimal order
 in which to multiply 10 matrices with dimensions given by:
 
 int [] d = {100, 50,200, 300, 150, 90, 130, 600, 400,80,220};  
 
 Give the resulting Pand Mmatrices. Your header will be slightly different than the book's.  Make it:
 
 int minmult(int n, int [] d, int [][] M, int [][] P) {...}
 
 You will pass in arrays P and M, each of size n + 1 by n + 1, but you will use only indices 1 through n.
 Array dwill also have size n + 1, but here all cells are part of the input.  Have your main program print
 the resulting M and Pmatrices for n = 10 and d given above, as well as the optimal order to multiply all of them.

*/
public static void main(String[] args) {
	int n = 10; 
   int [][] P = new int [n+1][n+1]; 
	int [][] M = new int [n+1][n+1]; 
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
output:

n = 10 has 25990000 multiple ways
 
M : 0 1000000 4500000 6000000 6375000 7160000 13410000 24410000 24410000 25990000 
	 0 0 3000000 5250000 5925000 6510000 10410000 22410000 24010000 24890000 
	 0 0 0 9000000 9450000 11790000 27270000 45270000 35856000 39376000 
	 0 0 0 0 4050000 7560000 27270000 43470000 31056000 36336000 
	 0 0 0 0 0 1755000 13455000 34020000 27456000 30096000 
	 0 0 0 0 0 0 7020000 28620000 26376000 27960000 
	 0 0 0 0 0 0 0 31200000 25440000 27728000 
	 0 0 0 0 0 0 0 0 19200000 29760000 
	 0 0 0 0 0 0 0 0 0 7040000 
	 0 0 0 0 0 0 0 0 0 0 
	 
P : 0 1 1 1 1 1 1 1 1 1 
	 0 0 2 3 4 5 6 7 8 9 
	 0 0 0 3 3 5 5 5 3 9 
	 0 0 0 0 4 5 5 5 4 9 
	 0 0 0 0 0 5 6 5 5 9 
	 0 0 0 0 0 0 6 7 6 9 
	 0 0 0 0 0 0 0 7 7 9 
	 0 0 0 0 0 0 0 0 8 9 
	 0 0 0 0 0 0 0 0 0 9 
	 0 0 0 0 0 0 0 0 0 0 
	 
Optimal order : (A1((((((((A2A3)A4)A5)A6)A7)A8)A9)A10))
 
**********************************************************************************************************  


  

 
	





















































































