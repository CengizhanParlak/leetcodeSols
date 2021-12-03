import java.util.HashMap;
import java.util.Map;

// hashmap + checks in single loop
// helper method w/ switch case statements that corresponds to roman char - number pairs
public class E_roman_to_int {
    public static void main(String[] args) throws Exception {
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("XCV"));
    }

    // NOTE: if you have to do 'small number' of primitive checks, use a helper
    // method or an array than HashMap. HashMap needs more memory than a simple
    // array (w/ fixed length).

    // NOTE-2: Char array solution or a simple helper method to check chars in each
    // iteration uses less memory and runs faster.

    // TODO: Change hashmap to char array. Control the chars from this array inside
    // the for loop.

    static int romanToInt(String s) {
        Map<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {// 6
            int firstNum = romanNumbers.get(s.charAt(i)); /// 1
            if (i != s.length() - 1 && firstNum < romanNumbers.get(s.charAt(i + 1))) {
                sum += romanNumbers.get(s.charAt(i + 1)) - firstNum;
                i++;
            } else {
                sum += firstNum;
            }
        }
        return sum;
    }
}
