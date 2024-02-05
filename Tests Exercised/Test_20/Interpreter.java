

import java.util.function.Predicate;

public class Interpreter {

    public static <T> Predicate<T> and(Predicate<T>... ps) {
        Predicate<T> p = t -> true;
        for (Predicate<T> pr : ps)
            p = p.and(pr);
        return p;
    }

    public static <T> Predicate<T> or(Predicate<T>... ps) {
        Predicate<T> p = t -> false;
        for (Predicate<T> pr : ps)
            p = p.or(pr);
        return p;
    }

    public static <T> Predicate<T> xor(Predicate<T>... ps) {
        return t -> {
            Boolean b = false;
            for (Predicate<T> pr : ps)
                b ^= pr.test(t);
            return b;
        };
    }

    public static <T> Predicate<T> nand(Predicate<T>... ps) {
        return and(ps).negate();
    }

    public static <T> Predicate<T> nor(Predicate<T>... ps) {
        return or(ps).negate();
    }

    public static <T> Predicate<T> xnor(Predicate<T>... ps) {
        return xor(ps).negate();
    }
}
