package stack;

import java.util.Scanner;

public class Stack<T> {
    private static int MAX_SIZE=10;
    private Element<T> top;
    private int size=0;

    public T push(T data) throws StackOverFlowException {
        if(size == MAX_SIZE){
            throw new StackOverFlowException();
        }
        Element element = new Element(data,top);
        top = element;
        size++;
        return top.getData();
    }

    public T pop() throws StackUnderFlowException {
        if(size == 0){
            throw new StackUnderFlowException();
        }
        T data = top.getData();
        top = top.getNext();
        if(top!=null)
        System.out.println("Element at the top:"+top.getData());
        size--;
        return data;
    }

    public T peek() throws StackUnderFlowException{
        if(size == 0){
            throw new StackUnderFlowException();
        }
        T data = top.getData();
        return data;
    }

    public static void main(String s[]) throws StackOverFlowException, StackUnderFlowException {
        Stack<Integer> stack = new Stack<>();
        String command="";
        System.out.println("Enter Command: ");
        Scanner scanner = new Scanner(System.in);
        while(!command.equals("EXIT")){
            command = scanner.nextLine();
            String[] words = command.split("\\s+");
            if(words[0].equalsIgnoreCase("push")) {
                  System.out.println("Element at the top: "+stack.push(Integer.parseInt(words[1])));
            }
            if(words[0].equalsIgnoreCase("pop")) {
                System.out.println("Element popped: "+stack.pop());
            }
            if(words[0].equalsIgnoreCase("peek")) {
                System.out.println("Element at the top: "+stack.peek());
            }
        }
        System.out.print("Operations completed!");

    }

    public boolean isEmpty(){
        return size==0;
    }
}
