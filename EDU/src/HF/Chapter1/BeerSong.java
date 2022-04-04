package HF.Chapter1;

public class BeerSong {
    public static void main(String[] args) {

        int beerNum = 99;
        String word = "bottles";

        //while loop iterates until condition becomes false i.e. beerNum is not greater than 0
        while (beerNum > 0) {
            if (beerNum == 1) {
                word = "bottle";
            }   //end if condition

            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take one down");
            System.out.println("Pass it around.");
            //ensure the bottle count is reduced by 1 on each iteration
            beerNum = beerNum - 1;

            if (beerNum == 0) {
                System.out.println("No more bottles of beer on the wall");
            }
        }
    }
}