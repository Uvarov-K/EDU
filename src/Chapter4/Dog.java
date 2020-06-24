package Chapter4;

public class Dog {
    int size;
    String name;

    void bark(int numOfBarks) {
        while (numOfBarks > 0) {
            System.out.println("Woof - Woof");
            numOfBarks--;
        }
    }
}
