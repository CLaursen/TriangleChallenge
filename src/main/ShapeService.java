package main;
public interface ShapeService<T> {
    public T create(int[] sides) throws Exception;
    public String getType(T shape);
}