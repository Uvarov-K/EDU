package Test;

public class Fi {
    public static void main(String[] args) {
        int n = 1000;
        long[] f = new long[n];
        int i;

        f[0] = 0;
        f[1] = 1;

        for (i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];

        }
        for (i = 0; i < n; i++) {
            System.out.print(f[i] + " ");
        }




    }

}


