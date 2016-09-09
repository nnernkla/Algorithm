
/** Algorithm7
    Niphaphan Nernklang
*/
**********************************************************************************************************\

/**Project 1 Give the denominations of three pretend coins (one must be a 1 cent coin, the other two must be
 between 2 cents and 100 cents) and an amount such that the greedy change algorithm does not yield the fewest
 number of coins.  How many does the greedy change algorithm use?  How many is optimal? Try to maximize the 
 difference in the number of coins between the greedy algorithm and the optimal way.  If you come up with the
 largest difference, +3 points extra.*/
 
 Answer: D = {0, 1, 49, 50}
 			n = 98
			k = 3
			
			greedy algorithm: 98-50, 48-1, 47-1, 46-1,...,1-1 = 1+48 = 49 coins 
			optimal : 98-49, 49-49  = 1+1 = 2 coins
			
			the different of coins = 47  
********************************************************************************************************** 
/**Project 2 Write the Greedy Change algorithm without using the divisionor modfunctions(/, %).It should 
print out the number of each type of coin.  For example, if this is called with n = 799 cents, k = 5 (5 types
of coins) and array D given here:  int[] D = {0, 1, 5, 10, 25, 100}(ignore cell 0 of D), the output would be:
	   To make change for 799 cents, you need:
      
      100 cent coins:  7
      25 cent coins:  3
      10 cent coins:  2
      5 cent coins:  0
      1 cent coins:  4
		
		     
*/
void GreedyChange(int n, int k, int [] D){
    int count = 0;
    int rem = n;
    int i , j; 
    
    for(i = k; i>= 1; i--){
      for(j = rem; j >= D[i]; j = j-D[i])
         count++; 
                  
    	System.out.println(D[i] + " cent coins: " + count);
   	count = 0;
    	rem = j;  
    }//end for-i
} 
********************************************************************************************************** 
/**Project 3 Rewrite the GreedyChangealgorithm from the previous problem using only 1 loop (you may now use
 mod and integer division).*/

public static void GreedyChange(int n, int k, int [] D){
    int count = 0;
    int rem = n;
      
    for(int i = k; i>= 1; i--){
      count = rem/D[i];
      rem = rem%D[i];                 
      System.out.println(D[i] + " cent coins: " + count);       
    }
}
 
**********************************************************************************************************  
/**Project 4 Trace through Prim's Algorithm (Problem 1 on the Prim Handout).  Give the resulting minimum 
spanning tree and its cost.  (My version of Prim's algorithm is on the last page of this file.)*/

Answer: 				 1   2   3   4    5    6 
						--------------------------
			nearest:  1   1   1   1    1    1  ----> vnear = v2, cost = 10
			distance: 0   10  15  inf  inf  12
			
			nearest:  1   1   1   1    2    2  ----> vnear = v6, cost = 9
			distance: 0   0  15  inf   13   9
			
			nearest:  1   1   1   6    6    2  ----> vnear = v5, cost = 8
			distance: 0   0  15   10   8    0
			
			nearest:  1   1   5   6    6    2  ----> vnear = v3, cost = 8
			distance: 0   0   8   10   0    0
			
			nearest:  1   1   5   6    6    2  ----> vnear = v4, cost = 10
			distance: 0   0   0   10   0    0
			
			nearest:  1   1   5   6    6    2  ----> last step
			distance: 0   0   0   0    0    0
			
			So, minimum spanning tree : {{v2,v1}, {v3, v5}, {v4, v6}, {v5, v6}, {v6, v2}}
			    the cost of the minimum tree : 45


**********************************************************************************************************
 
/**Project 5 Trace through Prim's Algorithm (Problem 2 on the Prim Handout).  Give the resulting minimum 
spanning tree and its cost.  */

Answer: 				 1   2   3   4    5    6 
						--------------------------
			nearest:  1   1   1   1    1    1  ----> vnear = v4, cost = 15
			distance: 0   20  40  15   inf  70
			
			nearest:  1   1   1   1    4    4  ----> vnear = v2, cost = 20
			distance: 0   20  40  0    40   60
			
			nearest:  1   1   2   1    4    4  ----> vnear = v3, cost = 30
			distance: 0   0   30  0    40   60
			
			nearest:  1   1   2   1    3    4  ----> vnear = v5, cost = 20
			distance: 0   0   0   0    20   60
			
			nearest:  1   1   2   1    3    5  ----> vnear = v6, cost = 50
			distance: 0   0   0   0    0    50
			
			nearest:  1   1   2   1    3    5  ----> last step
			distance: 0   0   0   0    0    0
			
			So, minimum spanning tree : {{v2,v1}, {v3, v2}, {v4, v1}, {v5, v3}, {v6, v5}}
			    the cost of the minimum tree : 135

**********************************************************************************************************
/**Project 6 (From Prim Handout)  Write an algorithm that takes a nearest array (indexed 1 to n) that has 
been passed back by Prim’s algorithm, and prints the edges of the minimum spanning tree contained in nearest.  
A typical output might look like this:  {(1, 3), (2, 3), (3, 5), (4, 5)}
*/
void printTree(int n, int [] nearest)  {
System.out.print("Edges of this spanning tree: {");
    for(int i = 1; i<= n; i++){ 
      if(i != nearest[i])                
      	System.out.print(" (" + i + "," + nearest[i] + "),");        
    }
	 System.out.print("}");
}
**********************************************************************************************************
/****Project 7 (From Prim Handout)  Rewrite (modify) Prim’s algorithm so that it returns an integer instead of void, 
and that integer should be the cost of the minimum spanning tree, and -1 if there is no spanning tree 
(how will you detect in your modified algorithm that there is no spanning tree?).*/
int Prim(int n, float [][]W, int []nearest) {
		int i, j; 
		int vn = -1;
		int sum = 0;
		float min;
		float []dist = new float[n+1];
		
		for(i = 1; i<=n; i++){
			nearest[i] = 1; 
			dist[i] = W[1][i]; 
		}
		
		for(j = 1; j<= n-1; j++){
			min = inf; 
			for(i = 1; i <= n; i++){
				if(dist[i] < min && dist[i] != 0){
					min = dist[i];
					vn = i;
				}//end if
			}//end for-i
			
			if(min == inf)
				return -1;
			else{
				dist[vn] = 0;
				sum += min;
			}	
			
			for(i = 1; i <= n; i++)
				if(W[vn][i] < dist[i]){
					dist[i] = W[vn][i];
					nearest[i] = vn;
				}		
		}//end for-j
						
	return sum;				      
}
      
**********************************************************************************************************
/**Project 8 Write an algorithm that takes an integer k and an array of coin denominations D, and returns
 true if the greedy algorithm will always produce an optimal solution for this coin set for any amount, 
 and false otherwise.  For example, if k =6 and D = {0, 1, 5, 10, 25, 50, 100}, you would return true
 because this always produces an optimal solution.  For k = 4 and D = {0, 1, 5, 10, 12} you would return 
 false because the greedy algorithm does not always produce an optimal solution for this coin set.
*/
booleandoesGreedyWork(int k, int[] D)  {           
    
      for(int i = 2; i <= k-1; i++)
			if((D[i+1] % D[2] != 0) || (D[i+1] < 2*D[i]))
				return false;
				
		return true;				
}
	 
**********************************************************************************************************  


  

 
	





















































































