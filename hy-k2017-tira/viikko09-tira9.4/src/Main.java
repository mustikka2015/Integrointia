import java.util.*;


public class Main {
    public static boolean velat(int n, int[] saatavia, int[] mista, int[] minne) {
        return false;
    }
    
    public static void main(String[] args) {
        int[] saatavia1 = {0,1,3,-4};
        int[] mista1 = {1,3};
        int[] mihin1 = {2,1};
        System.out.println(velat(3, saatavia1, mista1, mihin1)); //true
        
        int[] saatavia2 = {0, 1, 1, 1, -3};
        int[] mista2 = {1, 2, 3};
        int[] mihin2 = {2, 3, 4};
        System.out.println(velat(4, saatavia2, mista2, mihin2)); //true
        
        int[] saatavia3 = {0, 1, 1, 1, -3};
        int[] mista3 = {1, 2};
        int[] mihin3 = {2, 3};
        System.out.println(velat(4, saatavia3, mista3, mihin3)); //false
    }        
}

