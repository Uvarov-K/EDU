package Chapter4;

public class Dog {
    private int size;
    private String name;

    private int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark(int numOfBarks) {
        while (numOfBarks > 0) {
            System.out.println("Woof - Woof");
            numOfBarks--;
        }
    }
}
