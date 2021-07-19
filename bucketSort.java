import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) 
    {
        int arr[] = { 30,40,10,80,5,12,70 };
        int n = arr.length; int k=4;
        bucketSort(arr, n, k); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }
    
    static void bucketSort(int arr[], int n, int k) { 
        
        //find max_value  
        int max_val=arr[0];
        for(int i:arr){
            if(max_val<i){
                max_val=i;
            }
        }
        //increment max_val so that max value is assigned to a bucket of size k 
        max_val++;
        
        //create buckets
       ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
       
       for(int i=0;i<k;i++){
           al.add(new ArrayList<Integer>());
       }
       
       //distribute the elements uniformly to buckets 
       for(int i=0;i<n;i++){
           int idx=arr[i]*k/max_val;
           al.get(idx).add(arr[i]);
       }
       
       //sort each bucket
       for(int i=0;i<k;i++){
           Collections.sort(al.get(i));
       }
       
    //   iterate each bucket individually
       int index=0;
       for(int i=0;i<k;i++){
           for(int j=0;j<al.get(i).size();j++){
               arr[index++]=al.get(i).get(j);
           }
       }
       
    }
}
