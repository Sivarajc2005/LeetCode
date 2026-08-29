class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            String curr = words[i];
            if (!curr.trim().isEmpty()) {
                // System.out.println(curr);
                sb.append(" ");
                sb.append(curr.trim());
            }
        }
        // System.out.println(Arrays.toString(words));
        // System.out.println(sb.toString().trim());
        return sb.toString().trim();
    }
}