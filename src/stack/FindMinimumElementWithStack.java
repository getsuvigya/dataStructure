package stack;

import java.util.Scanner;

public class FindMinimumElementWithStack {
    public static void main(String s[]) throws StackUnderFlowException, StackOverFlowException {
        FindMinimumElementWithStack findMinimumElementWithStack = new FindMinimumElementWithStack();
        String command = "";
        System.out.println("Enter Command: ");
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("EXIT")) {
            command = scanner.nextLine();
            String[] words = command.split("\\s+");
            if (words[0].equalsIgnoreCase("push")) {
                System.out.println("Element at the top: " + findMinimumElementWithStack.pushDataAndMAintainMin(Integer.parseInt(words[1])));
            }
            if (words[0].equalsIgnoreCase("pop")) {
                System.out.println("Element popped: " + findMinimumElementWithStack.popAndMAinTainMin());
            }
            if (words[0].equalsIgnoreCase("peek")) {
                System.out.println("Element at the top: " + findMinimumElementWithStack.getMin());
            }
        }
    }
    Stack<Integer> elementStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public int pushDataAndMAintainMin(int data) throws StackUnderFlowException, StackOverFlowException {

        int min = data;
        if(!elementStack.isEmpty()){
            if(min>minStack.peek()){
                min = minStack.peek();
            }
        }
        minStack.push(min);
        elementStack.push(data);
        return min;
    }
    public int popAndMAinTainMin() throws StackUnderFlowException {
        minStack.pop();
        return elementStack.pop();
    }
    public int getMin() throws StackUnderFlowException {
        return minStack.peek();
    }
}
