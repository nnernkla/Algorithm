
/** Analysis of Algorithm3
    Niphaphan Nernklang
*/
**********************************************************************************************************

/**Project 1 Write a program that solves the following problem:  What is the smallest positive integer n for

which the following is true: 6n^2.81-6n^2<n^3-n^2? Solve this question by writing a program that outputs 

the answer by trying each integer starting from 1 until the left hand side is left than the right hand side*/
  public static void main(String[] args) {
		  double left, right;
		  int n = 0; 
		  do 
		  {
		  		n++;
		  		left = (6 * Math.pow(n,2.81))-(6 * Math.pow(n,2));
		  		right = Math.pow(n,3)- Math.pow(n,2);
		  }while(left >= right);
		  
        System.out.println("n = " + n);  
    }
	 
	 n = 12435 
**********************************************************************************************************
 
/**Project 2 Write the method partition without swapping or exchanging any values (as is done in the book,

Algorithm 2.7, Section 2.4, page 66).  Do this by declaring two temporary arrays of appropriate length,

and copy all values lower than A[low] in one array, and the other to the second array.  Then copy them 

back into A and return the correct pivotpoint value.*/

int partition(int[] A, int low, int high)  { 

   int n = (high - low) + 1; 
   int [] left = new int [n];
   int [] right = new int [n]; 
   int pivot = A[low];  
   int pivotPoint = low;
   int k = 0, m = 0, l = 0, r = 0, p = 0; 
   
   for(int i = low + 1; i < high+1; i++){
      if(pivot >= A[i])
         left[k++] = A[i];
      else 
         right[m++] = A[i];
   }//end for
   
   p = k + low;
   for(int j = low; j <= high; j++){
      if (k != 0){
         if (j < p)
             A[j] = left[l++];
         else if (j == p){
             A[j] = pivot;
             pivotPoint = p; 
         }
         else{
            A[j] = right[r++];
         }
      }
   }
         
   return pivotPoint; 

}
**********************************************************************************************************
/**Project 3 (a)  Write the algorithm quickSort, which calls partition.*/

void quickSort(int[] A, int low, int high)  {
   int p; 
   
   if(low < high){
      p = partition(A, low, high); 
      quickSort(A, low, p-1);
      quickSort(A, p+1, high);
   }
 
}
method partition is in problem2 
/**(b)  Write the algorithm mergeSort, which calls merge.*/

void mergeSort(int[] A, intlow, inthigh)  {
	 int mid = (low + high)/2;
      
	 if(low < high){
        mergeSort(A, low, mid);
        mergeSort(A, mid+ 1, high); 
        merge(A, low, mid, high); 
      }

}
void merge(int [] A, int low, int mid, int high) {
      int i = low;
      int j = mid+1;
      int k = low;
      int [] B = new int [high+1];
  
      while (i <= mid && j <= high){
         if(A[i] < A[j])
           B[k++]= A[i++]; 
         else
           B[k++] = A[j++];          
      }
      
     while(i <= mid)
         B[k++] = A[i++];
         
      while(j <= high)
         B[k++] = A[j++];
         
      for(int m = low; m <= high; m++)
         A[m] = B[m];      
}


**********************************************************************************************************
/**Project 4 Write an algorithm (in JAVA) that takes two integer arrays Aand B, each of length n.  Each array

 represents a LargeInt (cell 0 has the digit in the 1's column, cell 1 has the digit in the 10's column, cell
 
 2 has the digit in the 100's column, etc).  Return a new array of length n + 1(do NOT modify Aor B) which
 
 represents a LargeInt containing the sum of Aand Bas LargeInts.  For example, if Aand Bwere the LargeInts 
 
 below, your algorithm would return the third array below. 
 
              A :  7 3 8 5 2 0 1 0 8 9 7 6 2 4
              B :  5 2 7 9 6 5 3 0 8 5 1 8 9 2
   array return :1 2 6 6 4 8 5 4 1 7 4 9 5 1 6*/ 
 
 int []LargeIntSum(int[] A, int []B, int n)  {
 	int [] C = new int [A.length+1];
	int sum = 0; 
	int rem = 0;
	int carry = 0;
	int j = n;
	 
	for(int i = n-1 ; i >= 0; i--){
		sum = (A[i]+B[i]) + carry; 
		if(sum < 10){
			C[j--] = sum;
			carry = 0;
		}
		else{
			rem = sum % 10;
			carry = sum / 10;
			C[j--] = rem; 
		}			
	}
	if(carry != 0)
		C[j] = carry; 
	return C;
 }         
