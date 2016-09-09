import java.util.*;
import java.lang.*;

public class tryAlgorithm8 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 
/*Project 1********************************************************
 public static void main(String[] args) {
   int n = 8; 
   int s = 6;  
   int []touch = new int [n+1];
	int []cost = new int [n+1];
	int [][]W = {{0, 1, 2, 3, 4, 5, 6, 7, 8},
					 {1, 0, 40, 999, 999, 999, 20, 999, 30},
					 {2, 10, 0, 15, 999, 66, 999, 90, 999},
					 {3, 12, 14, 0, 50, 999, 999, 999, 999},
					 {4, 999, 30, 5, 0, 999, 24, 25, 999},
					 {5, 999, 3, 999, 15, 0, 6, 999, 10},
					 {6, 17, 999, 999, 999, 999, 0, 999, 50},
					 {7, 999, 15, 999, 8, 999, 999, 0, 4},
					 {8, 999, 100, 999, 25, 999, 80, 999, 0}};

   
   dijkstra(n,s,W,touch,cost); 
	printTouch(n, touch);
	System.out.println();
	printCost(n, s, cost);
  
    }
    
public static void dijkstra(int n, int s, int [][] W, int [] touch, int [] cost){
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

public static void printTouch(int n, int []touch){
	for(int i = 1; i <= n; i++)
		System.out.print("{" + i + "," + touch[i] + "}");
}

public static void printCost(int n, int s, int []cost){
	for(int i = 1; i <= n; i++)
		System.out.println("cost from v" + s + " to v" + i + " = " + cost[i]);
}

end 1 ************************************************************/
/*Project 2********************************************************
public static void main(String[] args) {
   int s = 6;  //1
	int d = 8; //7
	int []touch = {0, 2, 4, 4, 6, 6, 6, 4, 1};
	//int[] touch = {0, 1, 7, 6, 1, 3, 4, 6};
  
   printPath(s, d, touch); 
  }
    
public static void printPath(int s, int d, int [] touch){
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
       
end 6 ************************************************************/

/**Project 6 ********************************************************
public static void main(String[] args) {
	
      printAll(3,7);
}

public static void printAllRec(int n, int i, int [] A, int m)  {
   
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
         }
            
      }
  }


   public static void printAll(int n, int m)  {
   
      int [] A = new int[n+1];
      printAllRec(n, 0, A, m);
   
   }
end 6 ************************************************************/

/**Project 2try ********************************************************
public static void main(String[]args){
      
         int []t={0,1,7,5,3,1,4,6};
      
         printPath(1,6,t);   
     }
      
      
  public static void printPath(int s, int d, int [] touch){
  int n= touch.length;  
  int [] temp = new int [n];
  int i = 0; 
  			
	temp[i++] = d;
  do{
  	d = touch[d];
  	temp[i++] = d;
	}while( s != d);
	
	for(int j = n-1; j>=0; j--)
		if(temp[j] != 0)
			System.out.print("v" + temp[j]+ ", ");
  
  }
  
end try2 ************************************************************/


//**Project try6 ********************************************************
public static void main(String[] args) {
	
      printAll(3,7);
}

public static void printAll(int n, int m)  {

	for(int i = 1; i <= m ;i++)
		for(int j = i+1; j <= m; j++)
			for(int k = j+1; k<=m; k++)
				System.out.println(i + "' " + j + ", "+ k ); 

}
//end try6 ************************************************************/

}//end class






















