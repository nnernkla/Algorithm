
/** Algorithm5
    Niphaphan Nernklang
*/
**********************************************************************************************************

/**Project 1 Complete the "5-Vertex" tab in the Excel document "Floyd_Exercises."This is the example we started
 in class with 5 vertices.  We actually traced through D3 and P3, so you have the answers up until those.  
 Show the results of D2, P2, D3, P3, and then continue tracing trough D5 and P5.*/
 
 In excel sheet
********************************************************************************************************** 
/**Project 2 Trace through iteration # 4 in the "7-Vertex" tab in the Excel document "Floyd_Excercises".  
You are given the tracing through the first three iterations of Floyd's algorithm.  Trace through the 4
thiteration—give D4 andP4.  (You may trace further if you wish for extra practice, but this is not required
for this homework.)*/
 
In excel sheet
********************************************************************************************************** 
/**Project 3 Fill in the bolded boxes in the "Boxes To Complete" tab of the Excel document "Floyd_Exercises".
You are tracing through the 5thiteration of Floyd's algorithm for some 9-vertex graph.  You only need to 
give the values in the bolded boxes.*/
 
In excel sheet
**********************************************************************************************************  
/**Project 4 Write the java code for Floyd's algorithm:*/
void Floyd(int n, int [][] W, int [][] D, int [][] P) {
   int i, j, k;
   int temp;  
   
   for(i = 1; i <= n; i++)
      for(j = 1; j <= n; j++){
         D[i][j] = W[i][j];
         P[i][j] = 0;
      }
   
   for(k = 1; k <= n; k++)
      for( i = 1; i<=n; i++)
         for(j = 1; j<=n; j++){
            temp = D[i][k]+D[k][j]; 
            if(temp < D[i][j]){
               D[i][j] = temp;
               P[i][j] = k; 
            }
			}
} 
**********************************************************************************************************
 
/**Project 5 Write the Print Path algorithm, which takes a start index s, a destination index d, and the 
array P passed back from Floyd's algorithm, and then prints the list of intermediate vertices on a 
shortest path from vertex s to vertex d.*/

void PrintPath(int s, int d, int [][] P)  {
	 if (P[s][d] != 0)  {               
         int m = P[s][d];               
         printPath(s, m, P);               
         System.out.print("v_" + m +"  ");               
         printPath(m, d, P);
      } 
} 
**********************************************************************************************************
/**Project 6 The following path matrix P is passed back to you from floyd’s algorithm. Include the endpoints
 in your path.  The path must be entirely correct to get credit. 
 
      P |v1|v2|v3|v4|v5|v6|v7|v8|v9|
      v1| 0| 7| 7| 0| 7| 7| 0| 0| 7|
      v2| 0| 0| 7| 0| 7| 9| 0| 1| 0|
      v3| 9| 0| 0| 0| 7| 0| 2| 9| 6|
      v4| 9| 8| 8| 0| 8| 8| 8| 0| 8|
      v5| 9| 3| 0| 0| 0| 3| 3| 9| 6|
      v6| 9| 9| 9| 0| 9| 0| 9| 9| 0|
      v7| 9| 5| 5| 0| 0| 5| 0| 9| 6|
      v8| 9| 7| 7| 0| 7| 7| 0| 0| 7|
      v9| 0| 7| 7| 0| 7| 0| 1| 1| 0|
*/

a)  Give a path starting from  v8 ending at  v9 of minimum cost.
    answer = v_8  v_7  v_5  v_3  v_6  v_9 
    
b)  Give a path starting from  v6 ending at  v3 of minimum cost.
    answer = v_6  v_9  v_1  v_7  v_5  v_3
**********************************************************************************************************
/**Project 7 Use recursion ONLY—any looping statements (for, while, do, etc) means 0 credit.
Given the final path matrix P (after running Floyd's algorithm), the matrix W with the original weights of
the direct edges in the graph, a starting vertex s, and a destination vertex d, compute the lowest cost of
a path from vertex s to vertex d.*/

int minCostRec(int s, int d, int [][] P, int [][] W) {;           
      int m = P[s][d]; 
      if (m == 0)
			return W[s][d];
		else
	      return minCostRec(s, m, P, W)+ minCostRec(m, d, P, W);           
}        
**********************************************************************************************************
/**Project 8 An array P is valid if there exists a graph (in these cases on three vertices) for which Floyd's
algorithm would output P. Otherwise, it is invalid. Which of the following arrays P are valid, and
which are invalid?

a) P|1|2|3|    b) P|1|2|3|    c) P|1|2|3|    d) P|1|2|3|
    -------        -------        -------        -------
   1|0 3 0|       1|0 0 2|       1|0 3 2|       1|0 0 2|
   2|1 0 2|       2|3 0 0|       2|0 0 0|       2|0 0 0|
   3|2 0 0|       3|0 0 0|       3|0 1 0|       3|0 0 2|

*/
 answer a) invalid, because it stucks at path v2-->v1
 		  b) valid 
		  c) invalid, because it is a loop between v2 and v3
		  d) invalid, because path v3-->v3 should be zero. 
**********************************************************************************************************  

/**Project 9 Write the boolean method "isolatedVertex" that takes as input an integer n = number of
vertices and the two dimensional array W with the edge weights. If there is a vertex that has
no edges going into it or coming out of it, the index of such a vertex is returned. Otherwise, return –1.
You may use the symbol "infinity" in your code and that symbol may appear in W
*/
 int isolatedVertex(int n, int [][] W) {
 	boolean check = true; 
	int answer;
	for(int i = 1; i <= n; i++){
		for(int j =1; j <= n; j++){
			if((W[i][j] != inf || W[j][i] != inf)&&(i != j))
				check = false;
		}//end inner for-loop
		if(check == true)
			return i;
		else
			check = true; 
	}//end outer for-loop
	return  -1;	
 }

**********************************************************************************************************  
/**Project 10 Write the boolean method "allReachableFromEverywhere" that takes as input an integer n =
number of vertices and the two dimensional array W with the edge weights. The method returns true if
there exists some path from every vertex to every other vertex, and false otherwise. You may call other
methods, but if they are methods not on this assignment, you must write them as well. You may use the
symbol "infinity" in your code and that symbol may appear in W.
*/
   boolean allReachableFromEverywhere(int n, int [][] W){
		  int [][] D = new int[n+1][n+1];
  		  int [][] P = new int[n+1][n+1];
		  boolean check = true;
		  
		  Floyd(n, W, D, P);
		  
		  for(int i = 1; i <= n; i++)
		  		for(int j = 1; j <= n; j++)
					if(D[i][j] == inf)
						return false;
			
		return true;
   }
**********************************************************************************************************  
 

 
	





















































































