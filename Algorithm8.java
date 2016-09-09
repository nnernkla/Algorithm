
/** ALgorithm8
    Niphaphan Nernklang
*/
**********************************************************************************************************\

/**Project 1 Rewrite Dijkstra's algorithm so that you pass in an additional array cost, and when the call
 is over, cost[i] will contain the minimum cost of an optimal path from the source to vertex i. Use the 
 following header: (s = the source vetex)*/
 
 void dijkstra(int n, int s, int [][] W, int [] touch, int [] cost) {
	 int i, min,j;
	 int vnear = -1;
    int []length = new int[n+1]; 
    
    for(i = 1; i <= n; i++){
   		touch[i] = s;
			length[i] = W[s][i];
			cost[i] = 0;
    }
	 
	 for( j = 1; j <= n-1; j++){
	 	min = 999;
		for( i = 1; i <= n; i++){
			if(length[i] < min && length[i] > 0){
				min = length[i];
				vnear = i; 
			}//end if
		}//end i-loop
		cost[vnear] = min;
		
		for(i = 1; i<= n; i++){
			if(length[vnear] + W[vnear][i] < length[i]){
				length[i] = length[vnear] + W[vnear][i];
				touch[i] = vnear;
			}//end if
		}//end i-loop
		
		length[vnear] = 0;
	
	 }//end j-loop

 	
 }  
********************************************************************************************************** 
/**Project 2 Rewrite the printPath algorithm so that it uses no recursion:*/
void printPath(int s, int d, int [] touch){
	int target = s; 
	int storeD = d; 
	int m = -1; 
	
   System.out.print("v" + s + " ");
	while(target != d){
		m = touch[d];
		if(target == m){
			System.out.print("v" + d + " "); 
			target = d;
			d = storeD; 
		}
		else{ 
			d = m;
		}
	}//end while  
}
or

public static void printPath(int s, int d, int [] touch){
  int n= touch.length;  
  int [] temp = new int [n];
  int m = d;
  
  do
  {
  		d = m;
		temp[--n] = d;
  		m = touch[d];	
	}while(m != d);
	
	for(int i = 0; i <= touch.length-1; i++)
		if(temp[i] != 0)
			System.out.print("v" + temp[i]+ ", "); 
  
  }


ex. [] touch = {0, 2, 4, 4, 6, 6, 6, 4, 1};
	printPath returns: v6 v4 v2 v1 v8 
********************************************************************************************************** 
/**Project 3 Create a touch array with n = 7, and source = 1, such that at least one of the shortest paths
 from the source to another vertex includes at least 4 edges of the graph. Give all the shortest paths from
 v1 to every other vertex.*/
 
 Answer: touch = {0, 1, 7, 6, 1, 3, 4, 6} //source = v1
 			v1 to v1 = v1
			v1 to v2 = v1 v4 v6 v7 v2
			v1 to v3 = v1 v4 v6 v3
			v1 to v4 = v1 v4
			v1 to v5 = v1 v4 v6 v3 v5
			v1 to v6 = v1 v4 v6
			v1 to v7 = v1 v4 v6 v7
 
**********************************************************************************************************  
/**Project 4 Create a 2D array W of weights, with n = 7, such that if you pass this W to Dijkstra's algorithm,
 the resulting touch array will be your touch array from Problem 3. */
Answer: [][]W = {{0, 999, 999, 10, 999, 999, 999},
					  {999, 0, 999, 999, 999, 999, 999},
					  {999, 999, 0, 999, 15, 999, 999},
					  {999, 999, 999, 0, 999, 12, 56},
					  {999, 999, 999, 55, 0, 76, 999},
					  {80, 999, 3, 999, 999, 0, 8},
					  {999, 20, 999, 999, 999, 999, 0}};// Assume array starts from index(1,1)


**********************************************************************************************************
 
/**Project 5 Trace through Dijkstra's algorithm on the 8-vertex graph given in the first tab of the Excel
 file Assignment_8.xls. Use v6 as the source.  */

= answer in excel sheet
**********************************************************************************************************
/**Project 6 Modify the code in ArbyLoopsFromClass.java so that the methods printAll, and printAllRec take
 an additional integer parameter m: 
 
 What printAll should do now is, assuming that m >= n, it should print out all n-element subsets of the set
 {1, 2, 3, ..., m}. For example a call to printAll(3, 7) would produce the following output: 
 
 123 145 237 347 124 146 245 356 
 125 147 246 357 126 156 247 367 
 127 157 256 456 134 167 257 457 
 135 234 267 467 136 235 345 567 
 137 236 346
 */     
 public static void printAll(int n, int m)  {
 	 int [] A = new int[n+1];
      printAllRec(n, 0, A, m);
 }
 public static void printAllRec(int n, int i, int [] A, int m) {
 	 if (i == n) {
         for (int j = 1; j <= n; j++)
            System.out.print(A[j] + "  ");
         System.out.println();
      }
      else
      {
         int k;
			int j = A[i];
         for (k = j+1; k <= m; k++)  {
         
            A[i+1] = k;
            printAllRec(n, i+1, A, m);
         }//end-for            
      }//end else
 }

**********************************************************************************************************
/****Project 7 Using the same (backtracking) technique that I showed at the end of class, find the first 
solution to the 5-queens and 6-queens problem. I have given you some blank 5 by 5 and 6 by 6 chess boards 
in the second tab of the Excel file: Assignment_8.xls.*/

Answer: see in excel sheet			      
**********************************************************************************************************
 


  

 
	

























































































