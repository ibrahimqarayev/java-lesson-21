package functional;

@FunctionalInterface
interface MyConsumer<T> {
    void accept(T t);

    default MyConsumer<T> andThen(MyConsumer<T> after) {
        return t -> {
            this.accept(t);
            after.accept(t);
        };
    }
}