package ValidAnagram;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;

        // HashMap<Character, Integer> lol = new HashMap<>();

        // for (int i = 0; i < s.length(); i++){
        //     char c = s.charAt(i);
        //     if (lol.containsKey(c)){
        //         lol.put(c, lol.get(c)+1);
        //     }else{
        //         lol.put(c, 1);
        //     }
        // }

        // for (int i = 0; i < t.length(); i++){
        //     char c = t.charAt(i);
        //     if (lol.containsKey(c) && lol.get(c) > 0){
        //         lol.put(c, lol.get(c)-1);
        //     }else{
        //         return false;
        //     }
        // }
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += s.charAt(i);
            sum -= t.charAt(i);
        }

        return sum == 0;
    }
}
