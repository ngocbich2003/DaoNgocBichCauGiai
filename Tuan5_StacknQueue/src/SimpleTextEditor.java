import java.util.*;

public class SimpleTextEditor {
    private static Scanner in = new Scanner(System.in);
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        stack.push("");
        while(in.hasNext()) {
            int ops = in.nextInt();
            switch(ops) {
                case 1: append(in.next()); break;
                case 2: delete(in.nextInt()); break;
                case 3: print(in.nextInt()); break;
                case 4: undo(); break;
                default: break;
            }
        }
    }

    private static void append(String W) {
        stack.push(stack.peek() + W);
    }

    private static void delete(int k) {
        stack.push(stack.peek().substring(0, stack.peek().length() - k));
    }

    private static void print(int k) {
        System.out.println(stack.peek().charAt(k - 1));
    }

    private static void undo() {
        stack.pop();
    }
}