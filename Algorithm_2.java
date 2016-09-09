
/** Analysis of Algorithm2
    Niphaphan Nernklang
*/
**********************************************************************************************************

/**Project 1 Write a recursive algorithm that determines if between indices low and high, array A is already

sorted (in increasing order—you may assume there are no repeated values in A). In order to receive 

any credit, your algorithm must not have any looping statements (it must be recursive) and your 

algorithm must run in O(n) time, where n is the number of elements between indices low and high.*/

boolean alreadySorted(int [] A, int low, int high) {
    if(low == high)
       return true;
    else if(A[low] < A[low+1])
         return alreadySorted(A, low+1, high);
    else 
      return false;  
}
**********************************************************************************************************
 
/**Project2 2 Write an algorithm that takes integer arrays A and B, each of which is sorted, and merges them 

into array C, so that all values in A and B are now together and sorted in C. You may assume that 

C.length = A.length + B.length. Your algorithm must run in time O(n), where n = the 

length of array C, in order to receive any credit.*/

void merge(int [] A, int [] B, int [] C) {
      int i = 0;
      int j = 0;
      int k = 0;
   
      while (i < A.length && j < B.length){
         if(A[i] < B[j])
           C[k++]= A[i++]; 
         else
           C[k++] = B[j++];          
      }
      
      while(i < A.length)
         C[k++] = A[i++];
         
      while(j < B.length)
         C[k++] = B[j++];
     
}
**********************************************************************************************************
/**Project 3 Write a divide and conquer algorithm that runs in logarithmic time that does the following:

It takes a sorted array A, and two indices low and high, as well as a target element x. It does the 

minimum number of comparisons possible to determine if x is in the array somewhere between locations 

low and high. If it is, it returns the index where x is found, otherwise it returns –1. (It must be divide and 

conquer (recursion)no looping statements!) What is the running time?*/

int loc(int [] A, int low, int high, int x) {
   int mid = (low + high)/2;
   
   if(low > high)
      return -1; 
   else{
      if(A[mid] > x)
         return loc(A, low, mid-1, x);
      else if(A[mid] < x)
         return loc(A, mid+1, high, x);
      else
          return mid; 
   }
}

running time = theta-O(log2 n); 
**********************************************************************************************************
/**Project 4 Suppose that, in Algorithm 2.1 (line 4), the splitting function is changed to mid = low;.

Explain the new search strategy. Analyze the performance of this strategy and show the results

   >>> Alogithm 2.1: Determine whether x is in the sorted array S of size n.

Inputs: positive integer n, sorted (nondecreasing order) array of keys S indexed from 1 to n, a key x.

Outputs: location, the location of x in S (0 if x is not in S).

      int location(index low, index high)
      {
         index mid;
         
         if(low>high)
            return 0;
         else{
            mid = (low+high)/2;
            if(x == S[mid])
               return mid;
            else if(x < S[mid])
               return location(low, mid-1);
            else
               return location(mid+1, high);
         }
      }
 */ 
 As algorithm 2.1 is a divide and conquer algorithm, its running time is theta-O(log n) because it is cut in half
 in each iteration. However, if the splitting function is changed to mid = low, it compares every elements in
 array S with x (linear search). So, the updated algorithm becomes less efficient than the previous one-- the new running time is
 theta-O(n). 
 
 example S = {1, 5, 7, 9, 18, 22, 30};
         x = 20
         
        output for the splitting function mid = (low+high)/2;
         mid : 3 low: 1 high: 6
         mid : 5 low: 4 high: 6
         mid : 4 low: 4 high: 4
         0
        
         output for the splitting function mid = low;  
         
         mid : 1 low: 1 high: 6
         mid : 2 low: 2 high: 6
         mid : 3 low: 3 high: 6
         mid : 4 low: 4 high: 6
         mid : 5 low: 5 high: 6
         0
         
to find x =20, divide and conquer algorithm takes 4 iterations to return 0. Linear search algorithm,however, takes 6 (n)iterations to return 0. 
         
**********************************************************************************************************
/**Project 5 (a) Write an algorithm that takes two integers, a and b, and computes the product of the

integers from a to b. If a > b, return the value 1. Do this without recursion. 

(b) Write an algorithm for the above function, but this time use recursion—no looping statemnets!

*/
a) non- recursion 
int prodBetween(int a, int b) {
	int pro = 1; 
	while (!(a > b)){
		pro = pro * a++; 
	}
return pro; 
}

b) recursive program
int prodBetween(int a, int b) { 
	if (a > b)
		return 1; 
	else
		return (a * prodBetween(a+1, b));
}

**********************************************************************************************************  

