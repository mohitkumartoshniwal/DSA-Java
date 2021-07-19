import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) 
    {
        int arr[] = { 1,4,4,1,0,1 };
        int n = arr.length; int k=5;
        countSort(arr, n, k); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }
    
    static void countSort(int arr[], int n, int k) 
    { 
       //ocde here
       int count[]=new int[k];
       for(int i=0;i<n;i++){
           count[arr[i]]++;
       }
       
       //cumulative sum
       for(int i=1;i<k;i++){
           count[i]=count[i]+count[i-1];
       }
         int out[]=new int[n];
         //stable sorting algo
         for(int i=n-1;i>=0;i--){
             out[count[arr[i]]-1]=arr[i];
             count[arr[i]]--;
         }
         for(int i=0;i<n;i++){
             arr[i]=out[i];
         }
       
       
    }
}
