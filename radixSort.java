import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) 
    {
        int arr[] = { 319,212,6,8,100,50 };
        int n = arr.length; 
        radixsort(arr, n); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }
    
    static void countingSort(int arr[], int n, int exp) 
    { 
         int count[]=new int[10];
       for(int i=0;i<n;i++){
           count[arr[i]/exp%10]++;
           //arr[i]/exp%10 will evaluate to 1, 10 ,100, place
       }
       
       //cumulative sum
       for(int i=1;i<10;i++){
           count[i]=count[i]+count[i-1];
       }
         int out[]=new int[n];
         //stable sorting algo
         for(int i=n-1;i>=0;i--){
             out[count[arr[i]/exp%10]-1]=arr[i];
             count[arr[i]/exp%10]--;
         }
         for(int i=0;i<n;i++){
             arr[i]=out[i];
         }
       }
    
    public static void radixsort(int arr[], int n) 
    { 
       int max=arr[0];
       for(int i:arr){
           if(i>max){
               max=i;
           }
       }
       //no of 0's will be decided based on max
       //[0001,2222]
       //first sort 1 place, then 10 place,......
       for(int exp=1;max/exp>0;exp*=10){
           countingSort(arr,n,exp);
       }
    }
}
