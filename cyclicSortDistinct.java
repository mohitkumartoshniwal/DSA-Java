import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    // static int swaps=0;
    public static void main (String[] args) 
    {
        int arr[] = { 20,40,50,10,30 }; 
        int n = arr.length; 
        cycleSortDistinct(arr, n); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        // System.out.println("No of swaps: "+swaps);
        
    }
    // static void swap(int a,int b){
    //     int temp=a;
    //     a=b;
    //     b=temp;
    //     swaps++;
    // }
    static void cycleSortDistinct(int arr[], int n) 
    { 
        for(int cs=0;cs<n-1;cs++){
            int item=arr[cs];
            int pos=cs;
            for(int i=cs+1;i<n;i++){
                if(item>arr[i]){
                    pos++;
                }
            }
            // swap(item,arr[pos]);
            int temp=arr[pos];
            arr[pos]=item;
            item=temp;
            while(pos!=cs){
                pos=cs;
                 for(int i=cs+1;i<n;i++){
                if(item>arr[i]){
                    pos++;
                }
            }
             temp=arr[pos];
            arr[pos]=item;
            item=temp;
            
            }
        }
    }
}
