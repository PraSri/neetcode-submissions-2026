class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int s = 1;
        int e = piles[n-1];
        while(s<e) {
            int mid = s + (e-s)/2;
            if(isPossible(piles, mid, h)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private boolean isPossible(int[] piles, int k, int h) {
        int count = 0;
        int i = 0;
        int n = piles.length;
        while(i < n) {
            int time = piles[i]/k;
            count += time;
            if(piles[i]%k!=0) {
                count++;
            }
            i++;
        }
        return count<=h;
    }
}
