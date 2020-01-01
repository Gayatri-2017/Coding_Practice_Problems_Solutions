/*

Given K sorted arrays arranged in form of a matrix. 
The task is to merge them. 
You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. 
The function should return a pointer to the merged sorted arrays.

https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

*/


import java.util.*;
class Merge{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            GfG g = new GfG();
            ArrayList<Integer> arr= g.mergeKArrays(a, n);
            printArray(arr,n*n);
        }
    }
    public static void printArray(ArrayList<Integer> arr, int size){
        for(int i = 0; i < size ; i++)
            System.out.print(arr.get(i)+" ");
        System.out.println();
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class GfG
     {
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
          {
           //add code here.
           PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new AscendingComparator());
           
           for(int i=0; i<k; i++){
            //   for(int j=0; j<arrays[0].length; j++){
                for(int j=0; j<k; j++){
                   pq.add(arrays[i][j]);
               }
           }
        //   System.out.println("Priority Queue");
        //   Iterator iter = pq.iterator();
        //   while(iter.hasNext()){
        //         System.out.print((Integer)iter.next());
        //     }
        //     System.out.println();
          
           
           
        //   Iterator iter = pq.iterator();
           ArrayList<Integer> arrList = new ArrayList<Integer>();
        //   while(iter.hasNext()){
        //       arrList.add((Integer)iter.next());
        //   }
            while(!pq.isEmpty()){
                arrList.add(pq.poll());
            }
            return arrList;
          }
          
}

class AscendingComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return a.compareTo(b);
    }
}
