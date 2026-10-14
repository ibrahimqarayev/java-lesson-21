package functional;

@FunctionalInterface
interface MySupplier<T> {
    T get();
}