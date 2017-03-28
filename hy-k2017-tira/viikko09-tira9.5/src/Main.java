import java.util.*;
public class Main {
    public static long reittimaara(int n, int[] mista, int[] minne) {
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(reittimaara(2, new int[] {1}, new int[] {2}));                               //1
        System.out.println(reittimaara(5, new int[] {1,1,2,3,4}, new int[] {2,3,4,4,5}));               //2
        System.out.println(reittimaara(5, new int[] {1, 1, 1, 2, 3, 4}, new int[] {2, 3, 4, 5, 5, 5})); //3
        System.out.println(reittimaara(7, new int[] {1,2,3,1,1,4,5,6}, new int[] {2,3,7,4,5,6,6,7}));   //3

    }        
}