/**Project 6 (a) Write an algorithm that takes an array, indices low and high, and a value limit. Return true 

if none of values in the array between indices low and high is greater than limit (false otherwise). Do 

this without recursion

(b) Write an algorithm for the above function, but this time use recursion—no looping statemnets!

*/
a)non- recursion 
 boolean noneOverLimit(int [] A, int low, int high, int limit){
   for(int i = low; i <= high; i++)
         if(A[i] > limit)
            return false;     
      return true;
 }
 
b)recursive program
   boolean noneOverLimit(int [] A, int low, int high, int limit){
   if (low > high)
         return true;
      else if (A[low] < limit)
         return noneOverLimit(A, low+1, high, limit);
      else
         return false;
 }

**********************************************************************************************************  
/**Project 7 Using O (theta) notation, what is the running time of the function meg (in terms of n)?

 boolean meg(int [] A, int n) {

   int i, j;

   for (i = 0; i < n; i++)
      for (j = i + 1; j < n; j++)
         if (A[i] == A[j])
            return false;
         else
            return true;

   return true;

 }*/
 
 Running time is T(n) = [((n-1)(n-2))/2] + n . So, it is theta-O(n^2).
**********************************************************************************************************  
/**Project 8 Using O (theta) notation, what is the running time of chris?

   int chris(int n) {

      int i, j, k, ans = 0;
      for (i = n; i < n + 100; i++)
         for (j = 2; j <= n; j = j + j)
            ans = ans + i*j;
      return ans;

 }
*/
Running time is T(n) = 100*log2(n) or we can assume that it is in theta-O(log2 n) 
**********************************************************************************************************  
/**Project 9 (a) Using O (theta) notation, what is the best-case running time of stewie?

(b) Using O (theta) notation, what is the worst-case running time of stewie?

   int stewie(int [] A, int n) {

      int i, j, s = 0;
      
      for (i = 0; i < n; i++)
         s = s + A[i];

      for (i = 0; i < n; i++)
         for (j = i+1; j < n; j++)
            if (A[i] == A[j])
               return -s;

      return s;
 }
*/
a) The best-case running time of stewie is the program runs n times of the first loop, then run just 1 time
of the nested loop. So, running time of the best case is theta-O(n);  

b) The worst-case running time os this algorithm is running every loops with n elements. So, T(n) = n + n*(n-1), 
theta-O(n^2). 
**********************************************************************************************************  
/**Project 10 (a) If n = 5 and array A = {8, 7, 22, 16, 9}, what is the output of brian?

(b) If n = 5 and array A = {8, 7, 22, 16, 9}, what is the return value of brian?

(c) If n = 100, and array A had length 100, what would be the return value of brian?

(d) Using O (theta) notation, what is the running time of the function brian (in terms of n)?

    int brian(int [] A, int n) {

      int count = 0;

      for (int i = 0; i < n; i++)
         for (int j = i+1; j < n; j++)
            for (int k = j+1; k < n; k++) {
               System.out.println(A[i] + ", " + A[j] + ", " + A[k]);
               count++;
            }
 return count; 

 }*/
 a) output:
   8, 7, 22
   8, 7, 16
   8, 7, 9
   8, 22, 16
   8, 22, 9
   8, 16, 9
   7, 22, 16
   7, 22, 9
   7, 16, 9
   22, 16, 9
   
 b) count: 10
 c) count: 161700
 d) theta-O(n^3)
**********************************************************************************************************  
/**Project 11 Page 94, Exercise # 40. (Read it first, then here's more explanation):

Each row and each column in this array is sorted (like the question on the last quiz). You are looking to 

find the location (both row and column) of some value x—if x is not in the 2D array, then return the set 

both row and col to –1. If you check every cell, this will take time theta-O(n^n), where n is the number of 

rows and m is the number of columns. 

Write an algorithm that finds the location of x (or determines it is not there) in time theta-O(n log2 m). 

Note that variables row and col are passed by reference

   >>> 40. Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array).

This table is sorted along the rows and columns—that is,
      Table[i][j] <= Table[i][j+1]
      Table[i][j] < Table[i+1][j]
*/

void twoD_BinSearch(int n, int m, int [][]B, int x, int & row, int & col) {
	int low = col; 
	int high = m-1; 
	int findRow = -1;
	int findCol = -1;
	
	while(row < n){
		int mid = (low + high)/2;
		if(low > high){
			row++;
			low = col;
			high = m-1;
		} 
		else{
			if(x == B[row][mid]){
				System.out.println("(" + row + "," + mid + "), ");
				row++;
				low = col; 
				high = m-1;
				findRow = row;
				findCol = mid;
			}//end if
			else if(x > B[row][mid])
				low = mid + 1;
			else if(x < B[row][mid])
				high = mid - 1;
			else{
				row++;
				low = col; 
				high = m-1;
			}
		}
	} 
	if(findRow == -1 && findCol == -1)
		System.out.println("(" + findRow + "," + findCol + "), ");
}
}
**********************************************************************************************************  


