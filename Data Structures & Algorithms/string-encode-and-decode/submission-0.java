class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(len).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < n) {
            int j = i;
            while(str.charAt(j)!='#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + len;
            res.add(str.substring(i,j));
            i = j;
        }
        return res;
    }
}
