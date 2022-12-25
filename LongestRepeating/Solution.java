import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int j = 0;
        int i = 0;
        int biggestCount = 0;

        if (s == null || s.length() == 0 || k <= 0 || k >= 100000) return 0;
        HashMap<Character, Integer> bag = new HashMap<>();
        


        while (i < s.length()){
            char c = s.charAt(i);            
            

            if (bag.containsKey(c)){
                bag.put(c, bag.get(c)+1);
            }else{
                bag.put(c, 1);
            }

            biggestCount =  Math.max(biggestCount, bag.get(c));

            while(i - j + 1 - biggestCount > k){

                if (bag.containsKey(s.charAt(j))){
                    bag.put(s.charAt(j), bag.get(s.charAt(j))-1);
                }
                ++j;
            }


            max = Math.max(max, i - j +1);
            ++i;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.characterReplacement("RETCCC", 2));
    }
}