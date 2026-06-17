class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] arr = stack.pop();
                res[arr[1]] = i-arr[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
