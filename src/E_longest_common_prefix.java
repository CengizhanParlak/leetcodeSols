import java.util.HashMap;
import java.util.Map;

// horizontal scanning: (O(S)time O(1) memory) -> check one by one. update min common prefix. return that at the end
// vertical scanning: (O(S)time O(1) memory) -> check first char of all elements, then second... return if there is no match
public class E_longest_common_prefix {
    public static void main(String[] args) {
        // String[] strs = { "flower", "flow", "flight" };
        String[] strs = { "abcde", "abc", "abcabc" };
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        Map<Integer, Character> longestMatch = new HashMap<Integer, Character>();
        String longestPrefix = "";
        StringBuilder sb = new StringBuilder();
        // take first element as longest common prefix.
        // This way we'll have a reference point
        for (int i = 0; i < strs[0].length(); i++) {
            longestMatch.put(i, strs[0].charAt(i));
        }
        int lenghtOfCommonPrefix = strs[0].length();

        int lengthOfArray = strs.length;

        for (int i = 1; i < lengthOfArray; i++) {
            int localMin = 0;
            // number of iterations in the second loop should correspond to the length of
            // second string
            int maxNumToLoop = lenghtOfCommonPrefix < strs[i].length() ? lenghtOfCommonPrefix : strs[i].length();
            for (int j = 0; j < maxNumToLoop; j++) {
                // as long as chars in 2n string match the one we accepted as longest prefix
                if (longestMatch.get(j) == strs[i].charAt(j)) {
                    localMin++;
                } else {
                    // if matched chars in this iteration are less than length of our previous
                    // longest prefix, update the new value
                    lenghtOfCommonPrefix = localMin < lenghtOfCommonPrefix ? localMin : lenghtOfCommonPrefix;
                    break;
                }
            }
            lenghtOfCommonPrefix = localMin < lenghtOfCommonPrefix ? localMin : lenghtOfCommonPrefix;
        }
        // append chars from hashmap until we reach to prefix length
        if ((lenghtOfCommonPrefix != 0 && lengthOfArray >= 1)) {
            for (int i = 0; i < lenghtOfCommonPrefix; i++) {
                sb.append(longestMatch.get(i).toString());
            }
            longestPrefix = sb.toString();
        }
        return lenghtOfCommonPrefix == 0 ? "" : longestPrefix;
    }
}
