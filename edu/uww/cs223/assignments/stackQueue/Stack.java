package edu.uww.cs223.assignments.stackQueue;

public class Stack {
    final int MAX_SIZE = 5;
    int top_of_stack = -1;
    String[] stack = new String[MAX_SIZE];

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Stack Contents       Top  Size");
        stack.printStack(stack.stack);
        try {
            stack.PUSH("C");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("S");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("-");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("2");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("2");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("1");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("2");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("2");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("1");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.PUSH("3");
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
        try {
            stack.POP();
            stack.printStack(stack.stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stack.printStack(stack.stack);
        }
    }

    private void printStack(String[] stack) {
        String stackString = "[";
        for (int i = 0; i <= top_of_stack; i++) {
            if (i == top_of_stack) {
                stackString += stack[i];
            } else if (stack[i] != null) {
                stackString += stack[i] + ", ";
            }
        }
        stackString += "]";

        System.out.printf("%-20s %-4s %-4s%n", stackString, top_of_stack, SIZE());
    }

    public void PUSH(String value) throws Exception {
        if (top_of_stack == MAX_SIZE - 1) {
            throw new Exception("Cannot Push because Stack is full");
        } else {
            stack[++top_of_stack] = value;
        }
    }

    public String POP() throws Exception {
        if (top_of_stack == -1) {
            throw new Exception("Cannot Pop because Stack is empty");
        } else {
            return stack[top_of_stack--];
        }
    }

    public String PEEK() throws Exception {
        if (top_of_stack == -1) {
            throw new Exception("Cannot Peek because Stack is empty");
        } else {
            return stack[top_of_stack];
        }
    }

    public int SIZE() {
        return top_of_stack + 1;
    }
}