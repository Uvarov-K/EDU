package Test;

public class StringArr {
    public static void main(String[] args) {

        String[] arr = new String[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = "a" + i;
        }

        System.out.println("String array is: ");
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }



        }


    }

