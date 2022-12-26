package MinWindowSubstring;
import java.util.HashMap;

//193 / 267 testcases passed
//come back to this later ig too hard
//doesn't allow more than each letter in t
//if t = abc it only allows 1 a, 1 b, 1 c

public class Solution {
    public String minWindow(String s, String t) {
        String minString = "";
        int maxLength = s.length();
        int condition = t.length();
        int start = 0;
        int end = 0;

        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }else if (s.equals(t)){
            return s;
        }

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
            if (stuff.containsKey(c)) {
                if (stuff.get(c) > 0) {
                    stuff.put(c, stuff.get(c)-1);
                    condition--;
                }else {
                    //need to remove c to make place for itself
                    // System.out.println("HELLO?");
                    // System.out.println(c);
                    // System.out.println("whattt: " + s.substring(start, end));
                    while (s.charAt(start) != c || !stuff.containsKey(s.charAt(start))){
                        if (stuff.containsKey(s.charAt(start))){
                            stuff.put(s.charAt(start), stuff.get(s.charAt(start))+1);
                            condition++;
                        }
                        start++;
                    }
                    do {
                        start++;
                    }while (!stuff.containsKey(s.charAt(start)));
                    
                }
            }else if (start <= end && !stuff.containsKey(s.charAt(start))){
                start++;
            }

            //we have used up all letters and current substring is the right one
            if (condition == 0){
                //if current substring is smaller than most recent substring that is not "" then save the current substring
                //then remove up until next letter in t
                if (maxLength >= s.substring(start, end+1).length()){
                    minString = s.substring(start, end+1);
                    maxLength = minString.length();
                }
                
                
                // System.out.println(minString);
                do {
                    if (stuff.containsKey(s.charAt(start))){
                        stuff.put(s.charAt(start), stuff.get(s.charAt(start))+1);
                        condition++;
                    }
                    start++;
                } while (start < s.length() && !stuff.containsKey(s.charAt(start)));

            }
            
            end++;
        }
        return minString;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
