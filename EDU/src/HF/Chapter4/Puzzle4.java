package HF.Chapter4;

public class Puzzle4 {
    public static void main(String[] args) {
        Puzzl4b[] obs = new Puzzl4b[6];
        int y = 1;
        int x = 0;
        int result = 0;

        while (x < 6) {
            obs[x] = new Puzzl4b();
            obs[x].ivar = y;
            y = y * 10;
            x++;
        }
        x = 6;
        while (x > 0) {
            x--;
            result = result + obs[x].doStuff(x);
        }
        System.out.println("result " + result);

    }
}
