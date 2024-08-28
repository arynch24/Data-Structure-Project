package main.stack;

public class StackUtils {

    public static <T> void printStack(Stack<T> stack) {
        Stack<T> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            T data = stack.pop();
            System.out.print(data + " ");
            tempStack.push(data);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
