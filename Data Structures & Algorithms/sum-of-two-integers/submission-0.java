class Solution {
    public int getSum(int a, int b) {
        while(b!=0) {
            int carry = (a&b) << 1;// a = 1 , b = 2 , a = 001, b=010
            // a&b=000, carry = 0
            a ^= b;
            b = carry;
        }
        return a;
    }
}
