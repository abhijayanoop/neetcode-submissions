class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stone: stones){
            minHeap.offer(-stone);
        }

        while(minHeap.size() > 1){
            int x = minHeap.poll();
            int y = minHeap.poll();
            if(x<y){
                minHeap.offer(x-y);
            }
        }
        minHeap.offer(0);
        return Math.abs(minHeap.poll());
    }
}
