package util;

public class PrintUtil {
    public static void print(int[] a) {
        System.out.println(a);
    }

    public static void print(Iterable iter) {
        int i = 0;
        System.out.print('[');
        for (final Object o : iter) {
            if (i > 0) {
                System.out.print(' ');
            }
            System.out.print(o);
            i ++;
        }
        System.out.println(']');
    }
}
