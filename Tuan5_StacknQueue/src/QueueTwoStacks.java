import java.util.*;

public class QueueTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your    class should be named Solution. */
        MyQueue q = new MyQueue();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int in = sc.nextInt();
            if(in == 1) {
                int data = sc.nextInt();
                q.enqueue(data);
            } else if(in == 2) {
                q.dequeue();
            } else if(in == 3) {
                System.out.println(q.peek());
            }
        }
        sc.close();
    }

    public static class MyQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int n) {
            stack1.push(n);
        }

        public void dequeue() {
            if(stack2.size() == 0) {
                moveAll();
            }
            stack2.pop();
        }

        public Integer peek() {
            if(stack2.size() == 0) {
                moveAll();
            }
            return stack2.peek();
        }

        public void moveAll() {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}