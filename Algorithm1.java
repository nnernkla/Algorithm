/** Analysis of Algorithm1
	 Niphaphan Nernklang
*/

/**Project 1. Write an algorithm that has determines how many integers i, a<= i <=b are multiples of either k or m(or both).*/
           int pb_1_multiplesCount(int a, int b, int k, int m)
			  {
   			   int j, i = 0;
					for (j = a; j <= b; j++){
						if (j%k == 0 || j%m == 0)
							i++; 
					}					
					return i;    								  
			  }
*********************************************************************************************************************
/**Project 2. Write an algorithm that determines if array A is already in sorted order. */
			  boolean pb_2_alreadySorted(int [] A)
			  {
			  		boolean check = true;
					int min = A[0]; 
					int max = A[0];
				
					for(int i = 0; i < A.length-1; i++){
						if(A[i] <= A[i+1])
							max = A[i+1];
						else if(i != 0)
							check = false;
					}
			
					if(check == false){
						check = true;
						for(int i = 0; i < A.length-1; i++){
							if(A[i] >= A[i+1])
								min = A[i+1];
							else if(i != 0)
								check = false;
						}
					}
					return check;											  
			  }

*********************************************************************************************************************
/**Project 3. Write an algorithm that takes an array A of integers and determines if all values are unique 
(i.e., there are no repeats). If they are all unique, return true, otherwise return false.  What is the running time 
of your algorithm in terms of n = length of array A?*/
			  boolean pb_3_allUnique_1D(int[] A)
			  {
			  		for(int i = 0; i < A.length; i++)
						for(int j = 0; j < A.length-1; j++){
							if((i != j)&& (A[i]==A[j]))
								return false;
						}
					return true; 
			  }
			  
			  Running time of the algorithm = theta(n^2)
*********************************************************************************************************************
/** Project 4. Write an algorithm that takes an integer n and a two-dimensional, n×n, integer array B and determines
 if all values are unique (i.e., there are no repeats).  If they are all unique, return true, otherwise return false.  
 What is the running time of your algorithm in terms of n?*/
 			  boolean pb_4_allUnique_2D(intn, int[][] B)
			  {
			  		for(int i = 0; i < n; i++)
						for(int j = 0; j < n; j++)
							for(int m = 0; m < n; m++)
								for(int k = 0; k < n; k++){
									if(!(i== m && j== k)&&(B[i][j]==B[m][k]))
									return false;
								}
					return true; 
			  }
			  Running time of the algorithm = theta(n^4)
*********************************************************************************************************************
/** Project 5. Write an algorithm to determine if an integer n is prime. (An integer n is prime if it is greater than 1 
and has no positive divisors besides 1 and n.)*/
			  boolean pb_5_prime(int n)
			  {
			  		for(int i = 1; i < n-1; i++){
						if(n%(i+1) == 0)
							return false;
					}
				return true;  
			  }
*********************************************************************************************************************
/** Project 6. Row k in a 2-dimensional integer array dominates row m if for every column, the value in row k is larger
 than the value in row m. Write an algorithm that determines if some row in 2-d, n×n, integer array B dominates every
  other row in B.  If such a row exists, return its index.  If no such row exists, return-1.*/
  			  int pb_6_dominantRow(int n, int [][] B)
			  {
			  		boolean check = false;
					int i = 0, j, k;
			  		while(check == false && i < n){
						check = true;
						j = 0;
						while(check == true && j < n){
							k = 0; 
							if( i != j){
								while(check == true && k < n){
									if(B[i][k] <= B[j][k])
										check = false; 
									k++;
								} 
							}
							j++;
						}
						if(check == true)
							return i;
						else
							i++;
					}
					return -1; 
			  }
*********************************************************************************************************************
/** Project 7. Evaluate the following:
				a.log2(64)
				b.log2(1024x256)
				c.log2(2^n)
				d.log2(8^n)
				a.log2(x), where x = log2(256^128)
*/
				a = 6
				b = 80
				c = n
				d = 3n
				e = 10 
*********************************************************************************************************************
/** Project 8. Consider the following algorithm:
			  void cat(int n){
			  		SOPln("n = " + n);
			  		for(int k = 1; k <= n/2; k++){
						SOPln(k);
						for (int m = 1; m <= k; m++)
						SOPln(k + ", " + m);
					}
	(a) What is the output when n = 8?  
	(b) What is the exact formula for T(n) = # of lines of output of “cat” on argument n?
	(c) Which of the following sets does the correct formula for T(n) belong to?
*/

	a)
		 n = 8
	 	 1
		 1, 1
		 2
		 2, 1
		 2, 2
	 	 3
	 	 3, 1
	    3, 2
		 3, 3
		 4
		 4, 1
	 	 4, 2
	 	 4, 3
	 	 4, 4
	b) T(n) = [((n/2)+1)*((n/2)+2)]/2
	c) G

*********************************************************************************************************************
/** Project 9. Consider the following algorithm:
			  int horse(int n){
			  intp, k, t;
			  p = n;
			  k = 10;
			  while (p >= 1){
			  		k = k + p;
					for (t = n; t >= 0; t = t –3){
						System.out.println(p + ", " + t);
						k++;
					}
					p = p/3;
			  }
			  return k;
			  }
	(a) What is outputted and what is the return value when n = 9?  
	(b) Exactly how many lines of output will there be if horse is called with n = 729?  
	(c) Using the choices in the problem above, whichis the running time T(n) of “horse”?
*/
	a)
		 9, 9
		 9, 6
		 9, 3
		 9, 0
		 3, 9
		 3, 6
		 3, 3
		 3, 0
		 1, 9
		 1, 6
		 1, 3
		 1, 0
		 k = 35
	b) 1708
	c) E


*********************************************************************************************************************
/** Project 10. Answer the same questions for project 8, but for puppy, below:
			   voidpuppy(int n){
				int j, i = n;
				while (i >= 1){
					j = i;
					while (j <= n){
						System out.println(i + ", " + j);
						j = 2*j;
					}
					i = i/2;
				}
				}
	(a) What is the output when n = 8?  
	(b) What is the exact formula for T(n) = # of lines of output of “puppy” on argument n?
	(c) Which of the following sets does the correct formula for T(n) belong to?
*/
	a)  
		8, 8
		4, 4
		4, 8
		2, 2
		2, 4
		2, 8
		1, 1
		1, 2
		1, 4
		1, 8
	b) T(n) = [((log2 n)*((log2 n) + 1))/2]+ ((log2 n) + 1)
	c) C 

*********************************************************************************************************************