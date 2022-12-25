package MinWindowSubstring;
import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        String substring = "";
        int start = 0;
        int end = 0;

        HashMap<Character, Integer> stuff = new HashMap<>();

        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (stuff.containsKey(c)){
                stuff.put(c, stuff.get(c)+1);
            }else{
                stuff.put(c, 1);
            }
        }

        while (end < s.length()){
            char c = s.charAt(end);

            
        }

        return substring;
    }
}
