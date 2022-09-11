package Test;

public class StringEx {
    public static void main(String[] args) {

        String s = "@mos_helper_bot getdoc   doc id        555.1 2412";

        //if (s.startsWith("@mos_helper_bot") && s.matches("@mos_helper_bot\\s*getdoc.*[0-9]")) {
        if (s.startsWith("@mos_helper_bot") && s.matches("@mos_helper_bot\\s*getdoc\\s*.*[0-9]")) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

        String docID = s.replaceAll("[^.0-9]", "");
        System.out.println(docID);


    }
}
