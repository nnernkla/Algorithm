import java.util.*;

public class tryAlgorithm2 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 
/*Project 1********************************************************
 public static void main(String[] args) {
        int [] A = {2, 5, 7, 9, 12, 18};
        
        System.out.println(alreadySorted(A, 0, A.length-1));
   }

public static boolean alreadySorted(int [] A, int low, int high){ 
   
    if(low == high)
       return true;
    else if(A[low] < A[low+1])
         return alreadySorted(A, low+1, high);
    else 
      return false;  
    }
end 1 ************************************************************/
/*Project 2********************************************************

   public static void main(String[] args) {
        int [] A = {1, 2, 7, 8};
        int [] B = {3, 4, 5, 6};
        int [] C = new int [8];
        
        merge(A, B, C);

        //System.out.println(a[0]);
        //System.out.println(a[1]);
   }
   public static void merge(int [] A, int [] B, int [] C) {
      int i = 0;
      int j = 0;
      int k = 0;
   
      while (i < A.length && j < B.length){
         if(A[i] < B[j])
           C[k++]= A[i++]; 
         else
           C[k++] = B[j++];          
      }//end while
      
      while(i < A.length)
         C[k++] = A[i++];
         
      while(j < B.length)
         C[k++] = B[j++];
         
      for(int m = 0; m < C.length; m++)
         System.out.print(C[m] + ", ");
      
}
end 2 ************************************************************/
/*Project 3********************************************************
public static void main(String[] args) {
        int [] A = {1, 5, 7, 9, 18, 22, 35, 66, 70};
        
        System.out.println(loc(A, 0, A.length-1, 9));
}

public static int loc(int [] A, int low, int high, int x) {
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
end 3 ************************************************************/
/*Project 4********************************************************
public static void main(String[] args) {
        int [] A = {1, 5, 7, 9};
        
        System.out.println(location(1, 6));
}

public static int location(int low, int high){
         int x = 6;
         int [] S = {1, 5, 7, 9, 18, 22, 30, 40};
         int mid;
         
         if(low>high)
            return 0;
         else{
            mid = (low+high)/2;
            System.out.println("mid : " + mid + " low: " + low + " high: " + high);
            if(x == S[mid])
               return mid;
            else if(x < S[mid])
               return location(low, mid-1);
            else
               return location(mid+1, high);
         }
}
/*end 4 ************************************************************/
/*Project 5********************************************************
public static void main(String[] args) {
        int a = 1;
		  int b = 4; 
        System.out.println("total product : " + prodBetween(a,b));
}
public static int prodBetween(int a, int b) { 
	/** non-recursive ****
	int pro = 1; 
	while (!(a > b)){
		pro = pro * a++;
		//System.out.println("a = " + a + " pro = " + pro); 
	}
	*/
   /** recrusive 
	if (a > b)
		return 1; 
	else
		return (a * prodBetween(a+1, b));
}
/**end 5 ************************************************************/
/*Project 6********************************************************
public static void main(String[] args) {
        
        int [] A = {1, 5, 7, 9, 18, 22, 30, 40, 50};

        System.out.println("result : " + noneOverLimit(A, 0, A.length-1, 105));
}
public static boolean noneOverLimit(int [] A, int low, int high, int limit){
      /** non-recursion
      for(int i = low; i <= high; i++)
         if(A[i] > limit)
            return false;     
      return true;
      */
      /**
      if (low > high)
         return true;
      else if (A[low] < limit)
         return noneOverLimit(A, low+1, high, limit);
      else
         return false;
 }
/**end 6 ************************************************************/
/*Project 8********************************************************
public static void main(String[] args) {
        
         int i, j, k = 0, ans = 0, n =32;
         for (i = n; i < n + 100; i++)
            for (j = 2; j <= n; j = j + j){
               ans = ans + i*j;
               k++;
               System.out.println("ans: " + ans + " i: "+ i + " j: " + j + " k: " + k);}
}
/**end 8 ************************************************************/
/*Project 10********************************************************
public static void main(String[] args){
   
   int count = 0;
   int [] A = {8, 7, 22, 16}; /*{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
               21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
               41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
               61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
               81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
   int n = A.length;

      for (int i = 0; i < n; i++){
         System.out.println("i= " + i + ", ");
         count++;
         for (int j = i+1; j < n; j++){
            System.out.println("j= " + j + ", ");
            count++;
            for (int k = j+1; k < n; k++) {
               System.out.println("k=" + k); //(A[i] + ", " + A[j] + ", " + A[k]);
               count++;
            }
           }
           //System.out.println("*********");
          }
 System.out.println("count: " + count);

}
end 8 ************************************************************/
public static void main(String[] args) {
        int n = 3;
		  int m = 6;
		  int x = 102; 
		  int [][] B = {{1, 5, 7, 9, 10, 12},
		  					 {3, 8, 12, 14, 19, 22},
							 {6, 11, 15, 16, 21, 28}}; 				
        
		 twoD_BinSearch(n, m, B, x, 0, 0);  
}
public static void twoD_BinSearch(int n, int m, int [][]B, int x, int row, int col) {
	int low = col; 
	int high = m-1; 
	int findRow = -1;
	int findCol = -1;
	
	while(row < n){
		int mid = (low + high)/2;
		//System.out.println("mid: "+ mid+ "row: " + row);
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
}//end class