package fortyLectures;

import java.util.Comparator;
import java.util.PriorityQueue;

//Leetcode 703
public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for(Integer num:nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
        }
        else {
            minHeap.offer(val);
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
