package Test;

/*
Напишите программу, в которой массив используется для нахождения среднего
арифметического десяти значений типа doube. Используйте любые десять чисел.
 */
public class AvgArr {
    public static void main(String[] args) {
        double[] arr = new double[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;

        }
        System.out.print("array numbers: ");
        for (double x : arr) {
            System.out.print(arr[(int) x] + " ");
        }

        double sum = 0;
        for (double x : arr) {

            sum += arr[(int) x];
        }
        System.out.println("");
        System.out.println("avg: " + sum / arr.length);




    }


}
