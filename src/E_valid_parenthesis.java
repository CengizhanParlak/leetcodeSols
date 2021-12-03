import java.util.Stack;

class E_valid_parenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("{{}}()[()]"));
        System.out.println(isValid("("));
        System.out.println(isValid("(("));
        System.out.println(isValid("(}"));
        System.out.println(isValid("(())({)"));
    }

    /**
     * Method to check if a string consist of only valid matching pair of brackets.
     * Like:
     * <ul>
     * <li>" ( ) "</li>
     * <li>" { { { } } } "</li>
     * <li>" [ ] ( ) { { ( ) } } "</li>
     * </ul>
     * 
     * @param s - String to check if has valid bracket pairs
     * @return true or false
     * @implNote 1 <= s.length <= 10^4. <b>s</b> consists of parentheses only
     *           '()[]{}'
     */

    static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> bracketStack = new Stack<Character>();
        for (Character element : s.toCharArray()) {
            if (!bracketStack.empty()) {
                switch (element) {
                    case ')':
                        if (bracketStack.peek() == '(') {
                            bracketStack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (bracketStack.peek() == '[') {
                            bracketStack.pop();
                        } else {
                            return false;

                        }

                        break;
                    case '}':
                        if (bracketStack.peek() == '{') {
                            bracketStack.pop();
                        } else {
                            return false;
                        }

                        break;
                    default:
                        bracketStack.push(element);
                        break;
                }
            } else {
                bracketStack.push(element);
            }
        }
        return bracketStack.empty();
    }
}