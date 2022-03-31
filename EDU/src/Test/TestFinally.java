package Test;

public class TestFinally {
    static int t = 10;
    static int a = 10;

    public static void m() {
        try {
            int b = a / t;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        TestFinally t = new TestFinally();
        t.m();
    }
}


