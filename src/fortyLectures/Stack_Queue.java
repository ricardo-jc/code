package fortyLectures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Queue {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public void queue_push(int input) {
        s1.push(input);
    }

    public int queue_pop() {
        if(s2.empty()){
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        else
            return s2.pop();
    }

    public int queue_peek(){
        if(s2.empty()){
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
        else
            return s2.peek();
    }

    public boolean queue_empty(){
        return s1.empty() && s2.empty();
    }

    Queue<Integer> q1 = new LinkedList<>();

    public void stack_push(int input) {
        q1.add(input);
        for(int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.poll());
        }
    }
    public int stack_pop() {
            return q1.poll();
    }
    public int stack_peek() {
            return q1.peek();
    }
    public boolean stack_empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Stack_Queue s = new Stack_Queue();
        s.stack_push(1);
        s.stack_push(2);
        s.stack_push(3);
        System.out.println(s.stack_peek());
        System.out.println(s.stack_pop());
        System.out.println(s.stack_peek());
        System.out.println(s.stack_pop());
        System.out.println(s.stack_peek());
        System.out.println(s.stack_empty());
        System.out.println(s.stack_pop());
        System.out.println(s.stack_empty());
    }
}
