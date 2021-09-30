package Shildt;

public class StackTest {
    private char stck[]; // this array holds the stack
    private int tos;  // top of stack

    // Construct an empty Stack given its size.
    StackTest(int size) {
        stck = new char[size]; // allocate memory for stack
        tos = 0;
    }

    // Construct a Stack from a Stack.
    StackTest(StackTest ob) {
        tos = ob.tos;
        stck = new char[ob.stck.length];

        // copy elements
        for(int i=0; i < tos; i++)
            stck[i] = ob.stck[i];
    }

    // Construct a stack with initial values.
    StackTest(char a[]) {
        stck = new char[a.length];

        for(int i = 0; i < a.length; i++) {
            push(a[i]);
        }
    }


    // Push characters onto the stack.
    void push(char ch) {
        if(tos==stck.length) {
            System.out.println(" -- Stack is full.");
            return;
        }

        stck[tos] = ch;
        tos++;
    }

    // Pop a character from the stack.
    char pop() {
        if(tos==0) {
            System.out.println(" -- Stack is empty.");
            return (char) 0;
        }

        tos--;
        return stck[tos];
    }
}

// Demonstrate the Stack class.
class SDemo {
    public static void main(String args[]) {
        // construct 10-element empty stack
        StackTest stk1 = new StackTest(10);

        char name[] = {'T', 'o', 'm'};

        // construct stack from array
        StackTest stk2 = new StackTest(name);

        char ch;
        int i;

        // put some characters into stk1
        for(i=0; i < 10; i++)
            stk1.push((char) ('A' + i));

        // construct stack from another stack
        StackTest stk3 = new StackTest(stk1);

        //show the stacks.
        System.out.print("Contents of stk1: ");
        for(i=0; i < 10; i++) {
            ch = stk1.pop();
            System.out.print(ch);
        }

        System.out.println("\n");

        System.out.print("Contents of stk2: ");
        for(i=0; i < 3; i++) {
            ch = stk2.pop();
            System.out.print(ch);
        }

        System.out.println("\n");

        System.out.print("Contents of stk3: ");
        for(i=0; i < 10; i++) {
            ch = stk3.pop();
            System.out.print(ch);
        }
    }
}

