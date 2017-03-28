import java.util.*;

public class Main {
    public static long kolikoita(int n, long[] k, int[] mista, int[] minne) {
        return 0l;
    }
    
    public static void main(String[] args) {
        System.out.println(kolikoita(3, new long[] {0, 1, 1, 1}, new int[] {1, 2}, new int[] {2, 3})); //3
        System.out.println(kolikoita(3, new long[] {0, 1, 1, 1}, new int[] {2, 1}, new int[] {1, 3})); //2
        System.out.println(kolikoita(4, new long[] {0, 1, 1, 1, 10}, new int[] {1, 2, 1}, new int[] {2, 3, 4})); //11
        System.out.println(kolikoita(4, new long[] {0, 1, 1, 1, 1}, new int[] {1, 1, 1}, new int[] {2, 3, 4})); //2
    }        
}

