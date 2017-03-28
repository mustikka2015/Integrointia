import java.util.*;

public class Main {
    public static int komponentteja(int n, int[] mista, int[] minne) {
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(komponentteja(3, new int[] {1,2,3}, new int[] {2,3,1})); //1
        System.out.println(komponentteja(3, new int[] {1,1}, new int[] {2,3}));     //3
        System.out.println(komponentteja(3, new int[] {1,1,2}, new int[] {2,3,3})); //3
        System.out.println(komponentteja(3, new int[] {1,1,2}, new int[] {2,3,1})); //2          
    }        
}


