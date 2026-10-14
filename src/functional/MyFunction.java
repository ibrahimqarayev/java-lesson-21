package functional;

interface MyFunction<T, R> {
    R apply(T t);

    default <V> MyFunction<T, V> andThen(MyFunction<R, V> after) {
        return t -> after.apply(this.apply(t));
    }
}
