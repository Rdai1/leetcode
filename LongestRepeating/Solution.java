import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s, int k) {
        int max = 0;
        int j = 0;
        int i = 0;
        int temp = 0;
        char thing = s.charAt(0);

        if (s == null || s.length() == 0 || k <= 0 || k >= 100000) return 0;
        // Set<Character> set = new HashSet<>();
        LinkedList list = new LinkedList<>();
        

        while (i < s.length()){
            char c = s.charAt(i);
            while(temp > k){

                // set.remove(s.charAt(j));
                list.remove(s.charAt(j));
                ++j;
            }
            // set.add(c);
            list.add(c);
            max = Math.max(max, i - j +1);
            ++i;
        }

        return max;
    }
}