import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> small; // Max-Heap
    private PriorityQueue<Integer> large; // Min-Heap

    public MedianFinder() {
        // small stores the smaller half; peek() gives the largest of the small
        small = new PriorityQueue<>(Collections.reverseOrder());
        // large stores the larger half; peek() gives the smallest of the large
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // 1. Always add to small first, then move the largest of small to large
        small.offer(num);
        large.offer(small.poll());
        
        // 2. Rebalance: small can have at most one more element than large
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            // Mean of the two middle elements
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
