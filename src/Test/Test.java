package Test;

public class Test {


    interface inter {
        int a= 10;

        static void met1() {

        }

        void met2();
    }

    public static void main(String[] args) {
I2.met1();

    }


    public static class I2 implements inter {


        public static void met1() {
            System.out.println(a);

        }

        @Override
        public void met2() {
            System.out.println(a+2);

        }
    }

}