**********************************************************************************************************
/**Project 5 Write a function which takes an integer array A of length nand an integer m. Array A represents

 a LargeInt(as in the previous problem). Write the function times 10To_m, which  returns a new array of length
 
 n + m which represents the product of the value in A * 10^m */
 
int[] times10To_m(int[] A, int n, int m)  {
		int [] B = new int [n+m];
	
		for (int i = 0; i < n+m; i++)
			if (i < n)
				B[i] = A[i];
			else
				B[i] = 0;  
	
		return B; 	
}
**********************************************************************************************************  

/**Project 6 Write a function which takes an integer array A of length n and an integer m. Array A represents

 a LargeInt (as in the previous problem). Write the function div10To_m which returns a new array of length
 
 n-m containing the value  A div 10^m(integer division).
*/

int[] div10To_m(int[] A, intn, intm)  {
	int [] B = new int [n-m];
	
		if (m != 0){
			for (int i = 0; i < n-m; i++)
				B[i] = A[i]; 
		}
		else
			B = A;  
	
	return B; 	
}
**********************************************************************************************************  
/**Project Write a function which takes an integer array A of length nand an integer m. Array A represents

 a LargeInt (as in the previous problem). Write the function rem10To_m returns a new array of length m containing

 the value A mod 10^m }*/
 
 int[] rem10To_m(int[] A, int n, int m)  {
 		int [] B;
		int j = 0; 
		if(m != 0){
			B = new int [m];
			for (int i = n-m; i < n; i++)
				B[j++] = A[i];
		}
		else
		{
			B = new int [1];
			B[j++] = 0;    
		}
	return B; 	
}
**********************************************************************************************************  
/**Project 8 Let LargeInt u =4729and let LargeInt v =3518.  Using the divide and conquer algorithm prod2

(Algorithm 2.10, Section 2.6, page 81), what are the values of each of these variables (after initialized)

m,n,w,x,y,z,r,p,q? What is the return value = p * 10^2m + (r-p-q) * 10^m = q? 
*/

**********************************************************************************************************  
/**Project 9 nothing*/

**********************************************************************************************************  
/**Project 10 Write a divide and conquer algorithm that takes an integer n and returns the value2^n. You may use
 
 NO looping statements; only recursion.  You may assume that n is positive.
      
      (a)Write this so the running time is theta-O(n)
      
      (b)Write this so the runningtime is theta-O(2^n)
 }*/
//(a)Write this so the running time is theta-O(n)
 intTwoTo_n(int n){
 	if(n == 0)
			return 1;
		else
			return (2 * TwoTo_n(n-1));
 }
//(b)Write this so the runningtime is theta-O(2^n) 
 intTwoTo_n(int n){
 		int sum = 0;
		if(n == 0)
			return 1;
		else {
			sum = TwoTo_n(n-1) + TwoTo_n(n-1);
			return sum;  
		}
 }
 
 or 
 intTwoTo_n(int n){
 		int sum = 0;
		if(n == 1)
			return 2;
		else {
			sum = TwoTo_n(n-1) + TwoTo_n(n-1);
			return sum;  
		}
 }
 
**********************************************************************************************************  
/**Project 11 (+4points extra credit).  Write the method in Problem 10 (you may or may not use recursion for

 this problem) so that your algorithm performs O(log2 n)multiplications only.
*/
public static int TwoTo_n(int n){
	int x;
	if(n == 1)
		return 2;
	else{
		if(n % 2 == 0){
			x = TwoTo_n(n/2); 
			return (x*x);
		}
		else{
			x = TwoTo_n((n-1)/2); 
			return (x*x*2);
		}	
	}
} 
**********************************************************************************************************  
/**Project 12 (+3points extra credit).  Prove a lower bound of ½(n)for the running time of any algorithm 

that computesTwoTo_n.algorithm that takes an integer n and returns the value 2^n.  You may use NO looping

statements; only recursion.  You may assume that n is positive.*/

int x;
	System.out.println("n = " + n);
	c++; 
	System.out.println("iteration #: " + c);
	if(n == 1)
		return 2;
	else{
		if(n % 2 == 0){
			System.out.println("call TwoTo_n (" + n/2 + ")");
			x = TwoTo_n(n/2, c); 
			System.out.println("return " +x*x);
			return (x*x);
		}
		else{
			System.out.println("call TwoTo_n (" + (n-1)/2 + ")");
			x = TwoTo_n((n-1)/2, c); 
			System.out.println("return " +x*x*2);
			return (x*x*2);
		}	
	}
} 

So, from the result from running many "n" in the divide and conquer algorithm of twoTo_n program, it takes log n times
to get the result. So, the lower bound of the algorithm is still Omega-(log n).  

**********************************************************************************************************  


