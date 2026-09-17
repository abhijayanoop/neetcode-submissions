class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] count = new int[26];
        for(int task: tasks){
            count[task - 'A']++;
        }

        for(int cnt: count){
            if(cnt>0){
                maxHeap.add(cnt);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = maxHeap.poll();
                if(cnt-1 > 0){
                    q.offer(new int[]{cnt-1, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
