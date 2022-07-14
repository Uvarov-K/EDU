package Terminal;

import java.sql.*;
import java.util.*;
//atdddddddddddd
public class MainMenu {

    public static void showMenu() {
        System.out.print(
                " ==================== \n" +
                " Available actions: \n" +
                " 1) deposit money \n" +
                " 2) withdraw money \n" +
                " 3) show balance \n" +
                " 4) exit\n" +
                " ==================== \n"
        );

        UserInput.chooseMenu();

    }

        public static void main (String[]args){
            MainMenu.showMenu();
        }
    }
