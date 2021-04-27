package codinginterview.ch03_queue_and_stack;

import java.util.Stack;

public class q34_스택으로큐 {

    public class MyQueue<T> {

        Stack stackNewest;
        Stack stackOldest;

        public MyQueue() {
            this.stackNewest = new Stack();
            this.stackOldest = new Stack();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            /* 새로운 원소가 상단에 놓이도록 stackNewest에 원소를 삽입한다. */
            stackNewest.push(value);
        }

        /* stackNewest에서 stackOldest로 원소를 옮긴다. */
        private void shiftStacks() {
            if(stackOldest.isEmpty()) {
                while(!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks();
            return (T) stackOldest.peek();
        }

        public T pop() {
            shiftStacks();
            return (T) stackNewest.pop();
        }
    }
}
