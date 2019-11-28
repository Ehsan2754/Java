package ir.ahuratus.Task9;


public final class Generics {
    public static <T extends Comparable> T max(T x, T y) {
        return x.compareTo(y)==1? x:y;
          }
}

