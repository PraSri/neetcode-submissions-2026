class Solution {
    public int maxProfit(int[] a) {
          int max = 0;
        int l = 0;
        int r = l + 1;
        while (r < a.length) {
            if (a[l] < a[r]) {
                int profit = a[r] - a[l];
                max = Math.max(max, profit);
            } else {
                l = r;
            }
            r++;
        }
        return max;
    }
}
