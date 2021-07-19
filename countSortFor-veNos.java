import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) 
    {
        int arr[] = { -2,0,-1,0,-1 };
        int n = arr.length; int k=5;
        countSort(arr, n, -2, 0); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }
    
    static void countSort(int arr[], int n, int min,int max) 
    { 
       //ocde here
       int k=max-min;
       int count[]=new int[k+1];
       int arrDup[]=new int[n];
       for(int i=0;i<n;i++){
           arrDup[i]=arr[i]-min;
       }
       for(int i=0;i<n;i++){
           count[arrDup[i]]++;
       }
       
       
       //cumulative sum
       for(int i=1;i<k;i++){
           count[i]=count[i]+count[i-1];
       }
         int out[]=new int[n];
         //stable sorting algo
         for(int i=n-1;i>=0;i--){
             out[count[arrDup[i]]-1]=arr[i];
             count[arrDup[i]]--;
         }
         for(int i=0;i<n;i++){
             arr[i]=out[i]+min;
         }
       
       
    }
}
