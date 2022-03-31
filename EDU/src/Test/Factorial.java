package Test;

public class Factorial {
    int fact(int x) {
        int result;

        if (x == 1)
            return 1;
        result = fact(x - 1) * x;
        return result;

    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.fact(3));
    }

}
