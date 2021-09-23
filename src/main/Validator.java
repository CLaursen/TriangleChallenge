package main;
public interface Validator<T> {
    public boolean validate(T object);
}