package LLD_Java_Essentials.Riddhi_Dutta_Java_Collections.Stack;

import java.util.Stack;

public class demo {
    public static void main(String[] args) {
        // // All do same thing; offer doesn't throw error and returns null, hence preferred.
        // q.add(1);
        // q.push(1); // same as add()
        // q.offer(1);

        // // Both do same thing; but poll doesn't throw error if ele not present, instead returns null
        // q.remove(1);
        // q.pop(); // same as remove()
        // q.poll(1);

        // // Both do same thing; peek doesn't throw error incase queue is empty
        // q.peek();
        // q.element();

        // To use stacks -> Stack
        // To use queue -> LinkedList
        // To use Deque -> ArrayDeque

        // LIFO Stack demo 
        Stack<Integer> st = new Stack<>();
        st.push(1);

        System.out.println(st.peek());
        System.out.println("Removing = " + st.pop());
    }
}
