public class E_implement_strStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int startingIndex = 0;
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i] == needleChars[0]) {
                startingIndex = i;
                for (int j = 0; j < needleChars.length; j++) {
                    if (haystackChars[i + j] != needleChars[j]) {
                        break;
                    }
                    if (j == needleChars.length - 1) {
                        return startingIndex;
                    }
                }
            }
        }
        return -1;
    }
}
