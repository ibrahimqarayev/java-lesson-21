package functional;

@FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> other) {
        return t -> this.test(t) && other.test(t);
    }

    default MyPredicate<T> or(MyPredicate<T> other) {
        return t -> this.test(t) || other.test(t);
    }

    default MyPredicate<T> negate() {
        return t -> !this.test(t);
    }
}