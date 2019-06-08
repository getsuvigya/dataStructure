package queue;

import java.lang.reflect.Array;

public class Queue<T> {
    private static int SPECIAL_EMPTY_VALUE=-1;
    private static int MAX_SIZE = 5;
    private int headIndex=SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    private T elements[];

    public Queue(Class<T> clazz){
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }
    public boolean isFull(){
        int nextIndex = (tailIndex + 1)%elements.length;
        return nextIndex==headIndex;
    }
    public boolean isEmpty(){
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public void enqueue(T data) throws QueueOverFlowException {
        if(isFull()){
            throw new QueueOverFlowException();
        }
        tailIndex = (tailIndex + 1)% elements.length;
        elements[tailIndex] = data;

        if(headIndex == SPECIAL_EMPTY_VALUE){
            headIndex = tailIndex;
        }
        System.out.println("Element added "+data);
    }
    public T dequeue() throws QueueUnderFlowException {
        if(isEmpty()){
            throw new QueueUnderFlowException();
        }
        T data = elements[headIndex];
        if(headIndex == tailIndex){
            headIndex = SPECIAL_EMPTY_VALUE;
        }else {
            headIndex = (headIndex + 1) % elements.length;
        }
        System.out.println(data);
        return data;
    }

    public static void main(String s[]) throws QueueOverFlowException, QueueUnderFlowException {
        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }
}
