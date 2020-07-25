import java.io.*;
import java.util.*;

public class Main {

 public static int findPivot_3(int[] a){
     int low = 0, hi = a.length-1;
     
     while(low <= hi){
        int mid = (low+hi)/2;
        if(a[mid] < a.length-1  && a[mid] < a[mid+1] && a[mid] < a[mid-1]){
         return mid;
        }
        if(a[mid] > low && a[mid] < a[mid+1] && a[mid] < a[mid-1]){
         return mid;
        }
        else if(a[low] <= a[mid]){
           low =  mid + 1;
        }
        else {
           hi =  mid - 1;
        }
     } 
     return 0;
 } 

 public static int findPivot(int arr[]){
      for(int idx = 1; idx < arr.length; idx++){
          int curr = arr[idx];
          int prev =  arr[idx-1];
          
          if(curr < prev){
              //break point
              return idx;
          }
          
      }
      return 0;
  }
  public static int findPivot2 (int arr[]){
      //right to left
      for(int idx =  arr.length-1; idx > 0; idx--){
          int curr = arr[idx];
          int next =  arr[idx-1];
          
          if(curr < next){
              //break point
              return idx;    // pivot index
          }
          
      }
      return 0;
  }
  public static void targetSumPair(int[] arr, int target) {
    //write your code here
    int pivotIdx = findPivot_3(arr);
    System.out.println(pivotIdx);
    int i = pivotIdx;
    int j = (pivotIdx - 1 >= 0) ? pivotIdx - 1 : arr.length - 1 ;
    int count=0;
    
    while(count < arr.length-1){ // while(len - count > 1)
        if( (arr[i] + arr[j])< target ){ 
            i = (i+1) % arr.length;
            count++;
        }
        
        else if((arr[i] + arr[j])> target ){
            j = (j-1 + arr.length) % arr.length;
            count++;
            
        }
        
        else{
            System.out.println(arr[i] +", "+ arr[j]);
            i = (i+1) % arr.length;
            j = (j-1 + arr.length) % arr.length;
            count += 2;
        }
        
    }

  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}