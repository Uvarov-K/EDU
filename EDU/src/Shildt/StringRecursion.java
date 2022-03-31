package Shildt;

public class StringRecursion {

    String str;

    StringRecursion(String s) {
        str = s;
    }


    void revers(int idx) {
        if (idx != str.length() - 1)
            revers(idx + 1);
        System.out.print(str.charAt(idx));
    }


    public static void main(String[] args) {
        StringRecursion ob = new StringRecursion("One Two");
        ob.revers(0);


    }


}
