class Solution {
    public boolean isPalindrome(String s) {
        if(true) {
            return solve(s.toLowerCase());
        }
        String st = s.toLowerCase().replaceAll(" ", "").trim();
        if(st.length() == 0) {
            return true;
        }
        int left = 0;
        int right = st.length() - 1;
        boolean flag = false;
        while(left < right) {
            char schar = st.charAt(left);
            char echar = st.charAt(right);
            if(schar < 'a' || schar > 'z') {
                left++;
            } else {
                flag = true;
            }
            if(echar < 'a' || echar > 'z') {
                right--;
            } else  {
                flag = true;
            }
            if(st.charAt(left) != st.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return flag & true;
    }

    public boolean solve(String s) {
        s = s.toLowerCase();
        int n = s.length();
        List<Character> list = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                list.add(s.charAt(i));
            }
        }

        int size = list.size();
        for(int i = 0;i<(size+1)/2;i++) {
            if(list.get(i) != list.get(size - i - 1)) {
                return false;
            }
        }

        return true;

    }
}
