import java.util.*;

public class tryAlgorithm1 {
//uncomment problem you want to run, and make a comment to problem you don't want it to be executed. 

   public static void main(String args[]) {
/** project 1*********************************************	 
	 	int a = 3, b =16, m = 2, k = 5;
		int j, i = 0;
	 	for (j = a; j <= b; j++){
	 		if (j%k == 0 || j%m == 0){
		 		i++; 
				System.out.print(j +", ");
			}//end if 
	   }//end for
		System.out.println();
		System.out.println("total number = " + i);
***********************************************************/
/** project 2*********************************************
		boolean check = true;
		//int[] A ={ 20, 14, 11, 8, 6};
		//int[] A ={ 2, 2, 4, 10, 18, 26};
		//int[] A ={ 20, 14, 11, 18, 16};
		int min = A[0]; 
		int max = A[0];
					
			for(int i = 0; i < A.length-1; i++){
				if(A[i] <= A[i+1])
					max = A[i+1];
				else if(i != 0)
					check = false;
			}//end for1
			if(check == false){
				check = true;
				for(int i = 0; i < A.length-1; i++){
					if(A[i] >= A[i+1]){
						min = A[i+1];
					}
					else if(i != 0)
						check = false;
				}//end for2
			}//end if
			System.out.print(check);
***********************************************************/
/** project 3*********************************************
		boolean check = true;
		int[] A ={ 20, 14, 11, 18, 16, 1, 1};
		for(int i = 0; i < A.length; i++)
			for(int j = 0; j < A.length-1; j++){
				if((i != j)&& (A[i]==A[j]))
					check = false;
			
			} 
		System.out.print(check);
***********************************************************/
/** project 4*********************************************
		boolean check = true;
		int n = 4;
		int[][] B ={ {0,1,2,3}, {5,6,7,8}, {9,10,11,12}, {13,14,15,12}};
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				for(int m = 0; m < n; m++)
					for(int k = 0; k < n; k++){
						if(!(i== m && j== k)&&(B[i][j]==B[m][k]))
							check = false;
						}
		System.out.print(check);
***********************************************************/
/** project 5*********************************************
		boolean check = true;
		int n = 7; 
		for(int i = 1; i < n-1; i++){
			if(n%(i+1) == 0)
				check = false; 
		}
		System.out.print(check);
***********************************************************/
//** project 6*********************************************
	boolean check = false;
	int n = 4;
	int i = 0, j, k;
	//int[][] B ={ {0,1,2,3}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; 
	int[][] B ={ {0,1,12,3}, {5,6,7,8}, {9,10,11,12}, {3,14,15,16}};
	
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
					}//end while 
			}//end if
			j++;
		}//end while 2
		if(check == true)
			System.out.println("index: " + i);//return i;
		else
			i++;
	}//end while 1
	if(check == false)
		System.out.println("-1");//return -1; 
//***********************************************************/
/** project 8*********************************************
		int count = 0;
		int n = 14;
		System.out.println("n = " + n);
		for(int k = 1; k <= n/2; k++){
			System.out.println(k);
			count++;
			for (int m = 1; m <= k; m++)
			{
				System.out.println(k + ", " + m);
				count++;
			}
		}
System.out.println("count : " + count);
***********************************************************/
/** project 9*********************************************
			  int n = 729;
			  int count = 0;
			  int p, k, t;
			  p = n;
			  k = 10;
			  while (p >= 1){
			  		k = k + p;
					for (t = n; t >= 0; t = t-3){
						System.out.println(p + ", " + t);
						k++;
						count++;
					}
					p = p/3;
			  }
			  System.out.println("the result of k: " + k);
			  System.out.println("total lines of output: " + count);
************************************************************/
/** project 10*********************************************
				int count = 0;
				int n = 32; 
				int j, i = n;
				while (i >= 1){
					j = i;
					while (j <= n){
						System.out.println(i + ", " + j);
						j = 2*j;
						count++; 
					}
					i = i/2;
				}
		System.out.println("total lines: " + count);
************************************************************/
	 }	//end main
}//end class 
