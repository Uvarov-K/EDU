package Chapter1;

public class Test {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        while (x < 5) {
            // y = x - y;
            // y = y + x;
            y = y + 2;
            if (y > 4) {
                y--;
            }
            System.out.print(x + " " + y + " ");
            x++;
        }
    }
}

