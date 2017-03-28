import java.util.*;

public class Main {
    public static boolean onkoSyklia(int n, int[] mista, int[] minne) {
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(onkoSyklia(3, new int[] {1, 2, 3}, new int[] {2, 3, 1}));    // true
        System.out.println(onkoSyklia(3, new int[] {1, 2}, new int[] {2, 3}));          // false
        System.out.println(onkoSyklia(3, new int[] {1, 2, 1}, new int[] {2, 3, 3}));    // false
        System.out.println(onkoSyklia(4, new int[] {2, 3, 4}, new int[] {3, 4, 2}));    // true
    }        
}

