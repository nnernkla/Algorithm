import java.util.*;
import java.lang.*;

public class tryAlgorithm7{
/*Project 2********************************************************
 public static void main(String[] args) {
   int n = 799; 
   int k = 5;  
   int []D = {0, 1, 5, 10, 25, 100};
   
   GreedyChange(n,k,D); 
  
    }
    
public static void GreedyChange(int n, int k, int [] D){
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
end 2 ************************************************************/
//**Project 3 ********************************************************
public static void main(String[] args) {
   //int n = 799; 
  // int k = 5;  
   //int []D = {0, 1, 5, 10, 25, 100};
	
	int n = 98; 
   int k = 3;  
   int []D = {0, 1, 49, 50};

   
   GreedyChange(n,k,D); 
  
    }
    
public static void GreedyChange(int n, int k, int [] D){
    int count = 0;
    int rem = n;  
    
    for(int i = k; i>= 1; i--){
      count = rem/D[i];
      rem = rem%D[i];                 
      System.out.println(D[i] + " cent coins: " + count);       
    }
}
//end 3 ************************************************************/
/*Project 6********************************************************
public static void main(String[] args) {
   int n = 6;  
   //int []nearest = {0, 1, 1, 5, 6, 6, 2};
	int []nearest = {0, 6, 4, 2, 4, 4, 4};

   
   printTree(n, nearest); 
  
    }
    
public static void printTree(int n, int [] nearest){
	
	 System.out.print("Edges of this spanning tree: {");
    for(int i = 1; i<= n; i++){ 
      if(i != nearest[i])                
      	System.out.print(" (" + i + "," + nearest[i] + "),");        
    }
	 System.out.print("}");
}         
end 6 ************************************************************/
/*Project 7********************************************************
public static void main(String[] args) {
        
		  int n = 6;
		  float [][]W = {{ 0, 1, 2, 3, 4, 5},
		  					{ 1, 0, 12, 8, 999, 999},
							{ 2, 12, 0, 10, 999, 999},
							{ 3, 8, 10, 0, 999, 999},
							{ 4, 999, 999, 999, 0, 15},
							{ 5, 999, 999, 999, 15, 0}};
			float [][]W = {{ 0, 1, 2, 3, 4, 5, 6},
		  					{ 1, 0, 10, 15, 999, 999, 12},
							{ 2, 10, 0, 20, 999, 13, 9},
							{ 3, 15, 20, 0, 18, 8, 999},
							{ 4, 999, 999, 18, 0, 999, 10},
							{ 5, 999, 13, 8, 999, 0, 8},
							{ 6, 12, 9, 999, 10, 8, 0}};
			float [][]W = {{ 0, 1, 2, 3, 4, 5, 6},
		  					{ 1, 0, 20, 40, 15, 999, 70},
							{ 2, 20, 0, 30, 60, 999, 999},
							{ 3, 40, 30, 0, 90, 20, 999},
							{ 4, 15, 60, 90, 0, 40, 60},
							{ 5, 999, 999, 20, 40, 0, 50},
							{ 6, 70, 999, 999, 60, 50, 0}};
		  int []nearest = new int [n+1];
		  
		  int answer = Prim(n,W,nearest);
        
		  System.out.println("The result is: " + answer);
   }
   public static int Prim(int n, float [][]W, int []nearest) {
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
			min = 999; 
			for(i = 1; i <= n; i++){
				if(dist[i] < min && dist[i] != 0){
					min = dist[i];
					vn = i;
				}//end if
			}
			
			if(min == 999)
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
end 7 ************************************************************/
/*Project 8********************************************************
public static void main(String[] args) {
        //int [] D = {0, 1, 2, 6, 12, 30};
		  //int [] D = {0, 1, 5, 10, 12, 60};
		  int [] D = {0, 1, 5, 25, 125, 300};
		  int k = 5; 
        System.out.println("Is this array of denominations is always give optimal solution? : "+ doesGreedyWork(k,D));
        
}
public static boolean doesGreedyWork(int k, int [] D) {            
    
      for(int i = 2; i < k; i++)
			if((D[i+1] % D[2] != 0) || (D[i+1] < 2*D[i]))
				return false;
				
		return true;
				
}         
    
          	
end 8 ************************************************************/

}//end class






















