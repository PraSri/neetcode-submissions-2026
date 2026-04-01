class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Input: tasks = ["X","X","Y","Y", "Z"], n = 3
        // x y z _ x y = 6

        // Input: tasks = ["A","A","A","B","C"], n = 3
        // a b c _ a _ _ _ a = 9
        // a = 3, b = 1, c = 1
        // a _ _ _ a _ _ _ a

        // store frequency of each task
        // find max fre
        // find max count of max fre
        // cal time 
        // ans = max(tasks.len, time)
        int[] count = new int[26];
        for(char task: tasks) {
            count[task - 'A']++;
        }
        int maxf = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for(int i : count) {
            if(i == maxf) {
                maxCount++;
            }
        }
        int time = (maxf - 1) * (n+1) + maxCount;
        return Math.max(time, tasks.length);
    }
}
