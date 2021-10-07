package Test;

public class Test {

    public static int fibRec(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibRec(x - 1) + fibRec(x - 2);
    }

    public static void main(String[] args) {

        int[] fi = new int[10];
        fi[0] = 0;
        fi[1] = 1;

        for (int i = 2; i < fi.length; i++) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }

        for (int x : fi) {
            System.out.print(x + " ");
        }

        System.out.println("\nmethod with recursion\n");
        for (int t=0; t<=10; t++) {
            System.out.print(fibRec(t) + " ");
        }



    }
}






