import java.util.PriorityQueue;

public class day1 {

    public static class Pair implements Comparable<Pair> {
    
            int val;
            int idx;

            public Pair(int val, int idx){
                this.val = val;
                this.idx = idx;
            }

           public int compareTo(Pair p2){
            return p2.val-this.val;
           }
    }
    public static int[] slidingWindow(int arr[], int k){
        int n = arr.length;
        int res[] = new int[n-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // first window 

        for(int i =0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;
        // rest windows 
        int j=1;
        for(int i=k;i<n;i++){
            if(pq.size()>0 && pq.peek().idx <= i-k){
                    pq.poll();
            }
            pq.add(new Pair(arr[i], i));
            res[j] = pq.peek().val;
            j++;
        }

        return res;
    }
    public static void main(String [] args){
        // System.out.print("hello");
        int [] arr = {3,2,9,2,1,5,4,7,5,3};
        int k = 3;
        int res[] = slidingWindow(arr, k);
        for(int i: res){
            System.out.println(i);
        }
    }
}
