package stack;

import java.util.*;

public class MatchingParantheses {
    private static Map<Character, Character> matchingParenMap = new HashMap<>();
    private static Set<Character> openingParenSet = new HashSet<>();
    static {
        matchingParenMap.put(')','(');
        matchingParenMap.put('}','{');
        matchingParenMap.put(']','[');
        openingParenSet.addAll(matchingParenMap.values());
    }
    public boolean isParenMatach(String inputString) throws StackOverFlowException, StackUnderFlowException {
        Stack<Character> parenStack = new Stack<>();
        for(int i=0; i<inputString.length(); i++){
            Character inputChar = inputString.charAt(i);
            if(openingParenSet.contains(inputChar)){
                parenStack.push(inputChar);
            }
            if(matchingParenMap.containsKey(inputChar)){
                Character poppedChar = parenStack.pop();
                if(!poppedChar.equals(matchingParenMap.get(inputChar))){
                    return false;
                }
            }
        }
        return parenStack.isEmpty();
    }

    //input ---    [{(abc)def}(ghi)]
    public static void main(String s[]) throws StackUnderFlowException, StackOverFlowException {
        MatchingParantheses matchingParantheses = new MatchingParantheses();
        System.out.println("Enter Command: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        boolean flag = matchingParantheses.isParenMatach(inputString);
        System.out.print(flag);
    }
}
