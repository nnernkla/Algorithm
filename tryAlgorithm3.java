import java.util.*;
import java.lang.*;

public class tryAlgorithm3 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 
/*Project 1********************************************************
 public static void main(String[] args) {
 
		  double left, right;
		  int n = 0; 
		  do 
		  {
		  		n++;
		  		left = (6 * Math.pow(n,2.81))-(6 * Math.pow(n,2));
				//System.out.println("left = " + left);
		  		right = Math.pow(n,3)- Math.pow(n,2);
				//System.out.println("right = " + right);
		  }while(left >= right);
		  
        System.out.println("n = " + n);
  
    }
end 1 ************************************************************/
/**Project 2 & 3a********************************************************

   public static void main(String[] args) {
      //int [] A = { 15, 22, 13, 27, 10, 20, 25};
      int [] A = { 5, 1, 3, 6, 2, 7, 4};
      //System.out.print(partition(A, 0, 6));
      quickSort(A, 0, A.length-1);
      for (int i = 0; i < A.length; i++)
         System.out.print(A[i] + ", ");
        
   }
   public static int partition(int[] A, int low, int high)  { 
 
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
           // pivotPoint = p; 
         }
      }
   }
         
   return pivotPoint;    
}

public static void quickSort(int[] A, int low, int high)  {
   int p; 
   
   if(low < high){
      p = partition(A, low, high); 
      quickSort(A, low, p-1);
      quickSort(A, p+1, high);
   }
   
}
end 2 ************************************************************/
/*Project 3********************************************************
 public static void main(String[] args) {
        //int [] A = { 5, 1, 3, 6, 2, 7, 4};
		  int [] A = { 15, 22, 13, 27, 10, 20, 25};
      mergeSort(A, 0, 6);
      for (int i = 0; i < A.length; i++)
         System.out.print(A[i] + ", ");
   }
   public static void mergeSort(int[] A, int low, int high)  {
     int mid = (low + high)/2;
      
		if(low < high){
        mergeSort(A, low, mid);
        mergeSort(A, mid+ 1, high); 
        merge(A, low, mid, high); 
      }
   }

   public static void merge(int [] A, int low, int mid, int high) {
      int i = low;
      int j = mid+1;
      int k = low;
      int [] B = new int [high+1];
  
      while (i <= mid && j <= high){
         if(A[i] < A[j])
           B[k++]= A[i++]; 
         else
           B[k++] = A[j++];          
      }//end while
      
     while(i <= mid)
         B[k++] = A[i++];
         
      while(j <= high)
         B[k++] = A[j++];
         
      for(int m = low; m <= high; m++)
         A[m] = B[m];
      
}
end 3 ************************************************************/
/*Project 4********************************************************
public static void main(String[] args) {
        int [] A = {7, 3, 8, 5, 2, 0, 1, 0, 8, 9, 7, 6, 2, 4};
		  int [] B = {5, 2, 7, 9, 6, 5, 3, 0, 8, 5, 1, 8, 9, 2};
		  int [] D = new int [A.length+1];
        
        D = (LargeIntSum(A, B, A.length));
		  for(int i = 0; i < D.length; i++)
		  		System.out.print(D[i] + ", ");
}

public static int []LargeIntSum(int[] A, int []B, int n)  {
 	int [] C = new int [A.length+1];
	int sum = 0; 
	int rem = 0;
	int carry = 0;
	int j = n;
	 
	for(int i = n-1 ; i >= 0; i--){
		sum = (A[i]+B[i]) + carry; 
		//System.out.println("sum# " + i + " = "+ sum);
		if(sum < 10){
			C[j--] = sum;
			carry = 0;
		}
		else{
			rem = sum % 10;
			carry = sum / 10;
			C[j--] = rem; 
		}//end if			
	}//end for
	if(carry != 0)
		C[j] = carry; 
	return C;
 }
end 4 ************************************************************/
/*Project 5********************************************************
public static void main(String[] args) {
        int [] A = {7, 3, 8, 5, 2, 0, 1, 0, 8, 9, 7, 6, 2, 4};
        int [] D = new int [A.length];
		  int n = 5;
        
        D = (times10To_m(A, A.length, n));
		  for(int i = 0; i < D.length; i++)
		  		System.out.print(D[i] + ", ");
}
public static int[] times10To_m(int[] A, int n, int m)  {
	int [] B = new int [n+m];
	
	for (int i = 0; i < n+m; i++)
		if (i < n)
			B[i] = A[i];
		else
			B[i] = 0;  
	
	return B; 	
} 
end 5 ************************************************************/
//*Project 6********************************************************
public static void main(String[] args) {
        int [] A = {7, 3, 8, 5, 2, 0, 1, 0, 8, 9, 7, 6, 2, 4};
        int [] D; //= new int [A.length+1];
		  int n = 1;
        
        D = (div10To_m(A, A.length, n));
		  for(int i = 0; i < D.length; i++)
		  		System.out.print(D[i] + ", ");
}
public static int[] div10To_m(int[] A, int n, int m){
	int [] B = new int [n-m];
	
	if (m != 0){
		for (int i = 0; i < n-m; i++)
			B[i] = A[i]; 
	}
	else
		B = A;  
	
	return B; 	
}
  
//end 6 ************************************************************/
/*Project 7********************************************************
public static void main(String[] args) {
        int [] A = {7, 3, 8, 5, 2, 0, 1, 0, 8, 9, 7, 6, 2, 4};
        int [] D; //= new int [A.length+1];
		  int n = 2;
        
        D = (rem10To_m(A, A.length, n));
		  for(int i = 0; i < D.length; i++)
		  		System.out.print(D[i] + ", ");
}
public static int[] rem10To_m(int[] A, int n, int m){
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
end 7 ************************************************************/
/*Project 8********************************************************
public static void main(String[] args) {
        int [] u = {4, 7, 2, 9};
        int [] v = {3, 5, 1, 8};
		  int n = 2;
        
        D = (rem10To_m(A, A.length, n));
		  for(int i = 0; i < D.length; i++)
		  		System.out.print(D[i] + ", ");
}
public static int[] prod2(int[] u, int[] v){
		int [] x, y, w, x, r, p, q;
		int n, m; 
		n = 
	return B; 	
}
end 8 ************************************************************/
/*Project 10********************************************************
public static void main(String[] args) {
		  int n =4;
		  int m;
		  
		  m = TwoTo_n(n);
        System.out.println("result of 2^" + n + " = " + m);
}
public static int TwoTo_n(int n){
	//type1-- tree
	int sum = 0;
		if(n == 1)
			return 2;
		else {
			sum = TwoTo_n(n-1) + TwoTo_n(n-1);
			return sum;  
		}}
	//type2 O(n)
		/*if(n == 0)
			return 1;
		else
			return (2 * TwoTo_n(n-1));*/
			
	// type3 O(n^2)
	/*if(n == 0)
		return 1;
	else
		return (1 + TwoTo_n(n-1));	
}
end 10 ************************************************************/
/*Project 11********************************************************
public static void main(String[] args) {
		  int n = 4;
		  int m;
		  
		  m = TwoTo_n(n);
        System.out.println("result of 2^" + n + " = " + m);
}

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
end 11 ************************************************************/
/*Project 12********************************************************
public static void main(String[] args) {
		  int n = 8;
		  int c = 0;
		  int m;
		  
		  m = TwoTo_n(n, c);
        System.out.println("result of 2^" + n + " = " + m);
}

public static int TwoTo_n(int n, int c){
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
end 11 ************************************************************/
}//end class