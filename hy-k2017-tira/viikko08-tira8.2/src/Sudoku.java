
import java.util.Scanner;


public class Sudoku {


    public static void ratkaise(int[][] sudoku) {
        // Toteuta minut
    }

     private static String[] esim1 = new String[]{
            "8??93???2",
            "??9????4?",
            "7?21??96?",
            "2??????9?",
            "?6?????7?",
            "?7???6??5",
            "?27??84?6",
            "?3????5??",
            "5???62??8"};

    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
       
        sudoku = toIntArray(esim1);

        ratkaise(sudoku);
        System.out.println("Ratkaisu:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] toIntArray(String[] rs) {
        int[][] s = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rs[i].charAt(j) != '?') {
                    s[i][j] = Character.digit(rs[i].charAt(j), 10);
                }
            }
        }
        return s;
    }
}
