import java.util.*;
public class hello{
    public static class Pair implements Comparable<Pair> {
        int data;
        int idx;

        public Pair(int data, int idx){
            this.data = data;
            this.idx = idx;

        }
        public int compareTo(Pair p2){
            return p2.data - this.data;
        }
    }
    public static int[] slidingWindow(int arr[], int k){
        int n = arr.length;
        int newArr[] = new int[n-k+1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //   for 1st window 
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }
        newArr[0] = pq.peek().data;
        int j=1;
    // for all rest windows 
    for(int i=k;i<n;i++){
        while(pq.size()>0 && pq.peek().idx <=(i-k)){
            pq.poll();
        }
        pq.add(new Pair(arr[i], 0));
        newArr[j] = pq.peek().data;
        j++;
    }
    return newArr;
    }
    public static void main(String[] args){
        int arr[] = {1,2,-1,-3,5,3,6,7};
        int k = 3;
       int res [] =  slidingWindow(arr,k);
       for(int i: res){
        System.out.println(i);
       }
    }
}